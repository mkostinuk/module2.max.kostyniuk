package org.example.services;

import org.example.map.FieldOfGame;
import org.example.organism.animals.Animal;
import org.example.organism.animals.Herbivorous.Herbivorous;
import org.example.organism.animals.Predators.Predators;
import org.example.settings.ConfigLoader;

import java.util.List;
import java.util.Random;

public class AnimalCycle implements Runnable {
    
    Random random = new Random();
    FieldOfGame fieldOfGame = FieldOfGame.getInstance();
    int newChance= random.nextInt(0, 100);
    @Override
    public void run() {
        for (int i = 0; i < fieldOfGame.getHEIGHT(); i++) {
            for (int j = 0; j < fieldOfGame.getWIDTH(); j++) {
                List<Animal> listA = fieldOfGame.getField(i, j).getAnimalsInCell();
                for (int k = 0; k < listA.size(); k++) {
                    for (int l = 1; l < listA.size(); l++) {
                        Animal animal1 = listA.get(k);
                        Animal animal2 = listA.get(l);
                        if (!animal1.equals(animal2)) {
                            if (animal1 instanceof Predators) {
                                eatAnimal(animal1, animal2, i, j);
                                eatPlants(animal1, i, j);
                            } if (animal1 instanceof Herbivorous) eatPlants(animal1, i, j);
                            listA = fieldOfGame.getField(i, j).getAnimalsInCell();

                        }
                    }

                }
            }
        }
    }

    public void eatAnimal(Animal animal1, Animal animal2, int height, int width) {
        int actualSaturate = 0;
        while (canEatAnimal(animal1, animal2, actualSaturate)){
            fieldOfGame.deleteAnimal(animal2, height, width);
            actualSaturate++;
        }

    }
    public void eatPlants(Animal animal1, int height, int width){
            int actualSaturate = 0;
            while (canEatPlants(animal1, actualSaturate)) {
                fieldOfGame.deletePlants(height, width);
                actualSaturate++;
            }

    }

    private int chances(Animal first, Animal second) {
        return ConfigLoader.getIntegerProperty("animals." + first.getExactKey() + "eat." + second.getExactKey().substring(0, second.getExactKey().length() - 1));
    }

    private boolean canEatAnimal(Animal first, Animal second, int actualSaturate){
        return newChance<=chances(first, second)&&actualSaturate<first.getSaturate();
    }
    private boolean canEatPlants(Animal first, int actualSaturate){
        return actualSaturate<=first.getSaturate();
    }

}
