package com.financial.ledger.repositories.coa;

import com.financial.ledger.domain.coa.ChartOfAccounts;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChartOfAccountsRepository extends MongoRepository<ChartOfAccounts, String> {}
