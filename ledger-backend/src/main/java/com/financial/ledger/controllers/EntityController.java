package com.financial.ledger.controllers;

import com.financial.ledger.domain.entity.Entity;
import com.financial.ledger.service.entity.EntityService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
  public Entity createEntity(@RequestBody Entity entity) {
    return entityService.saveEntity(entity);
  }

  @GetMapping("/fetch")
  public List<Entity> getAllEntities() {
    return entityService.getAllEntities();
  }

  /**
   * Fetch an entity by its name property.
   *
   * @param name string name value
   * @return entity
   */
  @GetMapping("/fetch/{name}")
  public Entity getEntityByName(@PathVariable String name) {
    return entityService
        .getEntityByName(name)
        .orElseThrow(() -> new RuntimeException("Entity not found with name: " + name));
  }
}
