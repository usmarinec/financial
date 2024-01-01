package com.financial.ledger.repositories.je;

import com.financial.ledger.domain.je.ClosingJournalEntry;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClosingJournalEntryRepository
    extends MongoRepository<ClosingJournalEntry, String> {}
