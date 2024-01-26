package org.example.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.map.FieldOfGame;
import org.example.organism.animals.Animal;
import org.example.organism.animals.AnimalType;
import org.example.settings.ConfigLoader;

public class LoggerLife {
   private static final Logger logger= LogManager.getLogger(LoggerLife.class);
    private final FieldOfGame field=FieldOfGame.getInstance();
    private final AnimalType[] values=AnimalType.values();
    public void log(int day) {
        logger.info("DAY NUMBER {}", day);
        logger.info("-------______-------");
        for (int i = 0; i < field.getHeight(); i++) {
            for (int j = 0; j < field.getWidth(); j++) {
                final FieldOfGame.Cell cell = field.getField(i, j);
                logger.info("Cell number :  [{}]  [{}]", i, j );
                logger.info("Count of animals in cell = {}", cell.getCountAllAnimals());
                logger.info("Count of plants in cell = {}", cell.getCountAllPlants());
                for (AnimalType animalType : values) {
                    Animal animal = animalType.createAnimal();
                    logger.info("Count of {} = {}", ConfigLoader.getStringProperty(animal.getUnicode()), cell.getCountExactAnimal(animalType) );
                }
                logger.info("~~~~~~~~~~~~~~~~~~~~");
            }
        }
    }
}
