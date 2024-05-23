package com.example.testbackendbank.controller;

import com.example.testbackendbank.dto.auth.AuthenticationRequest;
import com.example.testbackendbank.dto.auth.AuthenticationResponse;
import com.example.testbackendbank.dto.auth.RegisterRequest;
import com.example.testbackendbank.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationService authenticationService;
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request) throws UnsupportedEncodingException {
        return  ResponseEntity.ok(authenticationService.register(request));
    }
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> auth(
            @RequestBody AuthenticationRequest request
    ) throws UnsupportedEncodingException {
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }
}
