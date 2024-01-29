package org.example.organism.plants;

import org.example.organism.Organism;
import org.example.settings.ConfigLoader;

public class Plants extends Organism {
    @Override
    public String getUnicode() {
        return unicode;
    }

    @Override
    protected String getConfigKey() {
        return "plants.";
    }

    @Override
    public int getMaxCount() {
        return ConfigLoader.getIntegerProperty(maxCountConfigKey);
    }

    @Override
    public int getWeight() {
        return ConfigLoader.getIntegerProperty(weightConfigKey);
    }
}
