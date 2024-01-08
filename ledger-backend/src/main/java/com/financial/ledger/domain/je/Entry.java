package com.financial.ledger.domain.je;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.financial.ledger.domain.account.Account;
import com.financial.ledger.domain.types.Balance;
import com.financial.ledger.domain.types.BalanceSerializer;
import com.financial.ledger.domain.types.EntryType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document
public class Entry extends AbstractEntry {
  private EntryType entryType;
  @DBRef private Account account;

  @JsonSerialize(using = BalanceSerializer.class)
  private Balance balance;
}
