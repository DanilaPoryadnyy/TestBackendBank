package com.example.testbackendbank.dao.daoImpl.finance;

import com.example.testbackendbank.dao.daoInterface.finance.AccountTypeDao;
import com.example.testbackendbank.entity.AccountType;
import com.example.testbackendbank.repository.finance.AccountTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class AccountTypeDaoImpl implements AccountTypeDao {
    private final AccountTypeRepository accountTypeRepository;

    @Override
    public AccountType getAccountTypeById(Long id) {
        return accountTypeRepository.findById(id).orElseThrow();//todo exception
    }
}
