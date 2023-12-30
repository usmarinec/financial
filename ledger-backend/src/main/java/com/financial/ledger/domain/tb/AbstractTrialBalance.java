package com.financial.ledger.domain.tb;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.financial.ledger.domain.coa.ChartOfAccounts;
import com.financial.ledger.domain.entity.Entity;
import com.financial.ledger.domain.types.Balance;
import com.financial.ledger.domain.types.BalanceSerializer;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DBRef;

@Getter
@Setter
public abstract class AbstractTrialBalance {
  private LocalDate date;
  @DBRef Entity entity;
  @DBRef ChartOfAccounts coa;

  @JsonSerialize(using = BalanceSerializer.class)
  List<Map<Integer, Balance>> accounts;
}
