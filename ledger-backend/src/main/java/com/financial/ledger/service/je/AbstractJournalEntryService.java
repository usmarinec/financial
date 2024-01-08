package com.financial.ledger.service.je;

import com.financial.ledger.domain.je.AbstractJournalEntry;
import com.financial.ledger.domain.je.Entry;
import com.financial.ledger.exception.NotFoundException;
import com.financial.ledger.exception.NullPropertyException;
import com.financial.ledger.repositories.je.AbstractJournalEntryRepository;
import com.financial.ledger.service.LedgerService;
import com.financial.ledger.validators.account.AccountValidator;
import com.financial.ledger.validators.coa.ChartOfAccountsValidator;
import com.financial.ledger.validators.entity.EntityValidator;
import com.financial.ledger.validators.je.EntryValidator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractJournalEntryService<
        T extends AbstractJournalEntry, R extends AbstractJournalEntryRepository<T>>
    extends LedgerService<T, R> {
  @Autowired EntityValidator entityValidator;
  @Autowired ChartOfAccountsValidator coaValidator;
  @Autowired EntryValidator entryValidator;
  @Autowired AccountValidator acctValidator;

  /**
   * Saves JournalEntries to repository.
   *
   * @param type T JournalEntry value
   * @throws NullPropertyException if coaId or entityId null
   * @throws NotFoundException if coaId or entityId not found
   */
  @Override
  public T save(T type) throws NullPropertyException, NotFoundException {
    entityValidator.validateNotNull(type.getEntityId());
    entityValidator.validateId(type.getEntityId());
    coaValidator.validateNotNull(type.getCoaId());
    coaValidator.validateId(type.getCoaId());

    List<Entry> entries = type.getEntries();
    for (Entry entry : entries) {
      entityValidator.validateId(entry.getEntityId());
      coaValidator.validateId(entry.getCoaId());
      entryValidator.validateEntryType(entry);
      acctValidator.validateId(entry.getAccount());
    }
    return repository.save(type);
  }

  /**
   * Saves JournalEntries list to repository.
   *
   * @param types T List JournalEntry values
   * @throws NullPropertyException if coaId or entityId null
   * @throws NotFoundException if coaId or entityId not found
   */
  @Override
  public List<T> saveAll(List<T> types) throws NullPropertyException, NotFoundException {
    for (T type : types) {
      entityValidator.validateNotNull(type.getEntityId());
      entityValidator.validateId(type.getEntityId());
      coaValidator.validateNotNull(type.getCoaId());
      coaValidator.validateId(type.getCoaId());

      List<Entry> entries = type.getEntries();
      for (Entry entry : entries) {
        entityValidator.validateId(entry.getEntityId());
        coaValidator.validateId(entry.getCoaId());
        entryValidator.validateEntryType(entry);
        acctValidator.validateId(entry.getAccount());
      }
    }
    return repository.saveAll(types);
  }
}
