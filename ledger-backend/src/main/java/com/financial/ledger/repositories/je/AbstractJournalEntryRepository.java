package com.financial.ledger.repositories.je;

import com.financial.ledger.domain.je.AbstractJournalEntry;
import com.financial.ledger.repositories.LedgerRepository;

public interface AbstractJournalEntryRepository<T extends AbstractJournalEntry>
    extends LedgerRepository<T> {}
