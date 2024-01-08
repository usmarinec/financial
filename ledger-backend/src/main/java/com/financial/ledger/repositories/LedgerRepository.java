package com.financial.ledger.repositories;

import com.financial.ledger.domain.LedgerDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LedgerRepository<T extends LedgerDocument> extends MongoRepository<T, String> {}
