package com.financial.ledger.repositories.je;

import com.financial.ledger.domain.je.Entry;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EntryRepository extends MongoRepository<Entry, String> {}
