package org.example.organism.animals;

import org.example.organism.Organism;

public abstract class Animal extends Organism {
    private int weight;
    private int maxCount;
    private int speed;
    private int foodKilo;

    public abstract void eat();

    public abstract void multiply();

    public abstract void selectDirectionOfMovement();
}
