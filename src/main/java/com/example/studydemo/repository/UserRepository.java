package com.example.studydemo.repository;

import com.example.studydemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long>{
    User findByUsername(String username);
}

