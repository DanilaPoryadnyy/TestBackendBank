package com.example.testbackendbank.service.user;

import com.example.testbackendbank.dao.daoImpl.auth.UserDataDaoImpl;
import com.example.testbackendbank.dao.daoInterface.auth.UserDao;
import com.example.testbackendbank.dao.daoInterface.auth.UserDataDao;
import com.example.testbackendbank.dto.request.user.UserDataDto;
import com.example.testbackendbank.entity.UserData;
import com.example.testbackendbank.entity.UserInstance;
import com.example.testbackendbank.service.auth.JwtService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;

@Service
@RequiredArgsConstructor
public class UserDataService {

    private final UserDataDaoImpl userDataDao;
    private final UserDao userDao;
    private final JwtService jwtService;

    private final ModelMapper modelMapper;

    public UserData getUserData(HttpServletRequest request) throws UnsupportedEncodingException {
        String email = jwtService.extractEmail(jwtService.resolveToken(request));
        UserInstance userInstance = userDao.getByEmail(email);

        return userDataDao.findByUserInstance(userInstance);
    }

    public UserData getUserDataByUserId(Integer userId){
        return userDataDao.findById(userId);
    }

    public void updateUserData(HttpServletRequest request, UserDataDto userDataDto) throws UnsupportedEncodingException {
        String email = jwtService.extractEmail(jwtService.resolveToken(request));
        UserData userData = userDataDao.findByUserInstance(userDao.getByEmail(email));

        modelMapper.map(userDataDto, userData);

        userDataDao.save(userData);
    }

    public UserData getUserDataByPhoneNumber(String phoneNumber){
        return userDataDao.getByPhone(phoneNumber);
    }

}
