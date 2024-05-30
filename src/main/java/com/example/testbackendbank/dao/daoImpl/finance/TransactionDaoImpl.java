package com.example.testbackendbank.dao.daoImpl.finance;

import com.example.testbackendbank.dao.daoInterface.finance.TransactionDao;
import com.example.testbackendbank.entity.Account;
import com.example.testbackendbank.entity.Transaction;
import com.example.testbackendbank.repository.finance.TransactionRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class TransactionDaoImpl implements TransactionDao {
    private final TransactionRepository transactionRepository;

    @Override
    public Transaction insert(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public List<Transaction> getAllTransactions(HttpServletRequest request) {
        return transactionRepository.findAll();
    }

    @Override
    public Transaction getTransactionByFromAccount(Account fromAccount) {
        return transactionRepository.findByFromAccountId(fromAccount);
    }

    @Override
    public Transaction getTransactionByToAccount(Account toAccount) {
        return transactionRepository.findByToAccountId(toAccount);
    }
}
