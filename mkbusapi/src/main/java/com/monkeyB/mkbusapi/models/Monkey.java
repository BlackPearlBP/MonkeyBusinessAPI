package com.monkeyB.mkbusapi.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Monkey extends Primate {
    private boolean isSocial; 

    public Monkey(String name, String scientificName, Habitat habitat, String diet,
                  String description, int population, String conservationStatus, String imageUrl) {
        super(name, scientificName, habitat, diet, description, population, conservationStatus, imageUrl);
    }

    @Override
    public String makeSound() {
        return "Chatter"; // Implementação do som
    }
}