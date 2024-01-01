package com.financial.ledger.controllers.account;

import com.financial.ledger.controllers.LedgerController;
import com.financial.ledger.domain.account.Account;
import com.financial.ledger.service.account.AccountService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts")
public class AccountController extends LedgerController<Account, AccountService> {}
