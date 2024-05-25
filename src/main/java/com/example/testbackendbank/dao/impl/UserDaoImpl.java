package com.example.testbackendbank.dao.impl;

import com.example.testbackendbank.dao.daoInterface.UserDao;
import com.example.testbackendbank.entity.UserInstance;
import com.example.testbackendbank.repository.UserInstanceRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserDaoImpl implements UserDao {
    private final UserInstanceRepository userInstanceRepository;

    private UserInstance getUserInstance(String email) {
        return userInstanceRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    @Override
    public UserInstance create(UserInstance userInstance) {
        return userInstanceRepository.save(userInstance);
    }

    @Override
    public UserInstance getByEmail(HttpServletRequest httpRequest) {
        String email = httpRequest.getParameter("email");
        return getUserInstance(email);
    }

    @Override
    public UserInstance getByEmail(String email) {
        return getUserInstance(email);
    }

    @Override
    public UserInstance update(HttpServletRequest request, UserInstance userInstance) {
        return null;
    }

    @Override
    public UserInstance delete(HttpServletRequest request) {
        return null;
    }
}
