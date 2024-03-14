package com.example.studydemo.service;

import com.example.studydemo.entity.User;
import com.example.studydemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User registerUser(User user) {
        // 这里可以添加用户注册的逻辑，例如密码加密等
        return userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User updateUser(User user) {
        // 更新用户信息
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public boolean authenticateUser(String username, String password) {
        // 根据用户名查询用户信息
        User user = userRepository.findByUsername(username);

        // 判断用户是否存在且密码是否匹配
        return user != null && user.getPassword().equals(password);
    }
}
