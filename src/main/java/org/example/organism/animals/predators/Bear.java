package org.example.organism.animals.predators;

import org.example.organism.animals.AnimalType;
import org.example.settings.ConfigLoader;

public class Bear extends Predators {
    @Override
    public AnimalType getType() {
        return AnimalType.BEAR;
    }

    @Override
    public String getUnicode() {
        return unicode;
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
        return "bear.";
    }

}
