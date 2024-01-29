package org.example.services.life_services.animal_services;

import org.example.map.FieldOfGame;
import org.example.organism.animals.Animal;

import java.util.List;

public class DeathService {
    private final FieldOfGame fieldOfGame = FieldOfGame.getInstance();

    public void deathByHunger(List<Animal> animalList, FieldOfGame.Cell cell) {
        animalList.forEach(s -> fieldOfGame.deleteAnimal(s, cell));
    }
    public boolean extinction() {
        int k = 0;
        for (int i = 0; i < fieldOfGame.getHeight(); i++) {
            for (int j = 0; j < fieldOfGame.getWidth(); j++) {
                if (fieldOfGame.getField(i, j).getAnimalsInCell().isEmpty()) {
                    k++;
                }
            }
        }
        return k >= 5;
    }
}
