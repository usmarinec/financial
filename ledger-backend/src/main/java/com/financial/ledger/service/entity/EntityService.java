package com.financial.ledger.service.entity;

import com.financial.ledger.domain.entity.Entity;
import com.financial.ledger.repositories.entity.EntityRepository;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntityService {
  @Autowired private EntityRepository entityRepository;

  public Entity saveEntity(Entity entity) {
    return entityRepository.save(entity);
  }

  public List<Entity> getAllEntities() {
    return entityRepository.findAll();
  }

  public Optional<Entity> getEntityByName(String name) {
    return entityRepository.findByName(name);
  }
}
