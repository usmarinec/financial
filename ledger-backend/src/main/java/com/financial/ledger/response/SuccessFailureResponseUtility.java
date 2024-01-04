package com.financial.ledger.response;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class SuccessFailureResponseUtility<T> {
  /**
   * Creates a ResponseEntity of type SuccessFailureResponse.
   *
   * @param success boolean value success
   * @param message string value response message
   * @param status HttpStatus value response code
   * @param type T requestBody object
   * @return ResponseEntity
   */
  public static <T> ResponseEntity<SuccessFailureResponse<T>> createSuccessFailureResponse(
      boolean success, String message, HttpStatus status, T type) {
    if (success) {
      return new ResponseEntity<>(
          SuccessFailureResponse.success(message, status.getReasonPhrase(), type), status);
    } else {
      return new ResponseEntity<>(
          SuccessFailureResponse.failure(message, status.getReasonPhrase()), status);
    }
  }

  /**
   * Creates a ResponseEntity of type SuccessFailureResponse.
   *
   * @param success boolean value success
   * @param message string value response message
   * @param status HttpStatus value response code
   * @param types List T requestBody list object
   * @return ResponseEntity
   */
  public static <T> ResponseEntity<SuccessFailureResponse<T>> createSuccessFailureResponse(
      boolean success, String message, HttpStatus status, List<T> types) {
    if (success) {
      return new ResponseEntity<>(
          SuccessFailureResponse.success(message, status.getReasonPhrase(), types), status);
    } else {
      return new ResponseEntity<>(
          SuccessFailureResponse.failure(message, status.getReasonPhrase()), status);
    }
  }

  /**
   * Creates a ResponseEntity of type SuccessFailureResponse.
   *
   * @param success boolean value success
   * @param message string value response message
   * @param status HttpStatus value response code
   * @return ResponseEntity
   */
  public static <T> ResponseEntity<SuccessFailureResponse<T>> createSuccessFailureResponse(
      boolean success, String message, HttpStatus status) {
    if (success) {
      return new ResponseEntity<>(
          SuccessFailureResponse.success(message, status.getReasonPhrase()), status);
    } else {
      return new ResponseEntity<>(
          SuccessFailureResponse.failure(message, status.getReasonPhrase()), status);
    }
  }
}
