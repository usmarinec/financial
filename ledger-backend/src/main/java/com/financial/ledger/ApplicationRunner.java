package com.financial.ledger;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class ApplicationRunner implements CommandLineRunner {

  private MongoTemplate mongoTemplate;

  public ApplicationRunner(MongoTemplate mongoTemplate) {
    this.setMongoTemplate(mongoTemplate);
  }

  @Override
  public void run(String... args) throws Exception {
    System.out.println("Application started...");
  }
}
