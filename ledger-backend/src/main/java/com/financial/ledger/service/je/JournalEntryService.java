package com.financial.ledger.service.je;

import com.financial.ledger.domain.je.JournalEntry;
import com.financial.ledger.repositories.je.JournalEntryRepository;
import org.springframework.stereotype.Service;

@Service
public class JournalEntryService
    extends AbstractJournalEntryService<JournalEntry, JournalEntryRepository> {}
