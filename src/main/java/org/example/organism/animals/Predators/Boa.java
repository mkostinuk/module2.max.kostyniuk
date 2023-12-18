package org.example.organism.animals.Predators;

import org.example.settings.ConfigLoader;

public class Boa extends Predators {
    private final String CONFIG_KEY="boa.";

    @Override
    public String getName() {
        return "Boa";
    }

    @Override
    public int getMaxCount() {
        return ConfigLoader.getIntegerProperty(MAX_COUNT_CONFIG_KEY);
    }

    @Override
    public int getWeight() {
        return ConfigLoader.getIntegerProperty(WEIGHT_CONFIG_KEY);
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
    protected String getExactKey() {
        return CONFIG_KEY;
    }
}
