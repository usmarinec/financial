package com.financial.ledger.validators.service.entity;

import com.financial.ledger.domain.entity.Entity;
import com.financial.ledger.repositories.entity.EntityRepository;
import com.financial.ledger.validators.service.ValidatorService;
import org.springframework.stereotype.Service;

@Service
public class EntityValidatorService extends ValidatorService<Entity, EntityRepository> {}
