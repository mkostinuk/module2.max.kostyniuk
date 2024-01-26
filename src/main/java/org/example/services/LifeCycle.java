package org.example.services;

import lombok.SneakyThrows;
import org.example.map.FieldOfGame;
import org.example.organism.animals.Animal;
import org.example.organism.animals.AnimalType;
import org.example.settings.ConfigLoader;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class LifeCycle {

    private final FieldOfGame field;
    private final String CONFIG_KEY = "lifecycle.";
    private final ExecutorService executorService;
    private final int waitTime;
    private final AnimalType[] values = AnimalType.values();
    private final static Random RANDOM = new Random();
    private final static LoggerLife LOGGER = new LoggerLife();


    public LifeCycle() {
        executorService = Executors.newFixedThreadPool(3);
        waitTime = ConfigLoader.getIntegerProperty(CONFIG_KEY + "wait-time");
        field = FieldOfGame.getInstance();
    }

    @SneakyThrows
    public void startLife() {
        init();
        LOGGER.log(0);
        TimeUnit.MILLISECONDS.sleep(waitTime);
        executorService.submit(new AnimalCycle());
        executorService.submit(new PlantCycle());
        executorService.shutdown(

        );
        LOGGER.log(1);
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
        int height = field.getHeight();
        int width = field.getWidth();
        do {
            final int tmpHeight = RANDOM.nextInt(0, height);
            final int tmpWidth = RANDOM.nextInt(0, width);
            FieldOfGame.Cell cell = field.getField(tmpHeight, tmpWidth);
            boolean isAdd;
            if (type != null) {
                final Animal animal = type.createAnimal();
                isAdd = field.addAnimal(animal, cell);
            } else {
                isAdd = field.addPlant(cell);
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


}
