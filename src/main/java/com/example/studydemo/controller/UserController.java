package com.example.studydemo.controller;

import com.example.studydemo.entity.User;
import com.example.studydemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;
    private final String SESSION_KEY_PREFIX = "user_session:";
    private final long SESSION_EXPIRATION_SECONDS = 3600; // Session 过期时间，单位为秒

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @GetMapping("/{username}")
    public User getUserByUsername(@PathVariable String username) {
        return userService.findByUsername(username);
    }

    @GetMapping
    public List<User> getAllUser(){
        return userService.getAllUsers();
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        // 先根据id查找用户
        User existingUser = userService.findById(id);
        if (existingUser != null) {
            // 更新用户信息
            existingUser.setUsername(updatedUser.getUsername());
            existingUser.setPassword(updatedUser.getPassword());
            // 可以根据需要更新更多的用户信息
            return userService.updateUser(existingUser);
        } else {
            // 如果找不到用户，则返回null或抛出异常
            return null; // 或者抛出异常
        }
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String username, @RequestParam String password) {
        // 验证用户名和密码
        boolean isAuthenticated = userService.authenticateUser(username, password);

        // 如果验证成功，返回成功消息
        if (isAuthenticated) {
            return ResponseEntity.ok("Login successful");
        } else {
            // 如果验证失败，返回错误消息
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
    }
}
