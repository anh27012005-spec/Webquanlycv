package web.quan.ly.service;

import web.quan.ly.entity.UserSession;

public interface UserSessionService {

    UserSession save(UserSession session);

    UserSession findByToken(String token);

    void revokeByToken(String token);

    void revokeAllByUserId(Integer userId);

    boolean isTokenValid(String token);

    void logout(String token);
}