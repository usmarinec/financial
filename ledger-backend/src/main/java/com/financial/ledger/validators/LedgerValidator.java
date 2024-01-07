package com.financial.ledger.validators;

import com.financial.ledger.domain.LedgerDocument;
import com.financial.ledger.exception.NotFoundException;
import com.financial.ledger.exception.NullPropertyException;
import com.financial.ledger.service.LedgerService;
import org.springframework.beans.factory.annotation.Autowired;

public class LedgerValidator<T extends LedgerDocument, S extends LedgerService<T, ?>> {
  @Autowired protected S service;
  protected String recordType;

  /**
   * Validates field is not null.
   *
   * @param type T record to validate
   * @throws NullPropertyException it type is null
   */
  public void validateNotNull(T type) throws NullPropertyException {
    if (type == null) {
      String message = this.recordType + " is null";
      throw new NullPropertyException(message);
    }
  }

  /**
   * Validates String id exists in repository.
   *
   * @param type T record type to validate
   * @throws NotFoundException if id does not exist
   */
  public void validateId(T type) throws NotFoundException {
    if (!service.existsById(type.getId())) {
      String message = this.recordType + " record with id: " + type.getId() + " not found";
      throw new NotFoundException(message);
    }
  }

  /**
   * Validates String id exists in repository.
   *
   * @param id String value id to validate
   * @throws NotFoundException if id does not exist
   */
  public void validateId(String id) throws NotFoundException {
    if (!service.existsById(id)) {
      String message = this.recordType + " record with id: " + id + " not found";
      throw new NotFoundException(message);
    }
  }
}
