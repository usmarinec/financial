package com.financial.ledger.service.je;

import com.financial.ledger.domain.je.JournalEntry;
import com.financial.ledger.repositories.je.JournalEntryRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JournalEntryService {
  @Autowired JournalEntryRepository jeRepository;

  public JournalEntry saveJe(JournalEntry je) {
    return jeRepository.save(je);
  }

  public List<JournalEntry> saveJes(List<JournalEntry> jes) {
    return jeRepository.saveAll(jes);
  }

  public List<JournalEntry> getAllJes() {
    return jeRepository.findAll();
  }

  public Optional<JournalEntry> getJeById(String id) {
    return jeRepository.findById(id);
  }
}
