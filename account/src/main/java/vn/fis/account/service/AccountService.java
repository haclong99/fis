package vn.fis.account.service;

import org.springframework.stereotype.Component;
import vn.fis.account.entity.Account;

import java.util.List;

@Component
public interface AccountService {
    Account saveAccount(Account account);
    Account findByAccountId(Long accountId);
    List<Account> getAll();
    void deleteAccountById(Long accountId);
}
