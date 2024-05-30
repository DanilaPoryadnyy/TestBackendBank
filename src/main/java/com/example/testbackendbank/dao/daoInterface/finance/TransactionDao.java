package com.example.testbackendbank.dao.daoInterface.finance;

import com.example.testbackendbank.entity.Account;
import com.example.testbackendbank.entity.Transaction;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

public interface TransactionDao {
    Transaction insert(Transaction transaction);
    List<Transaction> getAllTransactions(HttpServletRequest request);
    Transaction getTransactionByFromAccount(Account fromAccount);
    Transaction getTransactionByToAccount(Account toAccount);
}
