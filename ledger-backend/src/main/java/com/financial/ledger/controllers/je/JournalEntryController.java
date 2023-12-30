package com.financial.ledger.controllers.je;

import com.financial.ledger.domain.je.JournalEntry;
import com.financial.ledger.service.je.JournalEntryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/je")
public class JournalEntryController {
  @Autowired JournalEntryService jeService;

  @PostMapping("/create")
  public JournalEntry createJe(@RequestBody JournalEntry je) {
    return jeService.saveJe(je);
  }

  @PostMapping("/create-list")
  public List<JournalEntry> createJes(@RequestBody List<JournalEntry> jes) {
    return jeService.saveJes(jes);
  }

  @GetMapping("/fetch")
  public List<JournalEntry> getAllEntries() {
    return jeService.getAllJes();
  }

  /**
   * Fetch JE by its id.
   *
   * @param id string id value
   * @return Journal Entry
   */
  @GetMapping("/fetch/{id}")
  public JournalEntry getJeById(@PathVariable String id) {
    return jeService
        .getJeById(id)
        .orElseThrow(() -> new RuntimeException("JE not found with id: " + id));
  }
}
