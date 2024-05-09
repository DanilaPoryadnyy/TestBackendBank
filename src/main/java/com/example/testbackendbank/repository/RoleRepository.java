package com.example.testbackendbank.repository;

import com.example.testbackendbank.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role getRoleByNamerole(String namerole);
}