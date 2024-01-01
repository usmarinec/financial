package com.financial.ledger.service.entity;

import com.financial.ledger.domain.entity.Entity;
import com.financial.ledger.repositories.entity.EntityRepository;
import com.financial.ledger.service.LedgerService;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class EntityService extends LedgerService<Entity, EntityRepository> {

  public Optional<Entity> getEntityByName(String name) {
    return repository.findByName(name);
  }
}
