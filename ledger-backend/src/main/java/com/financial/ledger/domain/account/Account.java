package com.financial.ledger.domain.account;

import com.financial.ledger.domain.types.AccountTerm;
import com.financial.ledger.domain.types.AccountType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document
public class Account {
  @Id private String id;
  private AccountType accountType;
  private AccountTerm accountTerm;
  private int groupId;
  private int accountNumber;
  private String accountName;
}
