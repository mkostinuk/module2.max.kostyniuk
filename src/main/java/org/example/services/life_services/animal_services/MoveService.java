package org.example.services.life_services.animal_services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.map.FieldOfGame;
import org.example.organism.animals.Animal;

import java.util.List;
import java.util.Random;

 class MoveService {
    private final static Random RANDOM=new Random();
    private final static Logger LOGGER= LogManager.getLogger(MoveService.class);
    private final FieldOfGame fieldOfGame = FieldOfGame.getInstance();


    private boolean moveOrNot() {
        return RANDOM.nextBoolean();
    }

    public void tryToMove(List<Animal> animalList, int i, int j) {
        animalList.forEach(s -> move(s, i, j));
    }

    private void move(Animal animal, int i, int j) {
        if (moveOrNot()) {
            if (i + animal.getSpeed() <= fieldOfGame.getHeight()) {
                relocate(animal, i, j, i + animal.getSpeed(), j);
            } else if (j + animal.getSpeed() <= fieldOfGame.getWidth()) {
                relocate(animal, i, j, i, j + animal.getSpeed());
            } else if (i - animal.getSpeed() >= 0) {
                relocate(animal, i, j, i - animal.getSpeed(), j);
            } else if (j - animal.getSpeed() >= 0) {
                relocate(animal, i, j, i, j - animal.getSpeed());
            } else {
                LOGGER.error("Can`t find new Cell");
                throw new RuntimeException();
            }
        }
    }

    private void relocate(Animal animal, int i, int j, int newI, int newJ) {
        fieldOfGame.deleteAnimal(animal, fieldOfGame.getField(i, j));
        fieldOfGame.addAnimal(animal, fieldOfGame.getField(newI, newJ));
    }
}
