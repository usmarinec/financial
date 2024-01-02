package com.financial.ledger.response;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PagedListResponse<T> implements PagedResponseInterface {

  public static <T> PagedListResponse<T> fromList(List<T> list) {
    return PagedListResponse.<T>builder().items(list).totalCount((long) list.size()).build();
  }

  @Builder.Default private List<T> items = new ArrayList<>();
  private Long totalCount;
}
