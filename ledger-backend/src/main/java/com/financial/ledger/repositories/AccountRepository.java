package com.financial.ledger.repositories;

import com.financial.ledger.domain.account.Account;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccountRepository extends MongoRepository<Account, String> {}
