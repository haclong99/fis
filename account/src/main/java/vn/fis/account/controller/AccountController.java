package vn.fis.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.fis.account.entity.Account;
import vn.fis.account.service.AccountService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping("/saveAccount")
    @ResponseBody
    public ResponseEntity<?> saveAccount(@RequestBody Account account) {
        return ResponseEntity.ok(accountService.saveAccount(account));
    }

    @GetMapping("/{accountId}")
    @ResponseBody
    public ResponseEntity<?> getAccountDetails(@PathVariable Long accountId) {
        return ResponseEntity.ok(accountService.findByAccountId(accountId));
    }

    @GetMapping("/listAccount")
    public ResponseEntity<List<Account>> getAll() {
        return ResponseEntity.ok(accountService.getAll());
    }

    @DeleteMapping("/{accountId}")
    public ResponseEntity<?> deleteAccountById(@PathVariable Long accountId) {
        accountService.deleteAccountById(accountId);
        return new ResponseEntity<>("Account with ID :" + accountId + " deleted successfully", HttpStatus.OK);
    }
}
