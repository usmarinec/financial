package com.financial.ledger.exception;

import com.financial.ledger.response.SuccessFailureResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {
  /**
   * Handles generic exceptions thrown by the controller.
   *
   * @param ex exception thrown by the controller
   * @return ResponseEntity SuccessFailureResponse
   */
  @ExceptionHandler(Exception.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public ResponseEntity<SuccessFailureResponse<?>> handleException(Exception ex) {
    return new ResponseEntity<>(
        SuccessFailureResponse.failure(
            "An unexpected error occured: " + ex.getMessage(),
            HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase()),
        HttpStatus.INTERNAL_SERVER_ERROR);
  }

  /**
   * Handles NotFoundExceptions thrown by the controller.
   *
   * @param ex exception thrown by the controller
   * @return ResponseEntity SuccessFailureResponse
   */
  @ExceptionHandler(NotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ResponseEntity<SuccessFailureResponse<?>> handleNotFoundException(NotFoundException ex) {
    return new ResponseEntity<>(
        SuccessFailureResponse.failure(
            "Resource not found: " + ex.getMessage(), HttpStatus.NOT_FOUND.getReasonPhrase()),
        HttpStatus.NOT_FOUND);
  }

  /**
   * Handles NullPropertyExceptions thrwon by the controller.
   *
   * @param ex exception thrwon by the controller
   * @return ResponseEntity SuccessFailureResponse
   */
  @ExceptionHandler(NullPropertyException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ResponseEntity<SuccessFailureResponse<?>> handleNullPropertyException(
      NullPropertyException ex) {
    return new ResponseEntity<>(
        SuccessFailureResponse.failure(ex.getMessage(), HttpStatus.BAD_REQUEST.getReasonPhrase()),
        HttpStatus.BAD_REQUEST);
  }

  /**
   * Handles ValueNotAllowedExceptions thrown by the controller.
   *
   * @param ex exception thrwon by the controller
   * @return ResponseEntity SuccessFailureResponse
   */
  @ExceptionHandler(ValueNotAllowedException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ResponseEntity<SuccessFailureResponse<?>> handleValueNotAllowedException(
      ValueNotAllowedException ex) {
    return new ResponseEntity<>(
        SuccessFailureResponse.failure(ex.getMessage(), HttpStatus.BAD_REQUEST.getReasonPhrase()),
        HttpStatus.BAD_REQUEST);
  }
}
