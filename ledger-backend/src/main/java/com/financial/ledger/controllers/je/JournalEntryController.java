package com.financial.ledger.controllers.je;

import com.financial.ledger.domain.je.JournalEntry;
import com.financial.ledger.service.je.JournalEntryService;
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
@RequestMapping("/je")
public class JournalEntryController {
  @Autowired JournalEntryService jeService;

  @PostMapping("/create")
  public ResponseEntity<JournalEntry> createJe(@RequestBody JournalEntry je) {
    JournalEntry savedJe = jeService.save(je);
    return new ResponseEntity<>(savedJe, HttpStatus.CREATED);
  }

  @PostMapping("/create-list")
  public ResponseEntity<List<JournalEntry>> createJes(@RequestBody List<JournalEntry> jes) {
    List<JournalEntry> savedJes = jeService.saveAll(jes);
    return new ResponseEntity<>(savedJes, HttpStatus.CREATED);
  }

  @GetMapping("/fetch")
  public ResponseEntity<List<JournalEntry>> getAllEntries() {
    List<JournalEntry> jes = jeService.getAll();
    return new ResponseEntity<>(jes, HttpStatus.OK);
  }

  /**
   * Fetch JE by its id.
   *
   * @param id string id value
   * @return Journal Entry
   */
  @GetMapping("/fetch/{id}")
  public ResponseEntity<JournalEntry> getJeById(@PathVariable String id) {
    Optional<JournalEntry> optionalJe = jeService.getById(id);

    return optionalJe
        .map(je -> new ResponseEntity<>(je, HttpStatus.OK))
        .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }
}
