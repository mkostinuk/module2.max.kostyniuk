package org.example.organism.animals.predators;

import org.example.organism.animals.Animal;

import org.example.organism.animals.TypeOfAnimals;


public abstract class Predators extends Animal {
    @Override
    public TypeOfAnimals getExtendType() {
        return TypeOfAnimals.PREDATORS;
    }

}
