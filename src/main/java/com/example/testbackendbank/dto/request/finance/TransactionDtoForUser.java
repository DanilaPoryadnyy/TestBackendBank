package com.example.testbackendbank.dto.request.finance;

import jakarta.validation.constraints.Pattern;
import lombok.Value;

import java.io.Serializable;
import java.time.OffsetDateTime;

@Value
public class TransactionDtoForUser implements Serializable {
    String transactionType;
    @Pattern(regexp = "^\\+7\\d{10}$", message = "Номер телефона должен начинаться с +7 и содержать 10 цифр")
    String phoneNumber;
    Long amount;
    OffsetDateTime createdAt;
}