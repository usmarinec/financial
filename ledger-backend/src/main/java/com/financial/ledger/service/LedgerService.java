package com.financial.ledger.service;

import com.financial.ledger.domain.LedgerDocument;
import com.financial.ledger.repositories.LedgerRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class LedgerService<T extends LedgerDocument, R extends LedgerRepository<T>>
    implements LedgerServiceInterface<T> {
  @Autowired protected R repository;

  @Override
  public T save(T type) {
    return repository.save(type);
  }

  @Override
  public List<T> saveAll(List<T> types) {
    return repository.saveAll(types);
  }

  @Override
  public List<T> getAll() {
    return repository.findAll();
  }

  @Override
  public Optional<T> getById(String id) {
    return repository.findById(id);
  }

  @Override
  public void delete(String id) {
    repository.deleteById(id);
  }

  @Override
  public boolean existsById(String id) {
    return repository.existsById(id);
  }

  protected R getRepository() {
    return repository;
  }
}
