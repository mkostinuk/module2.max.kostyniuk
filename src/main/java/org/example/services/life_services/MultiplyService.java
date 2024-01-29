package org.example.services.life_services;

import org.example.map.FieldOfGame;
import org.example.organism.animals.Animal;

import java.util.Random;

public class MultiplyService {
    private static final Random RANDOM = new Random();
    private final FieldOfGame fieldOfGame = FieldOfGame.getInstance();
    private boolean canMultiply() {
        int r = RANDOM.nextInt(100);
        return r > 80;

    }
    public void multiply(Animal animal, FieldOfGame.Cell cell) {
        if (canMultiply()) {
            fieldOfGame.multiply(animal, cell);
        }
    }
    public void multiply(FieldOfGame.Cell cell) {
        if (RANDOM.nextInt(100) >= 70) {
            for (int i = 0; i < cell.getCountAllPlants(); i++) {
                fieldOfGame.multiply(cell);
            }
        }
    }
}
