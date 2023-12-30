package com.financial.ledger.service.je;

import com.financial.ledger.domain.je.ClosingJournalEntry;
import com.financial.ledger.repositories.je.ClosingJournalEntryRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClosingJournalEntryService {
  @Autowired ClosingJournalEntryRepository cjeRepository;

  public ClosingJournalEntry saveCje(ClosingJournalEntry cje) {
    return cjeRepository.save(cje);
  }

  public List<ClosingJournalEntry> saveCjes(List<ClosingJournalEntry> cjes) {
    return cjeRepository.saveAll(cjes);
  }

  public List<ClosingJournalEntry> getAllCjes() {
    return cjeRepository.findAll();
  }

  public Optional<ClosingJournalEntry> getCjeById(String id) {
    return cjeRepository.findById(id);
  }
}
