package web.quan.ly.service;

import web.quan.ly.dto.AuthResponse;
import web.quan.ly.dto.LoginRequest;
import web.quan.ly.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {


    List<User> getAll();

    User getById(Integer id);

    User create(User user);

    User update(Integer id, User user);

    void delete(Integer id);

    Optional<User> findByUsername(String username);

    AuthResponse login(LoginRequest request);
}