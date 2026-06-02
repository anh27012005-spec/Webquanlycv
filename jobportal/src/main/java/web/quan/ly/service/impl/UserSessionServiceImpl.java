package web.quan.ly.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.quan.ly.entity.User;
import web.quan.ly.entity.UserSession;
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
    public List<UserSession> getAll() {
        return userSessionRepository.findAll();
    }

    @Override
    public UserSession getById(Integer id) {
        return userSessionRepository.findById(id).orElse(null);
    }

    @Override
    public UserSession getByToken(String token) {
        return userSessionRepository.findByToken(token).orElse(null);
    }

    @Override
    public UserSession createSession(User user, String token) {
        UserSession session = new UserSession();
        session.setUser(user);
        session.setToken(token);
        session.setRevoked(false);
        session.setExpiredAt(LocalDate.now().plusDays(1));
        return userSessionRepository.save(session);
    }

    @Override
    public void revokeSession(String token) {
        Optional<UserSession> sessionOpt = userSessionRepository.findByToken(token);
        if (sessionOpt.isPresent()) {
            UserSession session = sessionOpt.get();
            session.setRevoked(true);
            userSessionRepository.save(session);
        }
    }

    @Override
    public boolean isTokenValid(String token) {
        Optional<UserSession> sessionOpt = userSessionRepository.findByToken(token);
        if (sessionOpt.isEmpty()) {
            return false;
        }
        UserSession session = sessionOpt.get();
        boolean isNotRevoked = !Boolean.TRUE.equals(session.getRevoked());
        boolean isNotExpired = session.getExpiredAt().isAfter(LocalDate.now());
        return isNotRevoked && isNotExpired;
    }
}