package com.example.testbackendbank.dto.request.finance;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;

@Data
public class AccountDto implements Serializable {
    private Long balance = 0L;

    @NotNull
    private Integer accountStatus;

    @NotNull
    private Long accountType;

    @NotNull
    private Integer branch;

    @NotNull
    @NotBlank(message = "currency should not blank")
    private String currency;
}