package com.financial.ledger.controllers.je;

import com.financial.ledger.domain.je.ClosingJournalEntry;
import com.financial.ledger.service.je.ClosingJournalEntryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cje")
public class ClosingJournalEntryController {
  @Autowired ClosingJournalEntryService cjeService;

  @PostMapping("/create")
  public ClosingJournalEntry createCje(@RequestBody ClosingJournalEntry cje) {
    return cjeService.saveCje(cje);
  }

  @PostMapping("/create-list")
  public List<ClosingJournalEntry> createCjes(@RequestBody List<ClosingJournalEntry> cjes) {
    return cjeService.saveCjes(cjes);
  }

  @GetMapping("/fetch")
  public List<ClosingJournalEntry> getAllCjes() {
    return cjeService.getAllCjes();
  }

  /**
   * Fetch CJE by its id.
   *
   * @param id string id value
   * @return Closing Journal Entry
   */
  @GetMapping("/fetch/{id}")
  public ClosingJournalEntry getCjeId(@PathVariable String id) {
    return cjeService
        .getCjeById(id)
        .orElseThrow(() -> new RuntimeException("CJE not found with id: " + id));
  }
}
