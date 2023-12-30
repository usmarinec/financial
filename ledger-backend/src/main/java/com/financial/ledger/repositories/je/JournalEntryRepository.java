package com.financial.ledger.repositories.je;

import com.financial.ledger.domain.je.JournalEntry;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JournalEntryRepository extends MongoRepository<JournalEntry, String> {
  Optional<JournalEntry> findById(String id);
}
