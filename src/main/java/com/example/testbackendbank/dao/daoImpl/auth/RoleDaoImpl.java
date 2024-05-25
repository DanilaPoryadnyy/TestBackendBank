package com.example.testbackendbank.dao.daoImpl.auth;

import com.example.testbackendbank.dao.daoInterface.auth.RoleDao;
import com.example.testbackendbank.entity.Role;
import com.example.testbackendbank.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class RoleDaoImpl implements RoleDao {

    private final RoleRepository roleRepository;

    @Override
    public Role getRoleByNamerole(String roleName) {
        return roleRepository.getRoleByNamerole(roleName);
    }
}
