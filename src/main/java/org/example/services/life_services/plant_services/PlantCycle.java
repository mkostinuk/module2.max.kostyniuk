package org.example.services.life_services.plant_services;

import org.example.map.FieldOfGame;
import org.example.services.life_services.MultiplyService;


public class PlantCycle implements Runnable {

    private final FieldOfGame fieldOfGame = FieldOfGame.getInstance();
    private final MultiplyService multiplyService = new MultiplyService();

    @Override
    public void run() {
        for (int i = 0; i < fieldOfGame.getHeight(); i++) {
            for (int j = 0; j < fieldOfGame.getWidth(); j++) {
                multiplyService.multiply(fieldOfGame.getField(i, j));
            }

        }
    }


}

