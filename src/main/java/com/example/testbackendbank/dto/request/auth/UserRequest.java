package com.example.testbackendbank.dto.request.auth;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    @NotNull
    @NotBlank(message = "email should not blank")
    private String email;

    @NotNull
    @NotBlank(message = "password should not blank")
    private String password;
}
