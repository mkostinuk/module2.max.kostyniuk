package org.example;

import org.example.map.FieldOfGame;
import org.example.organism.animals.Animal;
import org.example.organism.animals.AnimalType;
import org.example.settings.ConfigLoader;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LifeCycle {
    private final String CONFIG_KEY = "lifecycle.";
    private final ExecutorService executorService;
    private final int waitTime;
    private final static Random random = new Random();

    public LifeCycle() {
        executorService = Executors.newFixedThreadPool(3);
        waitTime = ConfigLoader.getIntegerProperty(CONFIG_KEY + "wait-time");

    }

    public void startLife() {
        init();
        info();
    }

    public void initAnimals() {
        final AnimalType[] values = AnimalType.values();
        for (AnimalType type : values) {
            initOrganism(type.createAnimal().getMaxCount(), type);
        }

    }

    public void initPlants() {
        int countOfPlants = ConfigLoader.getIntegerProperty("plants.max-count");
        initOrganism(countOfPlants, null);
    }

    public void initOrganism(int baseCount, AnimalType type) {
        int count = 0;
        FieldOfGame fieldOfGame = FieldOfGame.getInstance();
        int height = fieldOfGame.getHEIGHT();
        int width = fieldOfGame.getWIDTH();
        do {
            final int tmpHeight = random.nextInt(0, height);
            final int tmpWidth = random.nextInt(0, width);
            boolean isAdd;
            if (type != null) {
                final Animal animal = type.createAnimal();
                isAdd = fieldOfGame.addAnimal(animal, tmpHeight, tmpWidth);
            } else {
                isAdd = fieldOfGame.addPlant(tmpHeight, tmpWidth);
            }
            if (isAdd) {
                count++;
            }

        }
        while (count < baseCount);
    }

    public void init() {
        initAnimals();
        initPlants();
    }

    public void info() {
        AnimalType[] animalTypes = AnimalType.values();
        FieldOfGame field = FieldOfGame.getInstance();
        for (int i = 0; i < field.getHEIGHT(); i++) {
            for (int j = 0; j < field.getWIDTH(); j++) {
                final FieldOfGame.Cell cell = field.getField(i, j);
                System.out.println("Cell number: " + "[" + i + "]" + "[" + j + "]");
                System.out.println("Count of animals in Cell" + " = " + cell.getCountAllAnimals());
                System.out.println("Count of Plants in Cell" + " = " + cell.getCountAllPlants());
                for (AnimalType animalType : animalTypes) {
                    Animal animal = animalType.createAnimal();
                    System.out.println("Count of " + animal.getName() + " = " + cell.getCountExactAnimal(animal));
                }
                System.out.println("~~~~~~~~~~~~~~~~~~~~");
            }
        }
    }
}
