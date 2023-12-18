package org.example.organism.plants;

import org.example.organism.Organism;
import org.example.settings.ConfigLoader;

public class Plants extends Organism {
    @Override
    public String getName() {
        return "Plants";
    }

    private final String CONFIG_KEY="plants.";
    @Override
    protected String getConfigKey() {
        return CONFIG_KEY;
    }

    @Override
    public int getMaxCount() {
        return ConfigLoader.getIntegerProperty(MAX_COUNT_CONFIG_KEY);
    }

    @Override
    public int getWeight() {
        return ConfigLoader.getIntegerProperty(WEIGHT_CONFIG_KEY);
    }
}
