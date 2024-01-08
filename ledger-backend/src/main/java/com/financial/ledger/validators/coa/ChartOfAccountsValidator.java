package com.financial.ledger.validators.coa;

import com.financial.ledger.domain.coa.ChartOfAccounts;
import com.financial.ledger.validators.LedgerValidator;
import com.financial.ledger.validators.service.coa.ChartOfAccountsValidatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChartOfAccountsValidator
    extends LedgerValidator<ChartOfAccounts, ChartOfAccountsValidatorService> {
  @Autowired
  public ChartOfAccountsValidator() {
    this.recordType = "ChartOfAccounts";
  }
}
