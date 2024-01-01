package com.financial.ledger.service.je;

import com.financial.ledger.domain.je.Entry;
import com.financial.ledger.repositories.je.EntryRepository;
import com.financial.ledger.service.LedgerService;
import org.springframework.stereotype.Service;

@Service
public class EntryService extends LedgerService<Entry, EntryRepository> {}
