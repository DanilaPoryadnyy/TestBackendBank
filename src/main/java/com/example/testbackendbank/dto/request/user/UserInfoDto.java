package com.example.testbackendbank.dto.request.user;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserInfoDto {
    private String phone;
    private String firstName;
    private String lastName;
    private String middleName;
    private LocalDate birthdate;
}
