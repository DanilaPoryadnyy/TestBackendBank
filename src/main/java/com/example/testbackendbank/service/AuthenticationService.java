package com.example.testbackendbank.service;

import com.example.testbackendbank.dto.auth.AuthenticationRequest;
import com.example.testbackendbank.dto.auth.AuthenticationResponse;
import com.example.testbackendbank.dto.auth.RegisterRequest;
import com.example.testbackendbank.entity.Userinstance;
import com.example.testbackendbank.repository.RoleRepository;
import com.example.testbackendbank.repository.UserinstanceRepository;
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
    private final UserinstanceRepository userinstanceRepository;
    private final RoleRepository roleRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;

    public AuthenticationResponse register(RegisterRequest registerRequest) throws UnsupportedEncodingException {
        var user = new Userinstance();
        user.setEmail(registerRequest.getEmail());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        user.setIdrole(roleRepository.getRoleByNamerole("USER"));
        user.setRegistrationdate(LocalDate.now());
        userinstanceRepository.save(user);
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
        var user = userinstanceRepository.findByEmail(authenticationRequest.getEmail()).orElseThrow();//todo exception
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }
}
