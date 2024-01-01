package com.financial.ledger.repositories.je;

import com.financial.ledger.domain.je.JournalEntry;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JournalEntryRepository extends MongoRepository<JournalEntry, String> {}
