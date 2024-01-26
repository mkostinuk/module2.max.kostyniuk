package org.example.organism.animals.herbivorous;

import org.example.organism.animals.AnimalType;
import org.example.settings.ConfigLoader;

public class Duck extends Herbivorous {
    @Override
    public AnimalType getType() {
        return AnimalType.DUCK;
    }

    @Override
    public int getMaxCount() {
        return ConfigLoader.getIntegerProperty(maxCountConfigKey);
    }

    @Override
    public int getWeight() {
        return ConfigLoader.getIntegerProperty(weightConfigKey);
    }

    @Override
    public int getSpeed() {
        return ConfigLoader.getIntegerProperty(SPEED_CONFIG_KEY);
    }

    @Override
    public int getSaturate() {
        return ConfigLoader.getIntegerProperty(SATURATE_CONFIG_KEY);
    }

    @Override
    public String getExactKey() {
        return "duck.";
    }

    @Override
    public String getUnicode() {
        return unicode;
    }

}
