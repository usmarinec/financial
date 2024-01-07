package com.financial.ledger.validators.coa;

import com.financial.ledger.domain.coa.ChartOfAccounts;
import com.financial.ledger.service.coa.ChartOfAccountsService;
import com.financial.ledger.validators.LedgerValidator;
import org.springframework.beans.factory.annotation.Autowired;

public class ChartOfAccountsValidator
    extends LedgerValidator<ChartOfAccounts, ChartOfAccountsService> {
  @Autowired
  public ChartOfAccountsValidator() {
    this.recordType = "ChartOfAccounts";
  }
}
