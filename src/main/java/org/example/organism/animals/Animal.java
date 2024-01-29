package org.example.organism.animals;


import org.example.organism.Organism;


public abstract class Animal extends Organism {
    private int actualSaturate = 0;

    public void setActualSaturate(int weight) {
        this.actualSaturate += weight;
    }

    public void nullSaturate() {
        this.actualSaturate = 0;
    }

    public boolean isHungry() {
        return actualSaturate < getSaturate();
    }

    private final String CONFIG_KEY = "animals.";
    protected final String SPEED_CONFIG_KEY = CONFIG_KEY + getExactKey() + "speed";
    protected final String SATURATE_CONFIG_KEY = CONFIG_KEY + getExactKey() + "saturate";

    public abstract AnimalType getType();

    public abstract TypeOfAnimals getExtendType();

    public abstract int getSpeed();

    public abstract int getSaturate();

    @Override
    protected String getConfigKey() {
        return CONFIG_KEY;
    }

}



