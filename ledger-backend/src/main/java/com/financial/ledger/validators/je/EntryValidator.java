package com.financial.ledger.validators.je;

import com.financial.ledger.domain.je.Entry;
import com.financial.ledger.service.je.EntryService;
import com.financial.ledger.validators.LedgerValidator;
import org.springframework.beans.factory.annotation.Autowired;

public class EntryValidator extends LedgerValidator<Entry, EntryService> {
  @Autowired
  public EntryValidator() {
    this.recordType = "Entry";
  }
}
