package com.financial.ledger.controllers.coa;

import com.financial.ledger.controllers.LedgerController;
import com.financial.ledger.domain.coa.ChartOfAccounts;
import com.financial.ledger.service.coa.ChartOfAccountsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coa")
public class ChartOfAccountsController
    extends LedgerController<ChartOfAccounts, ChartOfAccountsService> {}
