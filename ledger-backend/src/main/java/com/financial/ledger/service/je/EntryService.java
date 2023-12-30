package com.financial.ledger.service.je;

import com.financial.ledger.domain.je.Entry;
import com.financial.ledger.repositories.je.EntryRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntryService {
  @Autowired private EntryRepository entryRepository;

  public Entry saveEntry(Entry entry) {
    return entryRepository.save(entry);
  }

  public List<Entry> saveEntries(List<Entry> entries) {
    return entryRepository.saveAll(entries);
  }

  public List<Entry> getAllEntries() {
    return entryRepository.findAll();
  }

  public Optional<Entry> getEntryById(String id) {
    return entryRepository.findById(id);
  }
}
