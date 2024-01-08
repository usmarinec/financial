package com.financial.ledger.validators.je;

import com.financial.ledger.domain.je.Entry;
import com.financial.ledger.domain.types.EntryType;
import com.financial.ledger.exception.ValueNotAllowedException;
import com.financial.ledger.validators.LedgerValidator;
import com.financial.ledger.validators.service.je.EntryValidatorService;
import java.util.EnumSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntryValidator extends LedgerValidator<Entry, EntryValidatorService> {
  private EnumSet<EntryType> allowedEntryTypes =
      EnumSet.of(EntryType.AJE, EntryType.CJE, EntryType.JE);

  @Autowired
  public EntryValidator() {
    this.recordType = "Entry";
  }

  /**
   * Validates EntryType value.
   *
   * @param entry entry record
   * @throws ValueNotAllowedException if EntryType is not enum value
   */
  public void validateEntryType(Entry entry) throws ValueNotAllowedException {
    EntryType entryType = entry.getEntryType();
    String message = entryType + "is not an allowed EntryType";
    if (!allowedEntryTypes.contains(entryType)) {
      throw new ValueNotAllowedException(message);
    }
  }
}
