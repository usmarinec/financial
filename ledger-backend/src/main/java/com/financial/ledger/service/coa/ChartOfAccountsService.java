package com.financial.ledger.service.coa;

import com.financial.ledger.domain.account.Account;
import com.financial.ledger.domain.coa.ChartOfAccounts;
import com.financial.ledger.domain.entity.Entity;
import com.financial.ledger.repositories.coa.ChartOfAccountsRepository;
import com.financial.ledger.service.account.AccountService;
import com.financial.ledger.service.entity.EntityService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChartOfAccountsService {
  @Autowired private ChartOfAccountsRepository coaRepository;
  @Autowired private AccountService accountService;
  @Autowired private EntityService entityService;

  /**
   * Creates a new chart of accounts.
   *
   * @param coa chart of accounts
   * @return saved chart of accounts
   */
  public ChartOfAccounts saveCoa(ChartOfAccounts coa) {
    coa.setAccounts(this.createAccounts(coa));
    coa.setEntity(this.createEntity(coa));
    return coaRepository.save(coa);
  }

  public List<ChartOfAccounts> getAllCoa() {
    return coaRepository.findAll();
  }

  private List<Account> createAccounts(ChartOfAccounts coa) {
    List<Account> accounts = coa.getAccounts();
    for (Account account : accounts) {
      if (account.getId() == null) {
        Account tmpAccount = this.accountService.saveAccount(account);
        account = tmpAccount;
      }
    }
    return accounts;
  }

  private Entity createEntity(ChartOfAccounts coa) {
    Entity entity = coa.getEntity();
    if (entity.getId() == null) {
      entity = this.entityService.saveEntity(entity);
    }
    return entity;
  }
}
