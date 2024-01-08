package com.financial.ledger.validators.service;

import com.financial.ledger.domain.LedgerDocument;
import com.financial.ledger.repositories.LedgerRepository;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class ValidatorService<T extends LedgerDocument, R extends LedgerRepository<T>>
    implements ValidatorServiceInterface {
  @Autowired protected R repository;

  @Override
  public boolean existsById(String id) {
    return repository.existsById(id);
  }

  protected R getRepository() {
    return repository;
  }
}
