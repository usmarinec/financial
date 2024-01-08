package com.financial.ledger.service;

import java.util.List;
import java.util.Optional;

public interface LedgerServiceInterface<T> {
  T save(T type);

  List<T> saveAll(List<T> types);

  List<T> getAll();

  Optional<T> getById(String id);

  void delete(String id);

  boolean existsById(String id);
}
