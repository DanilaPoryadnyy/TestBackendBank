package com.example.testbackendbank.entity;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "userdata")
public class UserData {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userdata_id_gen")
    @SequenceGenerator(name = "userdata_id_gen", sequenceName = "userdata_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private Userinstance user;

    @Column(name = "snils", length = 14)
    private String snils;

    @Column(name = "inn", length = 12)
    private String inn;

    @Column(name = "passport_series", length = 10)
    private String passportSeries;

    @Column(name = "passport_number", length = 10)
    private String passportNumber;

    @Column(name = "phone", length = 20)
    private String phone;

    @Column(name = "first_name", length = 50)
    private String firstName;

    @Column(name = "last_name", length = 50)
    private String lastName;

    @Column(name = "middle_name", length = 50)
    private String middleName;

    @Column(name = "birthdate")
    private LocalDate birthdate;

    @Column(name = "address", length = 255)
    private String address;
}

