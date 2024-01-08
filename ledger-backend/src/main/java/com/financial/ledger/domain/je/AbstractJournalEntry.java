package com.financial.ledger.domain.je;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DBRef;

@Getter
@Setter
public abstract class AbstractJournalEntry extends AbstractEntry {

  @DBRef private List<Entry> entries;
}
