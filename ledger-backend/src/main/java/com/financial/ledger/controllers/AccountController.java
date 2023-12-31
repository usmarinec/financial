package com.financial.ledger.controllers;

import com.financial.ledger.domain.account.Account;
import com.financial.ledger.service.account.AccountService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
  public ResponseEntity<Account> createAccount(@RequestBody Account account) {
    Account savedAccount = accountService.saveAccount(account);
    return new ResponseEntity<>(savedAccount, HttpStatus.CREATED);
  }

  @PostMapping("/create-list")
  public ResponseEntity<List<Account>> createAccounts(@RequestBody List<Account> accounts) {
    List<Account> savedAccounts = accountService.saveAccounts(accounts);
    return new ResponseEntity<>(savedAccounts, HttpStatus.CREATED);
  }

  @GetMapping("/fetch")
  public ResponseEntity<List<Account>> getAllAccounts() {
    List<Account> accounts = accountService.getAllAccounts();
    return new ResponseEntity<>(accounts, HttpStatus.OK);
  }
}