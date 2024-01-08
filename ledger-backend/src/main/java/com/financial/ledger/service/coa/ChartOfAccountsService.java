package com.financial.ledger.service.coa;

import com.financial.ledger.domain.account.Account;
import com.financial.ledger.domain.coa.ChartOfAccounts;
import com.financial.ledger.exception.NotFoundException;
import com.financial.ledger.exception.NullPropertyException;
import com.financial.ledger.repositories.coa.ChartOfAccountsRepository;
import com.financial.ledger.service.LedgerService;
import com.financial.ledger.service.account.AccountService;
import com.financial.ledger.validators.entity.EntityValidator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChartOfAccountsService
    extends LedgerService<ChartOfAccounts, ChartOfAccountsRepository> {
  @Autowired private AccountService accountService;
  @Autowired private EntityValidator entityValidator;

  /**
   * Creates a new chart of accounts.
   *
   * @param coa chart of accounts
   * @return saved chart of accounts
   * @throws NotFoundException if entity not found
   */
  @Override
  public ChartOfAccounts save(ChartOfAccounts coa) throws NotFoundException, NullPropertyException {
    entityValidator.validateNotNull(coa.getEntity());
    entityValidator.validateId(coa.getEntity());
    coa.setAccounts(this.createAccounts(coa));
    return repository.save(coa);
  }

  /**
   * Saves a list of chart of accounts.
   *
   * @param coas List of ChartOfAccounts
   * @throws UnsupportedOperationException because this method is disabled
   */
  @Override
  public List<ChartOfAccounts> saveAll(List<ChartOfAccounts> coas)
      throws UnsupportedOperationException {
    throw new UnsupportedOperationException(
        "SaveAll method is not supported in this implementation");
  }

  private List<Account> createAccounts(ChartOfAccounts coa) {
    List<Account> accounts = coa.getAccounts();
    for (Account account : accounts) {
      if (account.getId() == null) {
        Account tmpAccount = this.accountService.save(account);
        account = tmpAccount;
      }
    }
    return accounts;
  }
}
