package org.example.services;

import org.example.map.FieldOfGame;

import java.util.Random;

public class PlantCycle implements Runnable {
    private final Random random = new Random();
    private final FieldOfGame fieldOfGame = FieldOfGame.getInstance();

    @Override
    public void run() {
        for (int i = 0; i < fieldOfGame.getHeight(); i++) {
            for (int j = 0; j < fieldOfGame.getWidth(); j++) {
                multiply(fieldOfGame.getField(i, j));
            }
        }
    }

    private void multiply(FieldOfGame.Cell cell) {
        if (random.nextInt(100) >= 50) {
            for (int i = 0; i < cell.getCountAllPlants(); i++) {
                fieldOfGame.multiply(cell);
            }
        }
    }
}

