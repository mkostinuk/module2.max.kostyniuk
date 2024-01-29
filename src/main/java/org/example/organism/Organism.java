package org.example.organism;

public abstract class Organism {
    public abstract int getMaxCount();

    public abstract int getWeight();

    public abstract String getUnicode();

    protected final String unicode = getConfigKey() + getExactKey() + "uc";
    protected final String weightConfigKey = getConfigKey() + getExactKey() + "weight";
    protected final String maxCountConfigKey = getConfigKey() + getExactKey() + "max-count";

    protected abstract String getConfigKey();

    public String getExactKey() {
        return "";
    }


}
