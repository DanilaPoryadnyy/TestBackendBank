package com.example.testbackendbank.repository;

import com.example.testbackendbank.entity.UserInstance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserInstanceRepository extends JpaRepository<UserInstance, Integer> {
    Optional<UserInstance> findByEmail(String email);

    UserInstance findById(Long id);
}