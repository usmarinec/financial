package com.financial.ledger.service.je;

import com.financial.ledger.domain.je.ClosingJournalEntry;
import com.financial.ledger.repositories.je.ClosingJournalEntryRepository;
import org.springframework.stereotype.Service;

@Service
public class ClosingJournalEntryService
    extends AbstractJournalEntryService<ClosingJournalEntry, ClosingJournalEntryRepository> {}
