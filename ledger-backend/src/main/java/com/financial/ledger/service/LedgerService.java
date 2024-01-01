package com.financial.ledger.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;

public abstract class LedgerService<T, R extends MongoRepository<T, String>>
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

  protected R getRepository() {
    return repository;
  }
}
