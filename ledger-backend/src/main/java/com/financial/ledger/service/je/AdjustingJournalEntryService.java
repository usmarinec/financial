package com.financial.ledger.service.je;

import com.financial.ledger.domain.je.AdjustingJournalEntry;
import com.financial.ledger.repositories.je.AdjustingJournalEntryRepository;
import com.financial.ledger.service.LedgerService;
import org.springframework.stereotype.Service;

@Service
public class AdjustingJournalEntryService
    extends LedgerService<AdjustingJournalEntry, AdjustingJournalEntryRepository> {}
