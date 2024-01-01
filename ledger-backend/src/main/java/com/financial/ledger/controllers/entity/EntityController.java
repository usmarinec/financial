package com.financial.ledger.controllers.entity;

import com.financial.ledger.controllers.LedgerController;
import com.financial.ledger.domain.entity.Entity;
import com.financial.ledger.service.entity.EntityService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/entity")
public class EntityController extends LedgerController<Entity, EntityService> {}
