package com.financial.ledger.validators.je;

import com.financial.ledger.domain.je.ClosingJournalEntry;
import com.financial.ledger.repositories.je.ClosingJournalEntryRepository;
import com.financial.ledger.validators.service.je.ClosingJournalEntryValidatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClosingJournalEntryValidator
    extends AbstractJournalEntryValidator<
        ClosingJournalEntry, ClosingJournalEntryRepository, ClosingJournalEntryValidatorService> {
  @Autowired
  public ClosingJournalEntryValidator() {
    this.recordType = "ClosingJournalEntry";
  }
}
