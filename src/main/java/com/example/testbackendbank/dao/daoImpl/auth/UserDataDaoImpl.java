package com.example.testbackendbank.dao.daoImpl.auth;

import com.example.testbackendbank.dao.daoInterface.auth.UserDataDao;
import com.example.testbackendbank.entity.UserData;
import com.example.testbackendbank.entity.UserInstance;
import com.example.testbackendbank.repository.UserDataRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class UserDataDaoImpl implements UserDataDao {

    private final UserDataRepository userDataRepository;

    @Override
    public UserData create(UserData userData) {
        return userDataRepository.save(userData);
    }

    @Override
    public UserData findByUserInstance(UserInstance userInstance) {
        return userDataRepository.findByUser(userInstance);
    }

    @Override
    public UserData update(HttpServletRequest request, UserData userData) {
        return userDataRepository.save(userData);
    }

    @Override
    public UserData delete(HttpServletRequest request) {
        return null;
    }
}
