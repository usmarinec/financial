package com.financial.ledger.validators.entity;

import com.financial.ledger.domain.entity.Entity;
import com.financial.ledger.validators.LedgerValidator;
import com.financial.ledger.validators.service.entity.EntityValidatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntityValidator extends LedgerValidator<Entity, EntityValidatorService> {
  @Autowired
  public EntityValidator() {
    this.recordType = "Entity";
  }
}
