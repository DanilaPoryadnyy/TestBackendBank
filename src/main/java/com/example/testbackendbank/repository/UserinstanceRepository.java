package com.example.testbackendbank.repository;

import com.example.testbackendbank.entity.Userinstance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserinstanceRepository extends JpaRepository<Userinstance, Integer> {
    Optional<Userinstance> findByEmail(String email);
}