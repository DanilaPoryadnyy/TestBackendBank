package com.example.testbackendbank.dao.daoInterface.auth;

import com.example.testbackendbank.entity.UserData;
import com.example.testbackendbank.entity.UserInstance;
import jakarta.servlet.http.HttpServletRequest;

public interface UserDataDao {
    UserData save(UserData userData);
    UserData findByUserInstance(UserInstance userInstance);
    UserData findById(Integer id);
    UserData update(HttpServletRequest request, UserData userData);
    UserData delete(HttpServletRequest request);
}
