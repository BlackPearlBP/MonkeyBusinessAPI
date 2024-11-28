package com.monkeyB.mkbusapi.services;

import com.monkeyB.mkbusapi.models.Primate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PrimateService {

    private final List<Primate> primates = new ArrayList<>();

    public PrimateService() {
        // Dados iniciais com mais primatas e URLs de imagens
        primates.add(new Primate(1L, "Chimpanzee", "Pan troglodytes", "Floresta Tropical", "Onívoro",
                "Primata altamente inteligente e social.", 20000, "Ameaçado", 
                "https://upload.wikimedia.org/wikipedia/commons/4/42/015_Chimpanzee_at_Kibale_forest_National_Park_Photo_by_Giles_Laurent.jpg"));
        primates.add(new Primate(2L, "Gorilla", "Gorilla gorilla", "Floresta Subtropical", "Herbívoro",
                "Primata maior e mais forte.", 5000, "Criticamente em perigo", 
                "https://upload.wikimedia.org/wikipedia/commons/thumb/b/bb/Gorille_des_plaines_de_l%27ouest_%C3%A0_l%27Espace_Zoologique.jpg/280px-Gorille_des_plaines_de_l%27ouest_%C3%A0_l%27Espace_Zoologique.jpg"));
        primates.add(new Primate(3L, "Capuchin", "Cebus apella", "Floresta Tropical", "Onívoro",
                "Conhecido por sua inteligência e uso de ferramentas.", 100000, "Pouco preocupante", 
                "https://upload.wikimedia.org/wikipedia/commons/thumb/4/40/Capuchin_Costa_Rica.jpg/613px-Capuchin_Costa_Rica.jpg"));
        primates.add(new Primate(4L, "Howler Monkey", "Alouatta", "Floresta Tropical", "Herbívoro",
                "Conhecido por seu rugido alto e distante.", 100000, "Pouco preocupante", 
                "https://upload.wikimedia.org/wikipedia/commons/thumb/c/cd/Walking_Alouatta_palliata%2C_Costa_Rica.JPG/200px-Walking_Alouatta_palliata%2C_Costa_Rica.JPG"));
        primates.add(new Primate(5L, "Orangutan", "Pongo pygmaeus", "Floresta Tropical", "Onívoro",
                "Primata solitário e muito inteligente.", 50000, "Criticamente em perigo", 
                "https://upload.wikimedia.org/wikipedia/commons/thumb/b/be/Orang_Utan%2C_Semenggok_Forest_Reserve%2C_Sarawak%2C_Borneo%2C_Malaysia.JPG/280px-Orang_Utan%2C_Semenggok_Forest_Reserve%2C_Sarawak%2C_Borneo%2C_Malaysia.JPG"));
    }

    // Retorna todos os primatas com filtros opcionais
    public List<Primate> getAllPrimates(String habitat, String diet) {
        if (habitat == null && diet == null) {
            return primates;
        }
        return primates.stream()
                .filter(p -> (habitat == null || p.getHabitat().equalsIgnoreCase(habitat)) &&
                             (diet == null || p.getDiet().equalsIgnoreCase(diet)))
                .collect(Collectors.toList());
    }

    // Busca um primata específico pelo nome
    public Optional<Primate> getPrimateByName(String name) {
        return primates.stream()
                .filter(p -> p.getName().equalsIgnoreCase(name))
                .findFirst();
    }

    // Adiciona um novo primata
    public void addPrimate(Primate primate) {
        primates.add(primate);
    }

    // Atualiza um primata existente
    public boolean updatePrimate(String name, Primate updatedPrimate) {
        Optional<Primate> existingPrimate = getPrimateByName(name);
        if (existingPrimate.isPresent()) {
            Primate primate = existingPrimate.get();
            primate.setScientificName(updatedPrimate.getScientificName());
            primate.setHabitat(updatedPrimate.getHabitat());
            primate.setDiet(updatedPrimate.getDiet());
            primate.setDescription(updatedPrimate.getDescription());
            primate.setPopulation(updatedPrimate.getPopulation());
            primate.setConservationStatus(updatedPrimate.getConservationStatus());
            primate.setImageUrl(updatedPrimate.getImageUrl());
            return true;
        }
        return false;
    }

    // Remove um primata pelo nome
    public boolean deletePrimate(String name) {
        return primates.removeIf(p -> p.getName().equalsIgnoreCase(name));
    }
}
