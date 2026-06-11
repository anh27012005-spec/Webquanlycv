package web.quan.ly.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;

import web.quan.ly.security.JwtUtil;
import web.quan.ly.common.*;
import web.quan.ly.dto.AuthResponse;
import web.quan.ly.dto.LoginRequest;
import web.quan.ly.dto.UserRequest;
import web.quan.ly.entity.*;
import web.quan.ly.repository.*;
import web.quan.ly.service.UserService;
import web.quan.ly.service.UserSessionService;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserSessionService userSessionService;

    @Autowired
    private UserSessionRepository userSessionRepository;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User create(User user) {

        if (user.getRole() == null) {
            Role candidateRole = roleRepository.findByName(Constants.ROLE_CANDIDATE);
            if (candidateRole == null) {
                throw new NotFoundException("Role CANDIDATE khong ton tai");
            }
            user.setRole(candidateRole);
        }

        return userRepository.save(user);
    }

    @Override
    public Response<User> createV2(User user) {

        if (user == null) {
            return new Response(401, "Dữ liệu bị rỗng!", null);
        }

        if (user.getEmail().isEmpty()) {
            return new Response(401, "Email bị rỗng!", null);
        }

        if (user.getRole() == null) {
            Role candidateRole = roleRepository.findByName(Constants.ROLE_CANDIDATE);
            if (candidateRole == null) {
                throw new NotFoundException("Role CANDIDATE khong ton tai");
            }
            user.setRole(candidateRole);
        }

        userRepository.save(user);

        return new Response(200, "Tạo mới thành công", user);
    }

    @Override
    public User update(Integer id, User user) {

        User oldUser = userRepository.findById(id).orElse(null);

        if (oldUser != null) {
            oldUser.setName(user.getName());
            oldUser.setEmail(user.getEmail());
            return userRepository.save(oldUser);
        }

        return null;
    }

    @Override
    public void delete(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public User create(UserRequest request) {

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new ValidationException("Email da ton tai");
        }

        if (userRepository.existsBySdt(request.getSdt())) {
            throw new ValidationException("So dien thoai da ton tai");
        }

        Role candidateRole = roleRepository.findByName(Constants.ROLE_CANDIDATE);
        if (candidateRole == null) {
            throw new NotFoundException("Role CANDIDATE khong ton tai");
        }

        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setSdt(request.getSdt());
        user.setRole(candidateRole);

        return userRepository.save(user);
    }

    @Override
    public AuthResponse login(LoginRequest request) {

        Optional<User> userOpt = findByUsername(request.getUsername());

        if (userOpt.isEmpty()) {
            throw new NotFoundException(Constants.ACCOUNT_NOT_FOUND);
        }

        User user = userOpt.get();

        if (!Objects.equals(user.getPassHash(), request.getPassHash())) {
            throw new AuthException(Constants.PASSWORD_INCORRECT);
        }

        String token = jwtUtil.generateToken(user.getUsername());

        UserSession userSession =
                userSessionService.findByUserId(user.getId());

        if (userSession == null) {
            userSession = new UserSession();
            userSession.setUser(user);
        }

        userSession.setToken(token);
        userSession.setExpiredAt(LocalDateTime.now().plusDays(1));
        userSession.setUser(user);

        userSessionService.save(userSession);

        AuthResponse response = new AuthResponse();
        response.setToken(token);

        return response;
    }

    @Override
    public void logout(String token) {
        userSessionService.revokeByToken(token);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}