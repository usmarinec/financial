package com.financial.ledger.validators.service.coa;

import com.financial.ledger.domain.coa.ChartOfAccounts;
import com.financial.ledger.repositories.coa.ChartOfAccountsRepository;
import com.financial.ledger.validators.service.ValidatorService;
import org.springframework.stereotype.Service;

@Service
public class ChartOfAccountsValidatorService
    extends ValidatorService<ChartOfAccounts, ChartOfAccountsRepository> {}
