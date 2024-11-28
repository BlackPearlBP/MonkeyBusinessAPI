package com.monkeyB.mkbusapi.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Modelo para representar informações sobre primatas.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Primate {
    private String name;
    private String scientificName;
    private String habitat;
    private String diet;
    private String description;
    private int population;
    private String conservationStatus;
    private String imageUrl;
}
