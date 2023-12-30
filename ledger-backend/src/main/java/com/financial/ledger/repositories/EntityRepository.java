package com.financial.ledger.repositories;

import com.financial.ledger.domain.entity.Entity;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EntityRepository extends MongoRepository<Entity, String> {
  Optional<Entity> findByName(String name);
}
