package com.financial.ledger.controllers.je;

import com.financial.ledger.domain.je.Entry;
import com.financial.ledger.service.je.EntryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
  public Entry createEntry(@RequestBody Entry entry) {
    return entryService.saveEntry(entry);
  }

  @PostMapping("/create-list")
  public List<Entry> createEntries(@RequestBody List<Entry> entries) {
    return entryService.saveEntries(entries);
  }

  @GetMapping("/fetch")
  public List<Entry> getAllEntries() {
    return entryService.getAllEntries();
  }

  /**
   * Fetch entry by its id.
   *
   * @param id string id value
   * @return entry
   */
  @GetMapping("/fetch/{id}")
  public Entry getEntryById(@PathVariable String id) {
    return entryService
        .getEntryById(id)
        .orElseThrow(() -> new RuntimeException("Entry not found with id: " + id));
  }
}
