package com.financial.ledger.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public abstract class LedgerDocument {
  @Id protected String id;
}
