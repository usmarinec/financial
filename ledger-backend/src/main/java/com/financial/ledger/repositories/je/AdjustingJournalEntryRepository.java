package com.financial.ledger.repositories.je;

import com.financial.ledger.domain.je.AdjustingJournalEntry;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AdjustingJournalEntryRepository
    extends MongoRepository<AdjustingJournalEntry, String> {
  Optional<AdjustingJournalEntry> findById(String id);
}
