package org.example.services.life_services.animal_services;

import org.example.map.FieldOfGame;
import org.example.organism.animals.Animal;
import org.example.organism.plants.Plants;
import org.example.settings.ConfigLoader;

import java.util.Random;

class EatService {
    private final FieldOfGame fieldOfGame = FieldOfGame.getInstance();
    private final static Random RANDOM = new Random();

    public void nullSaturate() {
        for (int i = 0; i < fieldOfGame.getHeight(); i++) {
            for (int j = 0; j < fieldOfGame.getWidth(); j++) {
                fieldOfGame.getField(i, j).getAnimalsInCell().forEach(Animal::nullSaturate);
            }
        }
    }

    public void eat(Animal animal1, Animal animal2, FieldOfGame.Cell cell) {
        if (canEat(animal1, animal2)) {
            fieldOfGame.deleteAnimal(animal2, cell);
            animal1.setActualSaturate(animal2.getWeight());
        }
    }

    public void eat(Animal animal1, FieldOfGame.Cell cell) {
        if (canEat(animal1)) {
            boolean isDelete = fieldOfGame.deletePlants(cell);
            if (isDelete) {
                animal1.setActualSaturate(new Plants().getWeight());
            }
        }

    }

    private int chances(Animal first, Animal second) {
        return ConfigLoader.getIntegerProperty("animals." + first.getExactKey() + "eat." + second.getExactKey().substring(0, second.getExactKey().length() - 1));
    }

    private boolean canEat(Animal first, Animal second) {
        int newChance = RANDOM.nextInt(100);
        return newChance <= chances(first, second) && first.isHungry();
    }

    private boolean canEat(Animal first) {
        return first.isHungry();
    }


}
