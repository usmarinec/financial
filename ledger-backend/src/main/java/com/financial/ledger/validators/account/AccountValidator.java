package com.financial.ledger.validators.account;

import com.financial.ledger.domain.account.Account;
import com.financial.ledger.validators.LedgerValidator;
import com.financial.ledger.validators.service.account.AccountValidatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountValidator extends LedgerValidator<Account, AccountValidatorService> {
  @Autowired
  public AccountValidator() {
    this.recordType = "Account";
  }
}
