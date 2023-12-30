package com.financial.ledger.service.je;

import com.financial.ledger.domain.je.AdjustingJournalEntry;
import com.financial.ledger.repositories.je.AdjustingJournalEntryRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdjustingJournalEntryService {
  @Autowired AdjustingJournalEntryRepository ajeRepository;

  public AdjustingJournalEntry saveAje(AdjustingJournalEntry aje) {
    return ajeRepository.save(aje);
  }

  public List<AdjustingJournalEntry> saveAjes(List<AdjustingJournalEntry> ajes) {
    return ajeRepository.saveAll(ajes);
  }

  public List<AdjustingJournalEntry> getAllAjes() {
    return ajeRepository.findAll();
  }

  public Optional<AdjustingJournalEntry> getAjeById(String id) {
    return ajeRepository.findById(id);
  }
}
