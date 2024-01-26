package org.example.organism.animals.herbivorous;

import org.example.organism.animals.Animal;
import org.example.organism.animals.TypeOfAnimals;

public abstract class Herbivorous extends Animal {
    @Override
    public TypeOfAnimals getExtendType() {
        return TypeOfAnimals.HERBIVOROUS;
    }
}
