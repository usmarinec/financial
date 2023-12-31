package com.financial.ledger.controllers.je;

import com.financial.ledger.domain.je.ClosingJournalEntry;
import com.financial.ledger.service.je.ClosingJournalEntryService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
  public ResponseEntity<ClosingJournalEntry> createCje(@RequestBody ClosingJournalEntry cje) {
    ClosingJournalEntry savedCje = cjeService.saveCje(cje);
    return new ResponseEntity<>(savedCje, HttpStatus.CREATED);
  }

  @PostMapping("/create-list")
  public ResponseEntity<List<ClosingJournalEntry>> createCjes(
      @RequestBody List<ClosingJournalEntry> cjes) {
    List<ClosingJournalEntry> savedCjes = cjeService.saveCjes(cjes);
    return new ResponseEntity<>(savedCjes, HttpStatus.CREATED);
  }

  @GetMapping("/fetch")
  public ResponseEntity<List<ClosingJournalEntry>> getAllCjes() {
    List<ClosingJournalEntry> cjes = cjeService.getAllCjes();
    return new ResponseEntity<>(cjes, HttpStatus.OK);
  }

  /**
   * Fetch CJE by its id.
   *
   * @param id string id value
   * @return Closing Journal Entry
   */
  @GetMapping("/fetch/{id}")
  public ResponseEntity<ClosingJournalEntry> getCjeId(@PathVariable String id) {
    Optional<ClosingJournalEntry> optionalCje = cjeService.getCjeById(id);

    return optionalCje
        .map(cje -> new ResponseEntity<>(cje, HttpStatus.OK))
        .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }
}
