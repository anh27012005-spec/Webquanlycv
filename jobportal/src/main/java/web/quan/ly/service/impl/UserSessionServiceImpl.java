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
    @Transactional
    public UserSession save(UserSession session) {

        Integer userId = session.getUser().getId();

        return userSessionRepository.findByUser_Id(userId)
                .map(existing -> {
                    existing.setToken(session.getToken());
                    existing.setExpiredAt(session.getExpiredAt());
                    return userSessionRepository.save(existing);
                })
                .orElseGet(() -> userSessionRepository.save(session));
    }

    @Override
    @Transactional(readOnly = true)
    public UserSession findByUserId(Integer userId) {
        return userSessionRepository.findByUser_Id(userId)
                .orElse(null);
    }

    @Override
    @Transactional
    public void revokeByToken(String token) {
        userSessionRepository.deleteByToken(token);
    }

    @Override
    @Transactional
    public void revokeAllByUserId(Integer userId) {
        List<UserSession> sessions =
                userSessionRepository.findAllByUser_Id(userId);

        userSessionRepository.deleteAll(sessions);
    }

    @Override
    @Transactional(readOnly = true)
    public UserSession findByToken(String token) {
        return userSessionRepository.findByTokenWithUser(token)
                .orElseThrow(() ->
                        new IllegalArgumentException("Token khong ton tai"));
    }

    @Override
    @Transactional(readOnly = true)
    public boolean isTokenValid(String token) {

        return userSessionRepository.findByToken(token)
                .map(session ->
                        session.getExpiredAt() != null
                                && session.getExpiredAt().isAfter(LocalDateTime.now()))
                .orElse(false);
    }

    @Override
    @Transactional
    public void logout(String token) {
        revokeByToken(token);
    }
}