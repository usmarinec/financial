package com.financial.ledger.domain.je;

import com.financial.ledger.domain.LedgerDocument;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AbstractEntry extends LedgerDocument {
  private String entityId;
  private String coaId;
  private String description;
  private LocalDate date;
}
