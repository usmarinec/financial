package com.financial.ledger.exception;

public class ValueNotAllowedException extends RuntimeException {
  public ValueNotAllowedException(String message) {
    super(message);
  }
}
