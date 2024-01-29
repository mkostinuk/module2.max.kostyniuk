package org.example.services.life_services.init_services;

import org.example.services.life_services.OrganismEnum;

public class InitFabric {
    public static Init build(OrganismEnum organismEnum){
       return switch (organismEnum){
           case PLANTS -> new InitPlants();
           case ANIMALS -> new InitAnimals();
        };
    }
}
