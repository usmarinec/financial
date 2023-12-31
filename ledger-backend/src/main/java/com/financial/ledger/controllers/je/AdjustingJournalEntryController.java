package com.financial.ledger.controllers.je;

import com.financial.ledger.domain.je.AdjustingJournalEntry;
import com.financial.ledger.service.je.AdjustingJournalEntryService;
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
@RequestMapping("/aje")
public class AdjustingJournalEntryController {
  @Autowired AdjustingJournalEntryService ajeService;

  @PostMapping("/create")
  public ResponseEntity<AdjustingJournalEntry> createAje(@RequestBody AdjustingJournalEntry aje) {
    AdjustingJournalEntry savedAje = ajeService.saveAje(aje);
    return new ResponseEntity<>(savedAje, HttpStatus.CREATED);
  }

  @PostMapping("/create-list")
  public ResponseEntity<List<AdjustingJournalEntry>> createAjes(
      @RequestBody List<AdjustingJournalEntry> ajes) {
    List<AdjustingJournalEntry> savedAjes = ajeService.saveAjes(ajes);
    return new ResponseEntity<>(savedAjes, HttpStatus.CREATED);
  }

  @GetMapping("/fetch")
  public ResponseEntity<List<AdjustingJournalEntry>> getAllJes() {
    List<AdjustingJournalEntry> ajes = ajeService.getAllAjes();
    return new ResponseEntity<>(ajes, HttpStatus.OK);
  }

  /**
   * Fetch AJE by its id.
   *
   * @param id string id value
   * @return Adjusting Journal Entry
   */
  @GetMapping("/fetch/{id}")
  public ResponseEntity<AdjustingJournalEntry> getAjeById(@PathVariable String id) {
    Optional<AdjustingJournalEntry> optionalAje = ajeService.getAjeById(id);

    return optionalAje
        .map(aje -> new ResponseEntity<>(aje, HttpStatus.OK))
        .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }
}
