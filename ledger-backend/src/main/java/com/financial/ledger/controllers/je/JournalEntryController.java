package com.financial.ledger.controllers.je;

import com.financial.ledger.controllers.LedgerController;
import com.financial.ledger.domain.je.JournalEntry;
import com.financial.ledger.service.je.JournalEntryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/je")
public class JournalEntryController extends LedgerController<JournalEntry, JournalEntryService> {}
