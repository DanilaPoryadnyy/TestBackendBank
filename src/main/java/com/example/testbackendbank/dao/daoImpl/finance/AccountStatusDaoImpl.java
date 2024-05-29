package com.example.testbackendbank.dao.daoImpl.finance;

import com.example.testbackendbank.dao.daoInterface.finance.AccountStatusDao;
import com.example.testbackendbank.entity.AccountStatus;
import com.example.testbackendbank.repository.finance.AccountStatusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class AccountStatusDaoImpl implements AccountStatusDao {

    private final AccountStatusRepository accountStatusRepository;


    @Override
    public AccountStatus getAccountStatusById(Integer id) {
        return accountStatusRepository.findById(id).orElseThrow();
    }
}
