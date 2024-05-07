package com.example.testbackendbank.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
public class UserController {
    @GetMapping("/unsecured")
    public String unsecuredData() {
        return "unsecured";
    }
    @GetMapping("/secured")
    public String securedData() {
        return "secured";
    }
    @GetMapping("/admin")
    public String adminData() {
        return "admin";
    }
    @GetMapping("/info")
    public String userData(Principal principal) {
        return principal.getName();
    }
}
