package org.example.organism.animals;

import org.example.organism.animals.herbivorous.*;
import org.example.organism.animals.predators.*;

public enum AnimalType {
    /*Predators*/
    BEAR(Bear.class),
    BOA(Boa.class),
    EAGLE(Eagle.class),
    FOX(Fox.class),
    WOLF(Wolf.class),
    /*Herbivorous*/

    BOAR(Boar.class),
    BUFFALO(Buffalo.class),
    BUG(Bug.class),
    DEER(Deer.class),
    DUCK(Duck.class),
    GOAT(Goat.class),
    HORSE(Horse.class),
    MOUSE(Mouse.class),
    RABBIT(Rabbit.class),
    SHEEP(Sheep.class);


    private final Class<? extends Animal> aClass;

    AnimalType(final Class<? extends Animal> aClass) {
        this.aClass = aClass;
    }

    public Animal createAnimal() {
        try {
            return aClass.getConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
