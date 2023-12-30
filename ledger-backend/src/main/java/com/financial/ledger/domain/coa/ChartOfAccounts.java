package com.financial.ledger.domain.coa;

import com.financial.ledger.domain.account.Account;
import com.financial.ledger.domain.entity.Entity;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document
public class ChartOfAccounts {
  @Id private String id;
  @DBRef Entity entity;
  @DBRef private List<Account> accounts;
}
