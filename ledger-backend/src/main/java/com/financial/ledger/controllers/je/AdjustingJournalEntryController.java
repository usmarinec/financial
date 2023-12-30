package com.financial.ledger.controllers.je;

import com.financial.ledger.domain.je.AdjustingJournalEntry;
import com.financial.ledger.service.je.AdjustingJournalEntryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aje")
public class AdjustingJournalEntryController {
  @Autowired AdjustingJournalEntryService ajeService;

  @PostMapping("/create")
  public AdjustingJournalEntry createAje(@RequestBody AdjustingJournalEntry aje) {
    return ajeService.saveAje(aje);
  }

  @PostMapping("/create-list")
  public List<AdjustingJournalEntry> createAjes(@RequestBody List<AdjustingJournalEntry> ajes) {
    return ajeService.saveAjes(ajes);
  }

  @GetMapping("/fetch")
  public List<AdjustingJournalEntry> getAllJes() {
    return ajeService.getAllAjes();
  }

  /**
   * Fetch AJE by its id.
   *
   * @param id string id value
   * @return Adjusting Journal Entry
   */
  @GetMapping("/fetch/{id}")
  public AdjustingJournalEntry getAjeById(@PathVariable String id) {
    return ajeService
        .getAjeById(id)
        .orElseThrow(() -> new RuntimeException("AJE not found with id: " + id));
  }
}
