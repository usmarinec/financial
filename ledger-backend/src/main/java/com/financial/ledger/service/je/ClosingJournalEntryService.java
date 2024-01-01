package com.financial.ledger.service.je;

import com.financial.ledger.domain.je.ClosingJournalEntry;
import com.financial.ledger.repositories.je.ClosingJournalEntryRepository;
import com.financial.ledger.service.LedgerService;
import org.springframework.stereotype.Service;

@Service
public class ClosingJournalEntryService
    extends LedgerService<ClosingJournalEntry, ClosingJournalEntryRepository> {}
