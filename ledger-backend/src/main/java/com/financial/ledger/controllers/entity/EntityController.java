package com.financial.ledger.controllers.entity;

import com.financial.ledger.domain.entity.Entity;
import com.financial.ledger.service.entity.EntityService;
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
@RequestMapping("/entity")
public class EntityController {
  @Autowired private EntityService entityService;

  @PostMapping("/create")
  public ResponseEntity<Entity> createEntity(@RequestBody Entity entity) {
    Entity savedEntity = entityService.saveEntity(entity);
    return new ResponseEntity<>(savedEntity, HttpStatus.CREATED);
  }

  @GetMapping("/fetch")
  public ResponseEntity<List<Entity>> getAllEntities() {
    List<Entity> entities = entityService.getAllEntities();
    return new ResponseEntity<>(entities, HttpStatus.OK);
  }

  /**
   * Fetch an entity by its name property.
   *
   * @param name string name value
   * @return entity
   */
  @GetMapping("/fetch/{name}")
  public ResponseEntity<Entity> getEntityByName(@PathVariable String name) {
    Optional<Entity> optionalEntity = entityService.getEntityByName(name);

    return optionalEntity
        .map(entity -> new ResponseEntity<>(entity, HttpStatus.OK))
        .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }
}
