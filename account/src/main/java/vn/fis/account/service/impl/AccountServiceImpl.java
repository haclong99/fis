package vn.fis.account.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.fis.account.entity.Account;
import vn.fis.account.repository.AccountRepo;
import vn.fis.account.repository.TransactionRepo;
import vn.fis.account.service.AccountService;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepo accountRepo;

    @Autowired
    private TransactionRepo transactionRepo;

    public Account saveAccount(Account account) {
        Account accountResponse = accountRepo.save(account);
        return accountResponse;
    }

    public Account findByAccountId(Long accountId) {
        Account account = accountRepo.findByAccountId(accountId);
        return account;
    }

    @Override
    public List<Account> getAll() {
        return accountRepo.findAll();
    }

    @Override
    public void deleteAccountById(Long accountId) {
        accountRepo.deleteById(accountId);
    }
}
