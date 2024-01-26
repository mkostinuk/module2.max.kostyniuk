package org.example.organism.animals.Herbivorous;

import org.example.organism.animals.AnimalType;
import org.example.settings.ConfigLoader;

public class Mouse extends Herbivorous{
    @Override
    public AnimalType getType() {
        return AnimalType.MOUSE;
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
        return "mouse.";
    }

    @Override
    public String getUnicode() {
        return unicode;
    }

}
