package org.example.organism.animals;

import org.example.organism.Organism;

import java.util.Random;


public abstract class Animal extends Organism {
    protected final Random random= new Random();
    protected final AnimalType[] values=AnimalType.values();
    private final String CONFIG_KEY = "animals.";
    protected final String SPEED_CONFIG_KEY = CONFIG_KEY + getExactKey() + "speed";
    protected final String SATURATE_CONFIG_KEY = CONFIG_KEY + getExactKey() + "saturate";

    public abstract int getSpeed();

    public abstract int getSaturate();
    @Override
    protected String getConfigKey() {
        return CONFIG_KEY;
    }


}
