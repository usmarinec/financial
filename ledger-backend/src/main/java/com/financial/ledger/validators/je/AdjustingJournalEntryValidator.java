package com.financial.ledger.validators.je;

import com.financial.ledger.domain.je.AdjustingJournalEntry;
import com.financial.ledger.repositories.je.AdjustingJournalEntryRepository;
import com.financial.ledger.validators.service.je.AdjustingJournalEntryValidatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdjustingJournalEntryValidator
    extends AbstractJournalEntryValidator<
        AdjustingJournalEntry,
        AdjustingJournalEntryRepository,
        AdjustingJournalEntryValidatorService> {
  @Autowired
  public AdjustingJournalEntryValidator() {
    this.recordType = "AdjustingJournalEntry";
  }
}
