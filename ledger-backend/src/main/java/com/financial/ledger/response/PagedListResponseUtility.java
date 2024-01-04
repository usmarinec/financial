package com.financial.ledger.response;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class PagedListResponseUtility<T> {
  public static <T> ResponseEntity<PagedListResponse<T>> createPagedListResponse(
      List<T> list, HttpStatus status) {
    return new ResponseEntity<>(PagedListResponse.fromList(list), status);
  }
}
