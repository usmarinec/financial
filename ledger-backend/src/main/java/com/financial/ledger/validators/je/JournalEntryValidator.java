package com.financial.ledger.validators.je;

import com.financial.ledger.domain.je.JournalEntry;
import com.financial.ledger.repositories.je.JournalEntryRepository;
import com.financial.ledger.validators.service.je.JournalEntryValidatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JournalEntryValidator
    extends AbstractJournalEntryValidator<
        JournalEntry, JournalEntryRepository, JournalEntryValidatorService> {
  @Autowired
  public JournalEntryValidator() {
    this.recordType = "JournalEntry";
  }
}
