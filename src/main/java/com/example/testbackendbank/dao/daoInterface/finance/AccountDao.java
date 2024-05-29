package com.example.testbackendbank.dao.daoInterface.finance;

import com.example.testbackendbank.entity.Account;
import com.example.testbackendbank.entity.UserInstance;

import java.util.List;

public interface AccountDao {
    Account save(Account account);
    Account getAccountById(long id);
    List<Account> getAccountsByUserInstance(UserInstance userInstance);
    Account getAccountByUserInstance(UserInstance userInstance);
    Account update(Account account);
    void delete(Account account);
}
