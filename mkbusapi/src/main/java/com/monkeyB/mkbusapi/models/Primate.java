package com.monkeyB.mkbusapi.models;

import lombok.Getter;
import lombok.Setter;

public class Primate {
    @Getter @Setter
    private String name;
    @Getter @Setter
    private String scientific_name;
    @Getter @Setter
    private String habitat;
    @Getter @Setter
    private String diet;
    @Getter @Setter
    private String description;

    public Primate(String name, String scientific_name, String habitat, String diet, String description) {
        this.name = name;
        this.scientific_name = scientific_name;
        this.habitat = habitat;
        this.diet = diet;
        this.description = description;
    }
}
