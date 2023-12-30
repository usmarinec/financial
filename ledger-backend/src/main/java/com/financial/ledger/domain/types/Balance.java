package com.financial.ledger.domain.types;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Balance {
  private Map<BalanceType, BigDecimal> balance = new HashMap<>();

  public void setDebit(BigDecimal debit) {
    this.balance.put(BalanceType.DEBIT, debit);
  }

  public void setCredit(BigDecimal credit) {
    this.balance.put(BalanceType.CREDIT, credit);
  }

  public BigDecimal getDebit() {
    return this.balance.getOrDefault(BalanceType.DEBIT, BigDecimal.ZERO);
  }

  public BigDecimal getCredit() {
    return this.balance.getOrDefault(BalanceType.CREDIT, BigDecimal.ZERO);
  }
}
