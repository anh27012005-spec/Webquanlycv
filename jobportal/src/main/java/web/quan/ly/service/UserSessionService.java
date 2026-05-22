package web.quan.ly.service;

import web.quan.ly.entity.User_Session;
import web.quan.ly.entity.User;
import java.util.List;

public interface UserSessionService {

    List<User_Session> getAll();
    User_Session getById(Integer id);
    User_Session getByToken(String token);

    User_Session createSession(User user, String token);
    void revokeSession(String token);
    boolean isTokenValid(String token);
}