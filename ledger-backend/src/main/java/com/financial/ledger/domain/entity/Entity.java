package com.financial.ledger.domain.entity;

import com.financial.ledger.domain.LedgerDocument;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document
public class Entity extends LedgerDocument {

  private String name;
}
