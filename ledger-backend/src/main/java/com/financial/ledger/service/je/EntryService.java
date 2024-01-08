package com.financial.ledger.service.je;

import com.financial.ledger.domain.je.Entry;
import com.financial.ledger.exception.ValueNotAllowedException;
import com.financial.ledger.repositories.je.EntryRepository;
import com.financial.ledger.service.LedgerService;
import com.financial.ledger.validators.account.AccountValidator;
import com.financial.ledger.validators.coa.ChartOfAccountsValidator;
import com.financial.ledger.validators.entity.EntityValidator;
import com.financial.ledger.validators.je.EntryValidator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntryService extends LedgerService<Entry, EntryRepository> {
  @Autowired EntityValidator entityValidator;
  @Autowired ChartOfAccountsValidator coaValidator;
  @Autowired EntryValidator entryValidator;
  @Autowired AccountValidator acctValidator;

  @Override
  public Entry save(Entry entry) throws ValueNotAllowedException {
    entityValidator.validateId(entry.getEntityId());
    coaValidator.validateId(entry.getCoaId());
    entryValidator.validateEntryType(entry);
    acctValidator.validateId(entry.getAccount());
    return repository.save(entry);
  }

  @Override
  public List<Entry> saveAll(List<Entry> entries) throws ValueNotAllowedException {
    for (Entry entry : entries) {
      entityValidator.validateId(entry.getEntityId());
      coaValidator.validateId(entry.getCoaId());
      entryValidator.validateEntryType(entry);
      acctValidator.validateId(entry.getAccount());
    }
    return repository.saveAll(entries);
  }
}
