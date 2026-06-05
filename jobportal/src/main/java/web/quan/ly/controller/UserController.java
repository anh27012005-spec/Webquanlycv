package web.quan.ly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import web.quan.ly.common.ApiResponse;
import web.quan.ly.entity.User;
import web.quan.ly.service.UserService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<User>>> getAll() {
        List<User> users = userService.getAll();
        return ResponseEntity.ok(ApiResponse.success(users));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<User>> getById(@PathVariable Integer id) {
        User user = userService.getById(id);
        return ResponseEntity.ok(ApiResponse.success(user));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<User>> create(@RequestBody User user) {
        User createdUser = userService.create(user);
        return ResponseEntity.ok(ApiResponse.success("Created successfully", createdUser));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<User>> update(@PathVariable Integer id,
                       @RequestBody User user) {

        User updatedUser = userService.update(id, user);
        return ResponseEntity.ok(ApiResponse.success("Updated successfully", updatedUser));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> delete(@PathVariable Integer id) {
        userService.delete(id);
        return ResponseEntity.ok(ApiResponse.success("Deleted successfully", "OK"));
    }

}
