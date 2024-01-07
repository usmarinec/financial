package com.financial.ledger.validators.je;

import com.financial.ledger.domain.je.AdjustingJournalEntry;
import com.financial.ledger.service.je.AdjustingJournalEntryService;
import com.financial.ledger.validators.LedgerValidator;
import org.springframework.beans.factory.annotation.Autowired;

public class AdjustingJournalEntryValidator
    extends LedgerValidator<AdjustingJournalEntry, AdjustingJournalEntryService> {
  @Autowired
  public AdjustingJournalEntryValidator() {
    this.recordType = "AdjustingJournalEntry";
  }
}
