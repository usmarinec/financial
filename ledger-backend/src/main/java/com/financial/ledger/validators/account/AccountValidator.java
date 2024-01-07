package com.financial.ledger.validators.account;

import com.financial.ledger.domain.account.Account;
import com.financial.ledger.service.account.AccountService;
import com.financial.ledger.validators.LedgerValidator;
import org.springframework.beans.factory.annotation.Autowired;

public class AccountValidator extends LedgerValidator<Account, AccountService> {
  @Autowired
  public AccountValidator() {
    this.recordType = "Account";
  }
}
