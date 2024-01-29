package org.example.services.life_services.init_services;

import org.example.organism.animals.AnimalType;
import org.example.settings.ConfigLoader;

public class InitAnimals extends Init {
    @Override
    public void init() {
        for (AnimalType type : values) {
            int countOFAnimals = ConfigLoader.getIntegerProperty(configKey + "count-animals");
            initOrganism(countOFAnimals, type);
        }

    }
}
