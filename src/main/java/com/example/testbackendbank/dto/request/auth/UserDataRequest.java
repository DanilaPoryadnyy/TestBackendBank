package com.example.testbackendbank.dto.request.auth;

import com.example.testbackendbank.entity.Image;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class UserDataRequest {
    private Image idImage;
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
