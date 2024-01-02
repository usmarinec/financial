package com.financial.ledger.controllers;

import com.financial.ledger.exception.NotFoundException;
import com.financial.ledger.response.SuccessFailureResponse;
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

  /**
   * Creates a single record.
   *
   * @param type record type to be created
   * @return SuccessFailureResponse with created record
   */
  @PostMapping("/create")
  public ResponseEntity<SuccessFailureResponse<T>> create(@RequestBody T type) {
    T savedType = service.save(type);
    return new ResponseEntity<>(
        SuccessFailureResponse.success(
            "Record created", HttpStatus.CREATED.getReasonPhrase(), savedType),
        HttpStatus.CREATED);
  }

  /**
   * Creates a list of records.
   *
   * @param types list of record types
   * @return SuccessFailureResponse with saved records
   */
  @PostMapping("/create-list")
  public ResponseEntity<SuccessFailureResponse<T>> createList(@RequestBody List<T> types) {
    List<T> savedTypes = service.saveAll(types);
    return new ResponseEntity<>(
        SuccessFailureResponse.success(
            "List of records created", HttpStatus.CREATED.getReasonPhrase(), savedTypes),
        HttpStatus.CREATED);
  }

  /**
   * Fetch all records.
   *
   * @return SuccessFailureResponse with records
   */
  @GetMapping("/fetch")
  public ResponseEntity<SuccessFailureResponse<T>> getAll() {
    List<T> types = service.getAll();
    return new ResponseEntity<>(
        SuccessFailureResponse.success(
            "All records retreived", HttpStatus.OK.getReasonPhrase(), types),
        HttpStatus.OK);
  }

  /**
   * Fetch record by its id.
   *
   * @param id string id value
   * @return SuccessFailureResponse with record
   */
  @GetMapping("/fetch/{id}")
  public ResponseEntity<SuccessFailureResponse<T>> getById(@PathVariable String id) {
    Optional<T> optionalType = service.getById(id);

    return optionalType
        .map(
            type ->
                new ResponseEntity<>(
                    SuccessFailureResponse.success(
                        "Record found", HttpStatus.OK.getReasonPhrase(), type),
                    HttpStatus.OK))
        .orElseThrow(() -> new NotFoundException("Resource with id: '" + id + "' not found"));
  }

  protected S getService() {
    return this.service;
  }
}
