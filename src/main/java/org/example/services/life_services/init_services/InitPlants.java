package org.example.services.life_services.init_services;

import org.example.settings.ConfigLoader;

public class InitPlants extends Init {
    @Override
    public void init() {
        int countOfPlants = ConfigLoader.getIntegerProperty(configKey + "count-plants");
        initOrganism(countOfPlants, null);
    }
}
