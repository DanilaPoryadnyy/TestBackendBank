package com.example.testbackendbank.dto.request.user;

import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class UserDataDto implements Serializable {
    private String snils;
    private String inn;
    private String passportSeries;
    private String passportNumber;
    @Pattern(regexp = "^\\+7\\d{10}$", message = "Номер телефона должен начинаться с +7 и содержать 10 цифр")
    private String phone;
    private String firstName;
    private String lastName;
    private String middleName;
    private LocalDate birthdate;
    private String address;
}