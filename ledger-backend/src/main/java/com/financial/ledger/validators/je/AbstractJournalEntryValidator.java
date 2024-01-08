package com.financial.ledger.validators.je;

import com.financial.ledger.domain.je.AbstractJournalEntry;
import com.financial.ledger.repositories.je.AbstractJournalEntryRepository;
import com.financial.ledger.validators.LedgerValidator;
import com.financial.ledger.validators.service.je.AbstractJournalEntryValidatorService;

public class AbstractJournalEntryValidator<
        T extends AbstractJournalEntry,
        R extends AbstractJournalEntryRepository<T>,
        S extends AbstractJournalEntryValidatorService<T, R>>
    extends LedgerValidator<T, S> {}
