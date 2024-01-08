package com.financial.ledger.validators.service.je;

import com.financial.ledger.domain.je.AbstractJournalEntry;
import com.financial.ledger.repositories.je.AbstractJournalEntryRepository;
import com.financial.ledger.validators.service.ValidatorService;

public abstract class AbstractJournalEntryValidatorService<
        T extends AbstractJournalEntry, R extends AbstractJournalEntryRepository<T>>
    extends ValidatorService<T, R> {}
