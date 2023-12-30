package com.financial.ledger.domain.je;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.financial.ledger.domain.account.Account;
import com.financial.ledger.domain.coa.ChartOfAccounts;
import com.financial.ledger.domain.entity.Entity;
import com.financial.ledger.domain.types.Balance;
import com.financial.ledger.domain.types.BalanceSerializer;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document
public class Entry {
  @Id private String id;
  @DBRef private Entity entity;
  @DBRef private ChartOfAccounts coa;
  @DBRef private Account account;
  private LocalDate date;
  private String description;

  @JsonSerialize(using = BalanceSerializer.class)
  private Balance balance;
}
