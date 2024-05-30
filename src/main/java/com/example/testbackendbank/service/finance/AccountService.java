package com.example.testbackendbank.service.finance;

import com.example.testbackendbank.dao.daoInterface.auth.UserDao;
import com.example.testbackendbank.dao.daoInterface.finance.AccountDao;
import com.example.testbackendbank.dto.request.finance.AccountDto;
import com.example.testbackendbank.entity.Account;
import com.example.testbackendbank.entity.UserInstance;
import com.example.testbackendbank.service.auth.JwtService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountDao accountDao;
    private final AccountStatusService accountStatusService;
    private final AccountTypeService accountTypeService;
    private final JwtService jwtService;
    private final UserDao userDao;
    private final ModelMapper modelMapper;

    private List<Account> findAccountsByRequest(HttpServletRequest request) throws UnsupportedEncodingException {
        String email = jwtService.extractEmail(jwtService.resolveToken(request));
        UserInstance userInstance = userDao.getByEmail(email);
        return accountDao.getAccountsByUserInstance(userInstance);
    }
    private Account findAccountByRequest(HttpServletRequest request) throws UnsupportedEncodingException {
        String email = jwtService.extractEmail(jwtService.resolveToken(request));
        UserInstance userInstance = userDao.getByEmail(email);
        return accountDao.getAccountByUserInstance(userInstance);
    }

    private UserInstance findUserInstanceByRequest(HttpServletRequest request) throws UnsupportedEncodingException {
        String email = jwtService.extractEmail(jwtService.resolveToken(request));
        return userDao.getByEmail(email);
    }

    public Account createAccount(HttpServletRequest request, AccountDto accountDto) throws UnsupportedEncodingException {
        UserInstance userInstance = findUserInstanceByRequest(request);

        Account account = modelMapper.map(accountDto, Account.class);
        account.setUserInstance(userInstance);
        account.setIdAccountStatus(accountStatusService.getAccountStatus(accountDto.getAccountStatus()));
        account.setIdAccountType(accountTypeService.getAccountTypeById(accountDto.getAccountType()));

        return accountDao.save(account);
    }

    public List<Account> getByUserInstance(HttpServletRequest request) throws UnsupportedEncodingException {
        return findAccountsByRequest(request);
    };

    public Account getById(Long id, HttpServletRequest request) throws UnsupportedEncodingException {
        UserInstance userInstance = findUserInstanceByRequest(request);
        Account account = accountDao.getAccountById(id);
        if(account.getUserInstance() == userInstance){
            return accountDao.getAccountById(id);
        }
        return null;
    }

    public void updateAccount(HttpServletRequest request, AccountDto accountDto, Long id) throws UnsupportedEncodingException {
        UserInstance userInstance = findUserInstanceByRequest(request);
        Account account = accountDao.getAccountById(id);
        modelMapper.map(accountDto, account);
        account.setIdAccountStatus(accountStatusService.getAccountStatus(accountDto.getAccountStatus()));
        account.setIdAccountType(accountTypeService.getAccountTypeById(accountDto.getAccountType()));

        if(account.getUserInstance() == userInstance) {
            accountDao.save(account);
        }
        else {

        }
    }

    public ResponseEntity<?> deleteAccount(HttpServletRequest request, Long id) throws UnsupportedEncodingException {
        UserInstance userInstance = findUserInstanceByRequest(request);
        Account account = accountDao.getAccountById(id);
        
        if(account.getUserInstance() == userInstance){
            accountDao.delete(account);
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }

}
