package org.example.organism.animals;

import org.example.organism.Organism;
import org.example.settings.ConfigLoader;


public abstract class Animal extends Organism {
    private final String CONFIG_KEY="animals.";
    protected final String SPEED_CONFIG_KEY=CONFIG_KEY+getExactKey()+"speed";
    protected final String SATURATE_CONFIG_KEY=CONFIG_KEY+getExactKey()+"saturate";
    public abstract int getSpeed();
    public abstract int getSaturate();

    @Override
    protected String getConfigKey() {
        return CONFIG_KEY;
    }


}
