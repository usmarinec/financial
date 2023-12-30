package com.financial.ledger.repositories.je;

import com.financial.ledger.domain.je.Entry;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EntryRepository extends MongoRepository<Entry, String> {
  Optional<Entry> findById(String id);
}
