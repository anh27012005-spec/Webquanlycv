package web.quan.ly.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.quan.ly.common.AuthException;
import web.quan.ly.common.ValidationException;
import web.quan.ly.common.NotFoundException;
import web.quan.ly.common.Constants;
import web.quan.ly.dto.AuthResponse;
import web.quan.ly.dto.LoginRequest;
import web.quan.ly.entity.User;
import web.quan.ly.repository.UserRepository;
import web.quan.ly.service.UserService;
import web.quan.ly.service.UserSessionService;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private UserSessionService userSessionService;

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
        return userRepository.save(user);
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
    public AuthResponse login(LoginRequest request) {
        
        // Validate input
        if (request.getUsername() == null || request.getUsername().trim().isEmpty()) {
            throw new ValidationException(Constants.USERNAME_REQUIRED);
        }
        if (request.getPassHash() == null || request.getPassHash().trim().isEmpty()) {
            throw new ValidationException(Constants.PASSWORD_REQUIRED);
        }

        User user = findByUsername(request.getUsername());

        if (!user.getPassHash().equals(request.getPassHash())) {
            throw new AuthException(Constants.PASSWORD_INCORRECT);
        }

        // Generate token
        String token = UUID.randomUUID().toString();
        
        // Create session
        userSessionService.createSession(user, token);

        AuthResponse response = new AuthResponse();
        response.setMessage(Constants.AUTH_SUCCESS);
        response.setToken(token);

        return response;
    }

    @Override
    public User findByUsername(String username) {
        return userRepository
                .findByUsername(username)
                .orElseThrow(() -> new NotFoundException(Constants.ACCOUNT_NOT_FOUND));
    }
}