package com.financial.ledger.validators.entity;

import com.financial.ledger.domain.entity.Entity;
import com.financial.ledger.service.entity.EntityService;
import com.financial.ledger.validators.LedgerValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntityValidator extends LedgerValidator<Entity, EntityService> {
  @Autowired
  public EntityValidator() {
    this.recordType = "Entity";
  }
}
