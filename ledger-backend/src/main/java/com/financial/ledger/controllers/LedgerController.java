package com.financial.ledger.controllers;

import com.financial.ledger.exception.NotFoundException;
import com.financial.ledger.service.LedgerService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public abstract class LedgerController<T, S extends LedgerService<T, ?>> {
  @Autowired S service;

  @PostMapping("/create")
  public ResponseEntity<T> create(@RequestBody T type) {
    T savedType = service.save(type);
    return new ResponseEntity<>(savedType, HttpStatus.CREATED);
  }

  @PostMapping("/create-list")
  public ResponseEntity<List<T>> createList(@RequestBody List<T> types) {
    List<T> savedTypes = service.saveAll(types);
    return new ResponseEntity<>(savedTypes, HttpStatus.CREATED);
  }

  @GetMapping("/fetch")
  public ResponseEntity<List<T>> getAll() {
    List<T> types = service.getAll();
    return new ResponseEntity<>(types, HttpStatus.OK);
  }

  /**
   * Fetch record by its id.
   *
   * @param id string id value
   * @return record
   */
  @GetMapping("/fetch/{id}")
  public ResponseEntity<T> getById(@PathVariable String id) {
    Optional<T> optionalType = service.getById(id);

    return optionalType
        .map(type -> new ResponseEntity<>(type, HttpStatus.OK))
        .orElseThrow(() -> new NotFoundException("Resource with id: '" + id + "' not found"));
  }

  protected S getService() {
    return this.service;
  }
}
