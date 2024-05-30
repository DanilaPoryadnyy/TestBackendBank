package com.example.testbackendbank.service.finance;

import com.example.testbackendbank.dao.daoInterface.finance.TransactionDao;
import com.example.testbackendbank.dto.request.finance.TransactionDtoForUser;
import com.example.testbackendbank.entity.Account;
import com.example.testbackendbank.entity.Transaction;
import com.example.testbackendbank.entity.UserData;
import com.example.testbackendbank.service.user.UserDataService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionService {
    private final TransactionDao transactionDao;
    private final AccountService accountService;
    private final UserDataService userDataService;

    public void createTransactionUser(Integer id, HttpServletRequest request, TransactionDtoForUser transactionUserDto) throws UnsupportedEncodingException {
        Account fromAccount = accountService.getById(Long.valueOf(id),request);

        UserData toUserData = userDataService.getUserDataByPhoneNumber(transactionUserDto.getPhoneNumber());

        List<Account> accountList = accountService.findAccountsById(Long.valueOf(toUserData.getUser().getId()));

        Account toAccount = accountList.get(0);

        fromAccount.setBalance(fromAccount.getBalance() - transactionUserDto.getAmount());
        toAccount.setBalance(toAccount.getBalance() + transactionUserDto.getAmount());

        accountService.updateAccountForServices(fromAccount);
        accountService.updateAccountForServices(toAccount);

        Transaction transaction = new Transaction();
        transaction.setFromAccount(fromAccount);
        transaction.setToAccount(toAccount);
        transaction.setAmount(transactionUserDto.getAmount());
        transaction.setTransactionType(transactionUserDto.getTransactionType());
        transaction.setCreatedAt(LocalDate.now());

        transactionDao.insert(transaction);
    }
}
