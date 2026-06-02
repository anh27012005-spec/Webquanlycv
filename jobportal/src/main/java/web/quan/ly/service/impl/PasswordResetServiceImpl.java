package web.quan.ly.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.quan.ly.repository.PasswordResetRepository;
import web.quan.ly.service.PasswordResetService;
import web.quan.ly.entity.PasswordReset;

import java.util.List;

@Service
public class PasswordResetServiceImpl implements PasswordResetService {

    @Autowired
    private PasswordResetRepository passwordResetRepository;

    @Override
    public List<PasswordReset> getAll() {
        return passwordResetRepository.findAll();
    }

    @Override
    public PasswordReset getById(Integer id) {
        return passwordResetRepository.findById(id).orElse(null);
    }

    @Override
    public PasswordReset create(PasswordReset passwordReset) {
        return passwordResetRepository.save(passwordReset);
    }

    @Override
    public PasswordReset save(Integer id, PasswordReset passwordReset) {

        PasswordReset existing =
                passwordResetRepository.findById(id).orElse(null);

        if (existing == null) {
            return null;
        }

        existing.setEmail(passwordReset.getEmail());
        existing.setOtp(passwordReset.getOtp());
        existing.setExpired_at(passwordReset.getExpired_at());
        existing.setUsed(passwordReset.getUsed());

        return passwordResetRepository.save(existing);
    }

    @Override
    public void delete(Integer id) {
        passwordResetRepository.deleteById(id);
    }
}