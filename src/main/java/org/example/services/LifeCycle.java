package org.example.services;

import org.example.map.FieldOfGame;
import org.example.organism.animals.Animal;
import org.example.organism.animals.AnimalType;
import org.example.settings.ConfigLoader;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class LifeCycle {
    FieldOfGame field;
    private final String CONFIG_KEY = "lifecycle.";
    private final ExecutorService executorService;
    private final int waitTime;
    final AnimalType[] values = AnimalType.values();
    private final static Random random = new Random();

    public LifeCycle() {
        executorService = Executors.newFixedThreadPool(3);
        waitTime = ConfigLoader.getIntegerProperty(CONFIG_KEY + "wait-time");
        field = FieldOfGame.getInstance();
    }

    public void startLife() {
        System.out.println("Day - 0");
        System.out.println("______~~_______");
        init();
        info();
        for (int i = 1; i <366 ; i++) {
            System.out.println("Day - " + i);
            executorService.submit(new AnimalCycle());
            executorService.submit(new PlantCycle());
            System.out.println("______~~_______");
            info();
            try {
                TimeUnit.MILLISECONDS.sleep(waitTime);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void initAnimals() {
        for (AnimalType type : values) {
            int countOFAnimals = ConfigLoader.getIntegerProperty(CONFIG_KEY + "init-count-animals");
            initOrganism(countOFAnimals, type);
        }

    }

    public void initPlants() {
        int countOfPlants = ConfigLoader.getIntegerProperty(CONFIG_KEY + "init-count-plants");
        initOrganism(countOfPlants, null);
    }

    public void initOrganism(int baseCount, AnimalType type) {
        int count = 0;
        int height = field.getHEIGHT();
        int width = field.getWIDTH();
        do {
            final int tmpHeight = random.nextInt(0, height);
            final int tmpWidth = random.nextInt(0, width);
            boolean isAdd;
            if (type != null) {
                final Animal animal = type.createAnimal();
                isAdd = field.addAnimal(animal, tmpHeight, tmpWidth);
            } else {
                isAdd = field.addPlant(tmpHeight, tmpWidth);
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
        for (int i = 0; i < field.getHEIGHT(); i++) {
            for (int j = 0; j < field.getWIDTH(); j++) {
                final FieldOfGame.Cell cell = field.getField(i, j);
                System.out.println("Cell number: " + "[" + i + "]" + "[" + j + "]");
                System.out.println("Count of animals in Cell" + " = " + cell.getCountAllAnimals());
                System.out.println("Count of Plants in Cell" + " = " + cell.getCountAllPlants());
                for (AnimalType animalType : values) {
                    Animal animal = animalType.createAnimal();
                    System.out.println("Count of " + ConfigLoader.getStringProperty(animal.getUnicode()) + " = " + cell.getCountExactAnimal(animal));
                }
                System.out.println("~~~~~~~~~~~~~~~~~~~~");
            }
        }
    }


}
