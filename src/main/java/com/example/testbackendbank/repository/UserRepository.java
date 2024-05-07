package com.example.testbackendbank.repository;

import com.example.testbackendbank.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}