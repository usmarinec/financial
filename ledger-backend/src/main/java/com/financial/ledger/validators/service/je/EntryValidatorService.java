package com.financial.ledger.validators.service.je;

import com.financial.ledger.domain.je.Entry;
import com.financial.ledger.repositories.je.EntryRepository;
import com.financial.ledger.validators.service.ValidatorService;
import org.springframework.stereotype.Service;

@Service
public class EntryValidatorService extends ValidatorService<Entry, EntryRepository> {}
