package com.example.testbackendbank.dao.daoImpl.finance;

import com.example.testbackendbank.dao.daoInterface.finance.AccountDao;
import com.example.testbackendbank.entity.Account;
import com.example.testbackendbank.entity.UserInstance;
import com.example.testbackendbank.repository.finance.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class AccountDaoImpl implements AccountDao {

    private final AccountRepository accountRepository;

    @Override
    public Account save(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account getAccountById(long id) {
        return accountRepository.getAccountById(id);
    }

    @Override
    public List<Account> getAccountsByUserInstance(UserInstance userInstance) {
        return accountRepository.getAccountsByUserInstance(userInstance);
    }

    @Override
    public Account getAccountByUserInstance(UserInstance userInstance) {
        return accountRepository.getAccountByUserInstance(userInstance);
    }

    @Override
    public Account update(Account account) {
        return null;
    }

    @Override
    public void delete(Account account) {
        accountRepository.delete(account);
    }
}
