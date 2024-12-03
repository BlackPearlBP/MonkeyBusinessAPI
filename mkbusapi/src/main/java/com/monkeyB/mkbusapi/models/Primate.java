package com.monkeyB.mkbusapi.models;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
    @JsonSubTypes.Type(value = Monkey.class, name = "monkey"),
    @JsonSubTypes.Type(value = Ape.class, name = "ape")
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class Primate {
    private String name;
    private String scientificName;
    private Habitat habitat;
    private String diet;
    private String description;
    private int population;
    private String conservationStatus;
    private String imageUrl;

    public abstract String makeSound();
}