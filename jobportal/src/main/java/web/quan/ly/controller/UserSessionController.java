package web.quan.ly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.quan.ly.service.UserSessionService;

@RestController
@RequestMapping("/api/sessions")
public class UserSessionController {

    @Autowired
    private UserSessionService userSessionService;

    @GetMapping
    public ResponseEntity<?> validate(@RequestParam String token) {
        boolean valid = userSessionService.isTokenValid(token);
        return ResponseEntity.ok(valid);
    }

    // revoke 1 token
    @PostMapping("/revoke")
    public ResponseEntity<?> revoke(@RequestParam String token) {
        userSessionService.revokeByToken(token);
        return ResponseEntity.ok("Token revoked");
    }

    // revoke all sessions of user
    @PostMapping("/revoke-all/{userId}")
    public ResponseEntity<?> revokeAll(@PathVariable Integer userId) {
        userSessionService.revokeAllByUserId(userId);
        return ResponseEntity.ok("All sessions revoked");
    }
}