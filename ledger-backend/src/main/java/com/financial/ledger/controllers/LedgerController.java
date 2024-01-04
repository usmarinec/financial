package com.financial.ledger.controllers;

import com.financial.ledger.domain.LedgerDocument;
import com.financial.ledger.exception.NotFoundException;
import com.financial.ledger.response.SuccessFailureResponse;
import com.financial.ledger.response.SuccessFailureResponseUtility;
import com.financial.ledger.service.LedgerService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public abstract class LedgerController<T extends LedgerDocument, S extends LedgerService<T, ?>> {
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
    return SuccessFailureResponseUtility.createSuccessFailureResponse(
        true, "Record created", HttpStatus.CREATED, savedType);
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
    return SuccessFailureResponseUtility.createSuccessFailureResponse(
        true, "List of records created", HttpStatus.CREATED, savedTypes);
  }

  /**
   * Fetch all records.
   *
   * @return SuccessFailureResponse with records
   */
  @GetMapping("/fetch")
  public ResponseEntity<SuccessFailureResponse<T>> getAll() {
    List<T> types = service.getAll();
    return SuccessFailureResponseUtility.createSuccessFailureResponse(
        true, "All records retreived", HttpStatus.OK, types);
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
                SuccessFailureResponseUtility.createSuccessFailureResponse(
                    true, "Record found", HttpStatus.OK, type))
        .orElseThrow(() -> new NotFoundException("Resource with id: '" + id + "' not found"));
  }

  /**
   * Update record by its id.
   *
   * @param id string id value
   * @param type record type to be updated
   * @return SuccessFailureResponse with record
   */
  @PutMapping("/update/{id}")
  public ResponseEntity<SuccessFailureResponse<T>> update(
      @PathVariable String id, @RequestBody T type) {
    if (service.existsById(id)) {
      type.setId(id);
      T updatedType = service.save(type);
      return SuccessFailureResponseUtility.createSuccessFailureResponse(
          true, "Record: '" + id + "' updated", HttpStatus.OK, updatedType);
    } else {
      throw new NotFoundException("Resource with id: '" + id + "' not found");
    }
  }

  /**
   * Delete record by id.
   *
   * @param id string id value
   * @return SuccessFailureResponse with status message
   */
  @DeleteMapping("/delete/{id}")
  public ResponseEntity<SuccessFailureResponse<T>> delete(@PathVariable String id) {
    if (service.existsById(id)) {
      service.delete(id);
      return SuccessFailureResponseUtility.createSuccessFailureResponse(
          true, "Record deleted with id: '" + id + "'", HttpStatus.OK);
    } else {
      throw new NotFoundException("Resource with id: '" + id + "' not found");
    }
  }

  protected S getService() {
    return this.service;
  }
}
