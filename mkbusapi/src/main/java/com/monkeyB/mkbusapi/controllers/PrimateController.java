package com.monkeyB.mkbusapi.controllers;

import com.monkeyB.mkbusapi.models.Primate;
import com.monkeyB.mkbusapi.services.PrimateService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/primates")
public class PrimateController {

    private final PrimateService primateService;

    public PrimateController(PrimateService primateService) {
        this.primateService = primateService;
    }

    // Retorna todos os primatas com possibilidade de filtrar por habitat ou dieta
    @GetMapping
    public ResponseEntity<List<Primate>> getAllPrimates(
            @RequestParam(required = false) String habitat,
            @RequestParam(required = false) String diet) {
        List<Primate> primates = primateService.getAllPrimates(habitat, diet);
        if (primates.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(primates);
    }

    // Busca primatas por tipo
    @GetMapping("/type/{type}")
    public ResponseEntity<List<Primate>> getPrimatesByType(@PathVariable String type) {
        List<Primate> primates = primateService.getPrimatesByType(type);
        if (primates.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(primates);
    }

    // Busca um primata específico pelo nome
    @GetMapping("/{name}")
    public ResponseEntity<Primate> getPrimateByName(@PathVariable String name) {
        Optional<Primate> primate = primateService.getPrimateByName(name);
        return primate.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Adiciona um novo primata
    @PostMapping
    public ResponseEntity<String> addPrimate(@RequestBody Primate primate) {
        primateService.addPrimate(primate);
        return ResponseEntity.status(HttpStatus.CREATED).body("Primata adicionado com sucesso!");
    }

    // Atualiza um primata existente
    @PutMapping("/{name}")
    public ResponseEntity<String> updatePrimate(@PathVariable String name, @RequestBody Primate updatedPrimate) {
        boolean updated = primateService.updatePrimate(name, updatedPrimate);
        if (updated) {
            return ResponseEntity.ok("Primata atualizado com sucesso!");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Primata não encontrado.");
    }

    // Remove um primata pelo nome
    @DeleteMapping("/{name}")
    public ResponseEntity<String> deletePrimate(@PathVariable String name) {
        boolean removed = primateService.deletePrimate(name);
        if (removed) {
            return ResponseEntity.ok("Primata removido com sucesso!");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Primata não encontrado.");
    }
}
