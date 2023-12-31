package com.financial.ledger.controllers.je;

import com.financial.ledger.domain.je.Entry;
import com.financial.ledger.service.je.EntryService;
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
@RequestMapping("/entry")
public class EntryController {
  @Autowired EntryService entryService;

  @PostMapping("/create")
  public ResponseEntity<Entry> createEntry(@RequestBody Entry entry) {
    Entry savedEntry = entryService.saveEntry(entry);
    return new ResponseEntity<>(savedEntry, HttpStatus.CREATED);
  }

  @PostMapping("/create-list")
  public ResponseEntity<List<Entry>> createEntries(@RequestBody List<Entry> entries) {
    List<Entry> savedEntries = entryService.saveEntries(entries);
    return new ResponseEntity<>(savedEntries, HttpStatus.CREATED);
  }

  @GetMapping("/fetch")
  public ResponseEntity<List<Entry>> getAllEntries() {
    List<Entry> entries = entryService.getAllEntries();
    return new ResponseEntity<>(entries, HttpStatus.OK);
  }

  /**
   * Fetch entry by its id.
   *
   * @param id string id value
   * @return entry
   */
  @GetMapping("/fetch/{id}")
  public ResponseEntity<Entry> getEntryById(@PathVariable String id) {
    Optional<Entry> optionalEntry = entryService.getEntryById(id);

    return optionalEntry
        .map(entry -> new ResponseEntity<>(entry, HttpStatus.OK))
        .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }
}
