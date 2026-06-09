package web.quan.ly.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.quan.ly.entity.UserSession;
import web.quan.ly.repository.UserSessionRepository;
import web.quan.ly.service.UserSessionService;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserSessionServiceImpl implements UserSessionService {

    @Autowired
    private UserSessionRepository userSessionRepository;

    @Override
    public UserSession save(UserSession session) {
        return userSessionRepository.save(session);
    }

    @Override
    public UserSession findByToken(String token) {
        return userSessionRepository.findByToken(token)
                .orElseThrow(() -> new RuntimeException("Token khong tim thay "));
    }

    @Override
    @Transactional
    public void revokeByToken(String token) {
        UserSession session = findByToken(token);
        session.setRevoked(true);
        userSessionRepository.save(session);
    }

    @Override
    @Transactional
    public void revokeAllByUserId(Integer userId) {
        List<UserSession> sessions =
                userSessionRepository.findByUser_IdAndRevokedFalse(userId);

        sessions.forEach(s -> s.setRevoked(true));

        userSessionRepository.saveAll(sessions);
    }

    @Override
    public boolean isTokenValid(String token) {
        return userSessionRepository.findByToken(token)
                .map(s -> !s.isRevoked()
                        && (s.getExpiredAt() == null ||
                        s.getExpiredAt().isAfter(LocalDateTime.now())))
                .orElse(false);
    }

    @Override
    public void logout(String token) {
        revokeByToken(token);
    }
}