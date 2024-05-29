package com.example.testbackendbank.service.finance;

import com.example.testbackendbank.dao.daoInterface.finance.AccountStatusDao;
import com.example.testbackendbank.entity.AccountStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountStatusService {
    private final AccountStatusDao accountStatusDao;

    public AccountStatus getAccountStatus(Integer id) {
        return accountStatusDao.getAccountStatusById(id);
    }
}
