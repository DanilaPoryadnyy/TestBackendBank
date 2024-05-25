package com.example.testbackendbank.dto.request.user;

import lombok.Value;

import java.io.Serializable;
import java.time.LocalDate;

@Value
public class UserDataDto implements Serializable {
    String snils;
    String inn;
    String passportSeries;
    String passportNumber;
    String phone;
    String firstName;
    String lastName;
    String middleName;
    LocalDate birthdate;
    String address;
}