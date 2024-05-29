package com.example.testbackendbank.controller.finance;

import com.example.testbackendbank.dto.request.finance.AccountDto;
import com.example.testbackendbank.entity.Account;
import com.example.testbackendbank.service.finance.AccountService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/account")
public class AccountController {
    private final AccountService accountService;

    @PostMapping
    public ResponseEntity<Account> createAccount(@Valid @RequestBody AccountDto accountDto, HttpServletRequest request) throws UnsupportedEncodingException {
        return new ResponseEntity<>(accountService.createAccount(request, accountDto), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<Account>> getAccountByUserInstance(HttpServletRequest request) throws UnsupportedEncodingException {
        return ResponseEntity.ok(accountService.getByUserInstance(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable Long id, HttpServletRequest request) throws UnsupportedEncodingException {
        return ResponseEntity.ok(accountService.getById(id, request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Account> updateProduct(HttpServletRequest request, @Valid @RequestBody AccountDto accountDto,@PathVariable Long id) throws UnsupportedEncodingException {
        return new ResponseEntity<>(accountService.updateAccount(request, accountDto,id), HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> removeProduct(HttpServletRequest request, @PathVariable Long id) throws UnsupportedEncodingException {
        accountService.deleteAccount(request, id);
        return ResponseEntity.noContent().build();
    }
}
