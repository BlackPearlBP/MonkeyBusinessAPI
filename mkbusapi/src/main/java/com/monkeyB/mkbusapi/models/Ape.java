package com.monkeyB.mkbusapi.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Ape extends Primate {
    private boolean canClimb; // Exemplo de atributo específico para Ape

    public Ape(String name, String scientificName, Habitat habitat, String diet,
               String description, int population, String conservationStatus, String imageUrl) {
        super(name, scientificName, habitat, diet, description, population, conservationStatus, imageUrl);
    }

    @Override
    public String makeSound() {
        return "Grunt"; // Implementação do som
    }
}