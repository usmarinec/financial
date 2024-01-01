package com.financial.ledger.controllers.je;

import com.financial.ledger.controllers.LedgerController;
import com.financial.ledger.domain.je.Entry;
import com.financial.ledger.service.je.EntryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/entry")
public class EntryController extends LedgerController<Entry, EntryService> {}
