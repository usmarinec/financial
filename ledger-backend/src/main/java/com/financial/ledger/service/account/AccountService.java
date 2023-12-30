package com.financial.ledger.service.account;

import com.financial.ledger.domain.account.Account;
import com.financial.ledger.repositories.AccountRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
  @Autowired private AccountRepository accountRepository;

  public Account saveAccount(Account account) {
    account.setAccountNumber(this.createAccountNum(account));
    return accountRepository.save(account);
  }

  /**
   * saves a list of accounts.
   *
   * @param accounts list of accounts
   * @return list of accounts saved
   */
  public List<Account> saveAccounts(List<Account> accounts) {
    accounts.forEach(
        account -> {
          account.setAccountNumber(this.createAccountNum(account));
        });
    return accountRepository.saveAll(accounts);
  }

  public List<Account> getAllAccounts() {
    return accountRepository.findAll();
  }

  private int createAccountNum(Account account) {
    int accountNumber = 0;

    switch (account.getAccountType()) {
      case ASSET:
        accountNumber = 10000;
        break;
      case LIABILITY:
        accountNumber = 20000;
        break;
      case EQUITY:
        accountNumber = 30000;
        break;
      case REVENUE:
        accountNumber = 40000;
        break;
      case EXPENSE:
        accountNumber = 50000;
        break;
      default:
        break;
    }

    switch (account.getAccountTerm()) {
      case CURRENT:
        accountNumber += 1000;
        break;
      case NON_CURRENT:
        accountNumber += 2000;
        break;
      case NA:
        break;
      default:
        break;
    }

    accountNumber += account.getGroupId();
    return accountNumber;
  }
}
