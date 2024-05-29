package com.example.testbackendbank.dto.request.user;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class UserDataDto implements Serializable {
    private String snils;
    private String inn;
    private String passportSeries;
    private String passportNumber;
    private String phone;
    private String firstName;
    private String lastName;
    private String middleName;
    private LocalDate birthdate;
    private String address;
}