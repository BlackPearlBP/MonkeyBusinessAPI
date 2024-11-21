package com.monkeyB.mkbusapi.controllers;

import com.monkeyB.mkbusapi.models.Primate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/primates")
public class PrimateController {

    private List<Primate> primates = new ArrayList<>();


    public PrimateController() {
        primates.add(new Primate("Chimpanzee", "Pan troglodytes", "Floresta Tropical", "Onívoro", "Primata altamente inteligente e social."));
        primates.add(new Primate("Gorilla", "Gorilla gorilla", "Floresta Subtropical", "Herbívoro", "Primata maior e mais forte."));
        primates.add(new Primate("Capuchin", "Cebus apella", "Floresta Tropical", "Onívoro", "Conhecido por sua inteligência e uso de ferramentas."));
    }

    @GetMapping
    public ResponseEntity<List<Primate>> getAllPrimates(
            @RequestParam(required = false) String habitat,
            @RequestParam(required = false) String diet) {

        //habitat e dieta opicional
        List<Primate> filteredPrimates = primates;

        if (habitat != null && !habitat.isEmpty()) {
            filteredPrimates = filteredPrimates.stream()
                    .filter(p -> p.getHabitat().equalsIgnoreCase(habitat))
                    .collect(Collectors.toList());
        }

        if (diet != null && !diet.isEmpty()) {
            filteredPrimates = filteredPrimates.stream()
                    .filter(p -> p.getDiet().equalsIgnoreCase(diet))
                    .collect(Collectors.toList());
        }

        if (filteredPrimates.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(filteredPrimates, HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<Primate> getPrimateByName(@PathVariable String name) {
        Optional<Primate> primate = primates.stream()
                .filter(p -> p.getName().equalsIgnoreCase(name))
                .findFirst();

        return primate.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                      .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
