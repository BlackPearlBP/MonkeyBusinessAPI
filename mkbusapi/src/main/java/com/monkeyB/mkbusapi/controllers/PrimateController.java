package com.monkeyB.mkbusapi.controllers;

import com.monkeyB.mkbusapi.models.Primate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/primates")
public class PrimateController {

    private List<Primate> primates = new ArrayList<>();

    public PrimateController() {
        // Dados iniciais
        primates.add(new Primate("Chimpanzee", "Pan troglodytes", "Floresta Tropical", "Onívoro", "Primata altamente inteligente e social."));
        primates.add(new Primate("Gorilla", "Gorilla gorilla", "Floresta Subtropical", "Herbívoro", "Primata maior e mais forte."));
        primates.add(new Primate("Capuchin", "Cebus apella", "Floresta Tropical", "Onívoro", "Conhecido por sua inteligência e uso de ferramentas."));
    }

    // Retorna todos os primatas com possibilidade de filtrar por habitat ou dieta
    @GetMapping
    public ResponseEntity<List<Primate>> getAllPrimates(
            @RequestParam(required = false) String habitat,
            @RequestParam(required = false) String diet) {

        List<Primate> filteredPrimates = primates;
        if (habitat != null || diet != null) {
            filteredPrimates = primates.stream()
                    .filter(p -> (habitat == null || p.getHabitat().equalsIgnoreCase(habitat)) &&
                                 (diet == null || p.getDiet().equalsIgnoreCase(diet)))
                    .toList();
        }

        if (filteredPrimates.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(filteredPrimates, HttpStatus.OK);
    }

    // Busca um primata específico pelo nome
    @GetMapping("/{name}")
    public ResponseEntity<Primate> getPrimateByName(@PathVariable String name) {
        Optional<Primate> primate = primates.stream()
                .filter(p -> p.getName().equalsIgnoreCase(name))
                .findFirst();

        if (primate.isPresent()) {
            return new ResponseEntity<>(primate.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Adiciona um novo primata
    @PostMapping
    public ResponseEntity<String> addPrimate(@RequestBody Primate primate) {
        primates.add(primate);
        return new ResponseEntity<>("Primata adicionado com sucesso!", HttpStatus.CREATED);
    }

    // Atualiza um primata existente
    @PutMapping("/{name}")
    public ResponseEntity<String> updatePrimate(@PathVariable String name, @RequestBody Primate updatedPrimate) {
        Optional<Primate> existingPrimate = primates.stream()
                .filter(p -> p.getName().equalsIgnoreCase(name))
                .findFirst();

        if (existingPrimate.isPresent()) {
            Primate primate = existingPrimate.get();
            primate.setScientific_name(updatedPrimate.getScientific_name());
            primate.setHabitat(updatedPrimate.getHabitat());
            primate.setDiet(updatedPrimate.getDiet());
            primate.setDescription(updatedPrimate.getDescription());
            return new ResponseEntity<>("Primata atualizado com sucesso!", HttpStatus.OK);
        }
        return new ResponseEntity<>("Primata não encontrado.", HttpStatus.NOT_FOUND);
    }

    // Remove um primata pelo nome
    @DeleteMapping("/{name}")
    public ResponseEntity<String> deletePrimate(@PathVariable String name) {
        boolean removed = primates.removeIf(p -> p.getName().equalsIgnoreCase(name));
        if (removed) {
            return new ResponseEntity<>("Primata removido com sucesso!", HttpStatus.OK);
        }
        return new ResponseEntity<>("Primata não encontrado.", HttpStatus.NOT_FOUND);
    }
}
