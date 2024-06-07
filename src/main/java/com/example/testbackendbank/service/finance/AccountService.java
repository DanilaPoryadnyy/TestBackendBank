package com.example.testbackendbank.service.finance;

import com.example.testbackendbank.dao.daoImpl.auth.UserDaoImpl;
import com.example.testbackendbank.dao.daoImpl.auth.UserDataDaoImpl;
import com.example.testbackendbank.dao.daoInterface.auth.UserDao;
import com.example.testbackendbank.dao.daoInterface.finance.AccountDao;
import com.example.testbackendbank.dto.request.finance.AccountDto;
import com.example.testbackendbank.dto.request.user.UserInfoDto;
import com.example.testbackendbank.entity.Account;
import com.example.testbackendbank.entity.UserData;
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
    private final BranchService branchService;
    private final JwtService jwtService;
    private final UserDao userDao;
    private final ModelMapper modelMapper;
    private final UserDaoImpl userDaoImpl;
    private final UserDataDaoImpl userDataDaoImpl;

    private List<Account> findAccountsByRequest(HttpServletRequest request) throws UnsupportedEncodingException {
        String email = jwtService.extractEmail(jwtService.resolveToken(request));
        UserInstance userInstance = userDao.getByEmail(email);
        return accountDao.getAccountsByUserInstance(userInstance);
    }

    List<Account> findAccountsById(Long id) throws UnsupportedEncodingException {
        UserInstance userInstance = userDao.getById(id);
        return accountDao.getAccountsByUserInstance(userInstance);
    }

    public Account findAccountByRequest(HttpServletRequest request) throws UnsupportedEncodingException {
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
        account.setBranch(branchService.getBranchById(accountDto.getBranch()));

        return accountDao.save(account);
    }

    public List<Account> getByUserInstance(HttpServletRequest request) throws UnsupportedEncodingException {
        return findAccountsByRequest(request);
    };

    public List<Account> getByUserInfo(UserInfoDto userInfoDto) throws UnsupportedEncodingException {
        UserData userData = userDataDaoImpl.findByPhoneAndFirstNameAndLastNameAndMiddleNameAndBirthdate(userInfoDto);
        UserInstance userInstance = userData.getUser();
        return accountDao.getAccountsByUserInstance(userInstance);
    }

    public Account getByUserInstance(UserInstance userInstance) {
        return accountDao.getAccountByUserInstance(userInstance);
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
        account.setBranch(branchService.getBranchById(accountDto.getBranch()));

        if(account.getUserInstance() == userInstance) {
            accountDao.save(account);
        }
        else {

        }
    }
    public void updateAccountByEmployee(AccountDto accountDto, Long id)
            throws UnsupportedEncodingException {
        Account account = accountDao.getAccountById(id);
        modelMapper.map(accountDto, account);
        account.setIdAccountStatus(accountStatusService.getAccountStatus(accountDto.getAccountStatus()));
        account.setIdAccountType(accountTypeService.getAccountTypeById(accountDto.getAccountType()));
        account.setBranch(branchService.getBranchById(accountDto.getBranch()));
        accountDao.save(account);
    }

    public void updateAccountForServices(Account account)
    {
        accountDao.save(account);
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
