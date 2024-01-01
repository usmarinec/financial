package com.financial.ledger.service.je;

import com.financial.ledger.domain.je.JournalEntry;
import com.financial.ledger.repositories.je.JournalEntryRepository;
import com.financial.ledger.service.LedgerService;
import org.springframework.stereotype.Service;

@Service
public class JournalEntryService extends LedgerService<JournalEntry, JournalEntryRepository> {}
