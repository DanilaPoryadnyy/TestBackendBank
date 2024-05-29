package com.example.testbackendbank.controller.auth;

import com.example.testbackendbank.dto.request.auth.AuthenticationRequest;
import com.example.testbackendbank.dto.response.auth.AuthenticationResponse;
import com.example.testbackendbank.dto.request.auth.UserRequest;
import com.example.testbackendbank.service.auth.AuthenticationService;
import jakarta.validation.Valid;
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
    public ResponseEntity<?> register(@Valid @RequestBody UserRequest request) throws UnsupportedEncodingException {
        ResponseEntity<?> responseEntity = authenticationService.register(request);
        return ResponseEntity.status(responseEntity.getStatusCode()).body(responseEntity.getBody());
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> auth(
            @Valid @RequestBody AuthenticationRequest request
    ) throws UnsupportedEncodingException {
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }
}
