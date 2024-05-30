package com.example.testbackendbank.controller.finance;

import com.example.testbackendbank.dto.request.finance.TransactionDtoForUser;
import com.example.testbackendbank.entity.Transaction;
import com.example.testbackendbank.service.finance.TransactionService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/transaction")
public class TransactionController {
    private final TransactionService transactionService;

    @PostMapping("/{id}")
    public ResponseEntity<Transaction> createTransactionUser(@PathVariable Integer id, HttpServletRequest request, @Valid @RequestBody TransactionDtoForUser transactionDto) throws UnsupportedEncodingException {
        transactionService.createTransactionUser(id, request,transactionDto);
        return ResponseEntity.ok().build();
    }
}
