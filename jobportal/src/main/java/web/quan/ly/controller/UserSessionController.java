package web.quan.ly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.quan.ly.entity.User_Session;
import web.quan.ly.service.UserSessionService;

import java.util.List;

@RestController
@RequestMapping("/api/user_session")
public class UserSessionController {

    @Autowired
    private UserSessionService userSessionService;

    @GetMapping
    public List<User_Session> getAll() {
        return userSessionService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User_Session> getById(@PathVariable Integer id) {
        User_Session session = userSessionService.getById(id);
        if (session == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(session);
    }

    @GetMapping("/validate")
    public ResponseEntity<Boolean> validateToken(@RequestParam String token) {
        boolean isValid = userSessionService.isTokenValid(token);
        return ResponseEntity.ok(isValid);
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(@RequestParam String token) {
        userSessionService.revokeSession(token);
        return ResponseEntity.ok("Success");
    }
}