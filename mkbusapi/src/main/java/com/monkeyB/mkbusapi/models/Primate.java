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
    @Getter @Setter
    private int population;
    @Getter @Setter
    private String conservation_status;
    @Getter @Setter
    private String image_url;

    public Primate(String name, String scientific_name, String habitat, String diet,
    String description, int population, String conservation_status, String image_url) {
        this.name = name;
        this.scientific_name = scientific_name;
        this.habitat = habitat;
        this.diet = diet;
        this.description = description;
        this.population = population;
        this.conservation_status = conservation_status;
        this.image_url = image_url;
    }
}
