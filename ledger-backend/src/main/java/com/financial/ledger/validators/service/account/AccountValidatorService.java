package com.financial.ledger.validators.service.account;

import com.financial.ledger.domain.account.Account;
import com.financial.ledger.repositories.account.AccountRepository;
import com.financial.ledger.validators.service.ValidatorService;
import org.springframework.stereotype.Service;

@Service
public class AccountValidatorService extends ValidatorService<Account, AccountRepository> {}
