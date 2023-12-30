package com.financial.ledger.controllers;

import com.financial.ledger.domain.coa.ChartOfAccounts;
import com.financial.ledger.service.coa.ChartOfAccountsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coa")
public class ChartOfAccountsController {
  @Autowired private ChartOfAccountsService coaService;

  @PostMapping("/create")
  public ChartOfAccounts createCoa(@RequestBody ChartOfAccounts coa) {
    return coaService.saveCoa(coa);
  }

  @GetMapping("/fetch")
  public List<ChartOfAccounts> getAllCoa() {
    return coaService.getAllCoa();
  }
}
