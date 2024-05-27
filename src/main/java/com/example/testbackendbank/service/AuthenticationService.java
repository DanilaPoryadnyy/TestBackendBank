package com.example.testbackendbank.service;

import com.example.testbackendbank.dao.daoImpl.auth.RoleDaoImpl;
import com.example.testbackendbank.dao.daoImpl.auth.UserDaoImpl;
import com.example.testbackendbank.dao.daoImpl.auth.UserDataDaoImpl;
import com.example.testbackendbank.dto.request.auth.AuthenticationRequest;
import com.example.testbackendbank.dto.response.auth.AuthenticationResponse;
import com.example.testbackendbank.dto.request.auth.UserRequest;
import com.example.testbackendbank.entity.UserData;
import com.example.testbackendbank.entity.UserInstance;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserDaoImpl userDaoImpl;
    private final RoleDaoImpl roleDaoImpl;
    private final UserDataDaoImpl userDataDaoImpl;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;

    public AuthenticationResponse register(UserRequest userRequest) throws UnsupportedEncodingException {
        var user = new UserInstance();
        user.setEmail(userRequest.getEmail());
        user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        user.setIdrole(roleDaoImpl.getRoleByNamerole("USER"));
        user.setRegistrationdate(LocalDate.now());
        userDaoImpl.create(user);

        var userData = new UserData();

        userData.setUser(user);
        userDataDaoImpl.create(userData);

        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) throws UnsupportedEncodingException {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getEmail(),
                        authenticationRequest.getPassword()
                )
        );
        var user = userDaoImpl.getByEmail(authenticationRequest.getEmail());
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }
}
