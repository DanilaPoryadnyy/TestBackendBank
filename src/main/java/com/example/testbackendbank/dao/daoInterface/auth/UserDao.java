package com.example.testbackendbank.dao.daoInterface.auth;

import com.example.testbackendbank.entity.UserInstance;
import jakarta.servlet.http.HttpServletRequest;

public interface UserDao {
    UserInstance create(UserInstance userInstance);
    UserInstance getByEmail(HttpServletRequest httpRequest);
    UserInstance getByEmail(String email);
    UserInstance update(HttpServletRequest request, UserInstance userInstance);
    UserInstance delete(HttpServletRequest request);
}
