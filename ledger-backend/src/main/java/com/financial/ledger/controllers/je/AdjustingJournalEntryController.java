package com.financial.ledger.controllers.je;

import com.financial.ledger.controllers.LedgerController;
import com.financial.ledger.domain.je.AdjustingJournalEntry;
import com.financial.ledger.service.je.AdjustingJournalEntryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aje")
public class AdjustingJournalEntryController
    extends LedgerController<AdjustingJournalEntry, AdjustingJournalEntryService> {}
