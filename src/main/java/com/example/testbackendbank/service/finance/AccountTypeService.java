package com.example.testbackendbank.service.finance;

import com.example.testbackendbank.dao.daoInterface.finance.AccountTypeDao;
import com.example.testbackendbank.entity.AccountType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountTypeService {
    private final AccountTypeDao accountTypeDao;

    public AccountType getAccountTypeById(Long accountTypeId) {
        return accountTypeDao.getAccountTypeById(accountTypeId);
    }
}
