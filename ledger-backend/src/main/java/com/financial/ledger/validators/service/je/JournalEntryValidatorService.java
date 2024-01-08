package com.financial.ledger.validators.service.je;

import com.financial.ledger.domain.je.JournalEntry;
import com.financial.ledger.repositories.je.JournalEntryRepository;
import org.springframework.stereotype.Service;

@Service
public class JournalEntryValidatorService
    extends AbstractJournalEntryValidatorService<JournalEntry, JournalEntryRepository> {}
