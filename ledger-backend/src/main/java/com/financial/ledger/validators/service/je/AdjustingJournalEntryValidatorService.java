package com.financial.ledger.validators.service.je;

import com.financial.ledger.domain.je.AdjustingJournalEntry;
import com.financial.ledger.repositories.je.AdjustingJournalEntryRepository;
import org.springframework.stereotype.Service;

@Service
public class AdjustingJournalEntryValidatorService
    extends AbstractJournalEntryValidatorService<
        AdjustingJournalEntry, AdjustingJournalEntryRepository> {}
