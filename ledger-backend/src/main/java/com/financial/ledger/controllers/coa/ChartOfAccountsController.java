package com.financial.ledger.controllers.coa;

import com.financial.ledger.domain.coa.ChartOfAccounts;
import com.financial.ledger.service.coa.ChartOfAccountsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
  public ResponseEntity<ChartOfAccounts> createCoa(@RequestBody ChartOfAccounts coa) {
    ChartOfAccounts savedCoa = coaService.save(coa);
    return new ResponseEntity<>(savedCoa, HttpStatus.CREATED);
  }

  @GetMapping("/fetch")
  public ResponseEntity<List<ChartOfAccounts>> getAllCoa() {
    List<ChartOfAccounts> coas = coaService.getAll();
    return new ResponseEntity<>(coas, HttpStatus.OK);
  }
}
