package com.financial.ledger.repositories.je;

import com.financial.ledger.domain.je.AdjustingJournalEntry;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AdjustingJournalEntryRepository
    extends MongoRepository<AdjustingJournalEntry, String> {}
