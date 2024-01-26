package org.example.services;


import org.example.map.FieldOfGame;
import org.example.organism.animals.Animal;
import org.example.organism.animals.TypeOfAnimals;
import org.example.organism.plants.Plants;
import org.example.settings.ConfigLoader;


import java.util.List;
import java.util.Random;

public class AnimalCycle implements Runnable {
    private static final Random RANDOM = new Random();
    private final FieldOfGame fieldOfGame = FieldOfGame.getInstance();

    @Override
    public void run() {
        for (int i = 0; i < fieldOfGame.getHeight(); i++) {
            for (int j = 0; j < fieldOfGame.getWidth(); j++) {
               final FieldOfGame.Cell cell=fieldOfGame.getField(i, j);
                List<Animal> animalsInCell = cell.getAnimalsInCell();
                startingLife(animalsInCell, cell);
                animalsInCell=cell.getAnimalsInCell();
                deathByHunger(animalsInCell.stream().filter(Animal::isHungry).toList(), cell);
            }
        }


    }

    private void startingLife(List<Animal> animalList, FieldOfGame.Cell cell) {
        for (int k = 0; k < animalList.size() - 1; k++) {
            Animal animal1 = animalList.get(k);
            multiply(animal1, cell);
            for (int l = 1; l < animalList.size(); l++) {
                Animal animal2 = animalList.get(l);
                animalsLife(cell, animal1, animal2);
                animalList = cell.getAnimalsInCell();
            }
        }

    }

    private void animalsLife(FieldOfGame.Cell cell, Animal animal1, Animal animal2) {
        if (animal1.getType() != animal2.getType()) {
            if (animal1.getExtendType() == TypeOfAnimals.PREDATORS) {
                eatAnimal(animal1, animal2, cell);
            }
            if (animal1.getExtendType() == TypeOfAnimals.HERBIVOROUS) {
                eatPlants(animal1, cell);
            }
        }
    }


    private void eatAnimal(Animal animal1, Animal animal2, FieldOfGame.Cell cell) {
        if (canEatAnimal(animal1, animal2)) {
            fieldOfGame.deleteAnimal(animal2, cell);
            animal1.setActualSaturate(animal2.getWeight());
        }
    }

    private void eatPlants(Animal animal1, FieldOfGame.Cell cell) {
        if (canEatPlants(animal1)) {
            fieldOfGame.deletePlants(cell);
            animal1.setActualSaturate(new Plants().getWeight());
        }

    }

    private void multiply(Animal animal, FieldOfGame.Cell cell) {
        if (canMultiply()) {
            fieldOfGame.multiply(animal, cell);
        }
    }

    private boolean canMultiply() {
        int r = RANDOM.nextInt(100);
        return r > 90;

    }

    private void deathByHunger(List<Animal> animalList, FieldOfGame.Cell cell) {
        animalList.forEach(s-> fieldOfGame.deleteAnimal(s, cell));
    }

    private int chances(Animal first, Animal second) {
        return ConfigLoader.getIntegerProperty("animals." + first.getExactKey() + "eat." + second.getExactKey().substring(0, second.getExactKey().length() - 1));
    }

    private boolean canEatAnimal(Animal first, Animal second) {
        int newChance = RANDOM.nextInt(100);
        return newChance <= chances(first, second) && first.isHungry();
    }

    private boolean canEatPlants(Animal first) {
        return first.isHungry();
    }

}
