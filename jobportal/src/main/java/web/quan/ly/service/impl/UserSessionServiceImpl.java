package web.quan.ly.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.quan.ly.entity.User;
import web.quan.ly.entity.User_Session;
import web.quan.ly.repository.UserSessionRepository;
import web.quan.ly.service.UserSessionService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class UserSessionServiceImpl implements UserSessionService {
    @Autowired
    private UserSessionRepository userSessionRepository;

    @Override
    public List<User_Session> getAll() {
        return userSessionRepository.findAll();
    }

    @Override
    public User_Session getById(Integer id) {
        return userSessionRepository.findById(id).orElse(null);
    }

    @Override
    public User_Session getByToken(String token) {
        return userSessionRepository.findByToken(token).orElse(null);
    }

    @Override
    public User_Session createSession(User user, String token) {
        User_Session session = new User_Session();
        session.setUser(user);
        session.setToken(token);
        session.setRevoked(false);
        session.setExpiredAt(LocalDate.now().plusDays(1));
        return userSessionRepository.save(session);
    }

    @Override
    public void revokeSession(String token) {
        Optional<User_Session> sessionOpt = userSessionRepository.findByToken(token);
        if (sessionOpt.isPresent()) {
            User_Session session = sessionOpt.get();
            session.setRevoked(true);
            userSessionRepository.save(session);
        }
    }

    @Override
    public boolean isTokenValid(String token) {
        Optional<User_Session> sessionOpt = userSessionRepository.findByToken(token);
        if (sessionOpt.isEmpty()) {
            return false;
        }
        User_Session session = sessionOpt.get();
        boolean isNotRevoked = !Boolean.TRUE.equals(session.getRevoked());
        boolean isNotExpired = session.getExpiredAt().isAfter(LocalDate.now());
        return isNotRevoked && isNotExpired;
    }
}