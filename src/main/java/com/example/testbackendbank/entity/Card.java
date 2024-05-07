package com.example.testbackendbank.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "cards")
public class Card {
    @Id
    @Column(name = "card_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account account;

    @Column(name = "card_type", length = 50)
    private String cardType;

    @Column(name = "card_number", length = 16)
    private String cardNumber;

    @Column(name = "expiry_date")
    private LocalDate expiryDate;

    @Column(name = "cvv_code", length = 3)
    private String cvvCode;

    @Column(name = "card_status", length = 20)
    private String cardStatus;

}