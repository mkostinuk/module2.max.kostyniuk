package org.example.organism;

public abstract class Organism {
    public abstract int getMaxCount();

    public abstract int getWeight();

    protected final String WEIGHT_CONFIG_KEY = getConfigKey() + getExactKey() + "weight";
    protected final String MAX_COUNT_CONFIG_KEY = getConfigKey()+ getExactKey() + "max-count";

    protected abstract String getConfigKey();
    protected String getExactKey(){
        return "";
    }


}
