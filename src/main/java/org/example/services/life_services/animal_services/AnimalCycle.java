package org.example.services.life_services.animal_services;

import org.example.map.FieldOfGame;
import org.example.organism.animals.Animal;
import org.example.organism.animals.TypeOfAnimals;
import org.example.services.life_services.MultiplyService;

import java.util.List;


public class AnimalCycle implements Runnable {
    private final FieldOfGame fieldOfGame = FieldOfGame.getInstance();
    private final MultiplyService multiplyService = new MultiplyService();
    private final DeathService deathService = new DeathService();
    private final EatService eatService = new EatService();
    private final MoveService moveService = new MoveService();

    @Override
    public void run() {
        eatService.nullSaturate();
        for (int i = 0; i < fieldOfGame.getHeight(); i++) {
            for (int j = 0; j < fieldOfGame.getWidth(); j++) {
                final FieldOfGame.Cell cell = fieldOfGame.getField(i, j);
                List<Animal> animalsInCell = cell.getAnimalsInCell();
                startingLife(animalsInCell, cell);
                animalsInCell = cell.getAnimalsInCell();
                deathService.deathByHunger(animalsInCell.stream().filter(Animal::isHungry).toList(), cell);
                moveService.tryToMove(fieldOfGame.getField(i, j).getAnimalsInCell(), i, j);

            }
        }

    }


    private void startingLife(List<Animal> animalList, FieldOfGame.Cell cell) {
        for (int k = 0; k < animalList.size() - 1; k++) {
            Animal animal1 = animalList.get(k);
            multiplyService.multiply(animal1, cell);
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
                eatService.eat(animal1, animal2, cell);
            }
            if (animal1.getExtendType() == TypeOfAnimals.HERBIVOROUS) {
                eatService.eat(animal1, cell);
            }
        }
    }


}
