package com.financial.ledger.controllers;

import com.financial.ledger.domain.account.Account;
import com.financial.ledger.service.account.AccountService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts")
public class AccountController {
  @Autowired AccountService accountService;

  @PostMapping("/create")
  public Account createAccount(@RequestBody Account account) {
    return accountService.saveAccount(account);
  }

  @PostMapping("/create-list")
  public List<Account> createAccounts(@RequestBody List<Account> accounts) {
    return accountService.saveAccounts(accounts);
  }

  @GetMapping("/fetch")
  public List<Account> getAllAccounts() {
    return accountService.getAllAccounts();
  }
}
