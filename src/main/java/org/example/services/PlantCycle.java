package org.example.services;

import org.example.map.FieldOfGame;
import org.example.organism.plants.Plants;

import java.util.Random;

public class PlantCycle implements Runnable
{
   private final Random random = new Random();
   private final FieldOfGame fieldOfGame = FieldOfGame.getInstance();
   private final Plants plants=new Plants();

@Override
    public void run() {
        for (int i = 0; i < fieldOfGame.getHEIGHT(); i++) {
            for (int j = 0; j < fieldOfGame.getWIDTH(); j++) {
                multiply(fieldOfGame.getHEIGHT(), fieldOfGame.getWIDTH());
            }
        }
    }
    private void multiply(int height, int width){
        if(random.nextInt(100)>50) fieldOfGame.multiply(plants, height, width);
        }
    }

