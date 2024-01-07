package com.financial.ledger.validators.je;

import com.financial.ledger.domain.je.ClosingJournalEntry;
import com.financial.ledger.service.je.ClosingJournalEntryService;
import com.financial.ledger.validators.LedgerValidator;
import org.springframework.beans.factory.annotation.Autowired;

public class ClosingJournalEntryValidator
    extends LedgerValidator<ClosingJournalEntry, ClosingJournalEntryService> {
  @Autowired
  public ClosingJournalEntryValidator() {
    this.recordType = "ClosingJournalEntry";
  }
}
