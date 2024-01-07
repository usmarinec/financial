package com.financial.ledger.validators.je;

import com.financial.ledger.domain.je.JournalEntry;
import com.financial.ledger.service.je.JournalEntryService;
import com.financial.ledger.validators.LedgerValidator;
import org.springframework.beans.factory.annotation.Autowired;

public class JournalEntryValidator extends LedgerValidator<JournalEntry, JournalEntryService> {
  @Autowired
  public JournalEntryValidator() {
    this.recordType = "JournalEntry";
  }
}
