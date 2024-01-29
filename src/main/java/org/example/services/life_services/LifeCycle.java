package org.example.services.life_services;

import lombok.SneakyThrows;
import org.example.services.LoggerLife;
import org.example.services.life_services.animal_services.AnimalCycle;
import org.example.services.life_services.animal_services.DeathService;
import org.example.services.life_services.init_services.Init;
import org.example.services.life_services.init_services.InitFabric;
import org.example.services.life_services.plant_services.PlantCycle;
import org.example.settings.ConfigLoader;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class LifeCycle {

    private final DeathService deathService = new DeathService();
    private final ExecutorService executorService;
    private final int waitTime;
    private final static LoggerLife LOGGER = new LoggerLife();
    private final int days;
    private final Init initAnimals = InitFabric.build(OrganismEnum.ANIMALS);
    private final Init initPlants = InitFabric.build(OrganismEnum.PLANTS);


    public LifeCycle() {
        final String configKey = "lifecycle.";
        executorService = Executors.newFixedThreadPool(2);
        waitTime = ConfigLoader.getIntegerProperty(configKey + "wait-time");
        days = ConfigLoader.getIntegerProperty(configKey + "days");
    }

    @SneakyThrows
    public void startLife() {
        init();
        LOGGER.log(0);
        TimeUnit.MILLISECONDS.sleep(waitTime);
        for (int i = 1; i <= days; i++) {
            if (deathService.extinction()) {
                LOGGER.unExpectedEnd();
                return;
            }
            executorService.submit(new AnimalCycle());
            executorService.submit(new PlantCycle());
            LOGGER.log(i);
            TimeUnit.MILLISECONDS.sleep(waitTime);
        }
        executorService.shutdown();
        if (executorService.isShutdown()) {
            LOGGER.theEnd();
        }
    }


    public void init() {
        initAnimals.init();
        initPlants.init();
    }


}
