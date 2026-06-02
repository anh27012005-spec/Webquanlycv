package web.quan.ly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import web.quan.ly.entity.PasswordReset;
import web.quan.ly.service.PasswordResetService;

import java.util.List;

@RestController
@RequestMapping("/password-reset")
public class PasswordResetController {

    @Autowired
    private PasswordResetService passwordResetService;

    @GetMapping
    public List<PasswordReset> getAll() {
        return passwordResetService.getAll();
    }

    @GetMapping("/{id}")
    public PasswordReset getById(@PathVariable Integer id) {
        return passwordResetService.getById(id);
    }

    @PostMapping
    public PasswordReset create(
            @RequestBody PasswordReset passwordReset) {

        return passwordResetService.create(passwordReset);
    }

    @PutMapping("/{id}")
    public PasswordReset save(
            @PathVariable Integer id,
            @RequestBody PasswordReset passwordReset) {

        return passwordResetService.save(id, passwordReset);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        passwordResetService.delete(id);
    }
}