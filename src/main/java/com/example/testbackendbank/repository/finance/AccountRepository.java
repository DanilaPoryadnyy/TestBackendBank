package com.example.testbackendbank.repository.finance;

import com.example.testbackendbank.entity.Account;
import com.example.testbackendbank.entity.UserInstance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
  List<Account> getAccountsByUserInstance(UserInstance userInstance);
  Account getAccountByUserInstance(UserInstance userInstance);
  Account getAccountById(Long id);
}