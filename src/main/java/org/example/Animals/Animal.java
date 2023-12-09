package org.example.Animals;

import org.example.Organism;

public abstract class Animal extends Organism {
    private int weight;
    private int maxCount;
    private int speed;
    private int foodKilo;

    public abstract void eat();

    public abstract void multiply();

    public abstract void selectDirectionOfMovement();
}
