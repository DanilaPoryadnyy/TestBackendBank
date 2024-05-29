package com.example.testbackendbank.dao.daoInterface.finance;

import com.example.testbackendbank.entity.AccountStatus;

public interface AccountStatusDao {
    AccountStatus getAccountStatusById(Integer id);
}
