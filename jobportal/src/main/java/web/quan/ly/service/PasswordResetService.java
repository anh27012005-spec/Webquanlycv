package web.quan.ly.service;

import web.quan.ly.entity.PasswordReset;

import java.util.List;

public interface PasswordResetService {

    List<PasswordReset> getAll();

    PasswordReset getById(Integer id);

    PasswordReset create(PasswordReset passwordReset);

    PasswordReset save(Integer id, PasswordReset passwordReset);

    void delete(Integer id);
}