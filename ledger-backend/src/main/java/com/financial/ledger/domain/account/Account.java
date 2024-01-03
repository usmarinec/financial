package com.financial.ledger.domain.account;

import com.financial.ledger.domain.LedgerDocument;
import com.financial.ledger.domain.types.AccountTerm;
import com.financial.ledger.domain.types.AccountType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document
public class Account extends LedgerDocument {
  private AccountType accountType;
  private AccountTerm accountTerm;
  private int groupId;
  private int accountNumber;
  private String accountName;
}
