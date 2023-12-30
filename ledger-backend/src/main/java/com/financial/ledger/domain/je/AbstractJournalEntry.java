package com.financial.ledger.domain.je;

import com.financial.ledger.domain.entity.Entity;
import java.time.LocalDate;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DBRef;

@Getter
@Setter
public abstract class AbstractJournalEntry {
  @DBRef Entity entity;
  private String description;
  private LocalDate date;
  @DBRef private List<Entry> entries;
}
