package web.quan.ly.service;

import web.quan.ly.entity.UserSession;
import web.quan.ly.entity.User;
import java.util.List;

public interface UserSessionService {

    List<UserSession> getAll();
    UserSession getById(Integer id);
    UserSession getByToken(String token);

    UserSession createSession(User user, String token);
    void revokeSession(String token);
    boolean isTokenValid(String token);
}