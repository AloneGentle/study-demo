package com.example.studydemo.service;

import com.example.studydemo.entity.User;

import java.util.List;

public interface UserService {
    User registerUser(User user);

    User findByUsername(String username);

    User findById(Long id);

    User updateUser(User user);

    void deleteUser(Long id);

    List<User> getAllUsers();

    boolean authenticateUser(String username, String password);

}
