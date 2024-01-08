package com.financial.ledger.repositories.entity;

import com.financial.ledger.domain.entity.Entity;
import com.financial.ledger.repositories.LedgerRepository;
import java.util.Optional;

public interface EntityRepository extends LedgerRepository<Entity> {
  Optional<Entity> findByName(String name);
}
