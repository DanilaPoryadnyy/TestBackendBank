package com.example.testbackendbank.repository.finance;

import com.example.testbackendbank.entity.Account;
import com.example.testbackendbank.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    Transaction findByFromAccountId(Account fromAccount);
    Transaction findByToAccountId(Account toAccount);
}