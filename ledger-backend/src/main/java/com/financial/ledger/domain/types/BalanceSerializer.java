package com.financial.ledger.domain.types;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;

public class BalanceSerializer extends JsonSerializer<Balance> {
  @Override
  public void serialize(
      Balance balance, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
      throws IOException {
    jsonGenerator.writeStartObject();
    jsonGenerator.writeNumberField("debit", balance.getDebit());
    jsonGenerator.writeNumberField("credit", balance.getCredit());
    jsonGenerator.writeEndObject();
  }
}
