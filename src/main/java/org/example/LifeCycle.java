package org.example;

import org.example.map.FieldOfGame;
import org.example.organism.animals.AnimalType;
import org.example.settings.ConfigLoader;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LifeCycle {
    private FieldOfGame field = FieldOfGame.getInstance();
    private final String CONFIG_KEY = "lifecycle.";
    private final ExecutorService executorService;
    private final int waitTime;
    private final static Random random = new Random();

    public LifeCycle() {
        executorService = Executors.newFixedThreadPool(3);
        waitTime = ConfigLoader.getIntegerProperty(CONFIG_KEY + "wait-time");

    }
    public void startLife(){
        init();
        info();
        //logic
    }

    public void initAnimals() {
        //
    }

    public void initPlants() {
        //
    }
    public void init(){
        initAnimals();
        initPlants();
    }

    private void info() {
        for (int i = 0; i < field.getHEIGHT(); i++) {
            for (int j = 0; j < field.getWIDTH(); j++) {
                final FieldOfGame.Cell cell = field.getField(i, j);
                System.out.println("Cell number: " + "[" + i + "]" + "[" + j + "]");
                System.out.println("Animal in Cell" + cell.getAnimalsInCell());
                System.out.println("Plants in Cell" + cell.getPlantsInCell());
            }
        }
    }
}
