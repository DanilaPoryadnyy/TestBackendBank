package com.example.testbackendbank.dao.daoInterface.auth;

import com.example.testbackendbank.entity.Role;

public interface RoleDao {
    Role getRoleByNamerole(String roleName);
}
