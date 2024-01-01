package com.financial.ledger.controllers.je;

import com.financial.ledger.controllers.LedgerController;
import com.financial.ledger.domain.je.ClosingJournalEntry;
import com.financial.ledger.service.je.ClosingJournalEntryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cje")
public class ClosingJournalEntryController
    extends LedgerController<ClosingJournalEntry, ClosingJournalEntryService> {}
