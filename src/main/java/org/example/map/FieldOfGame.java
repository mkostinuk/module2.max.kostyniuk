package org.example.map;


import lombok.Getter;
import org.example.organism.animals.Animal;
import org.example.organism.animals.AnimalType;
import org.example.organism.plants.Plants;
import org.example.settings.ConfigLoader;

import java.util.*;


public class FieldOfGame {
    @Getter
    private final int height;
    @Getter
    private final int width;
    private static FieldOfGame instance;
    private final int maxPlantsCount;
    private final Cell[][] field;

    private FieldOfGame() {
        String CONFIG_KEY = "map.";
        height = ConfigLoader.getIntegerProperty(CONFIG_KEY + "height");
        width = ConfigLoader.getIntegerProperty(CONFIG_KEY + "width");
        maxPlantsCount = ConfigLoader.getIntegerProperty(CONFIG_KEY + "plants.load");
        field = new Cell[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                field[i][j] = new Cell();
            }
        }
    }

    public boolean addAnimal(final Animal animal, Cell cell) {
        if (isAllowedToAdd(cell.getCountExactAnimal(animal.getType()), animal.getMaxCount())) {
            cell.animalsInCell.add(animal);
            return true;
        }
        return false;
    }

    public boolean addPlant(Cell cell) {
        Plants plants = new Plants();
        if (isAllowedToAdd(cell.getCountAllPlants(), maxPlantsCount)) {
            cell.plantsInCell.add(plants);

            return true;
        }
        return false;
    }

    public void deleteAnimal(Animal animal, Cell cell) {
        cell.animalsInCell.remove(animal);

    }

    public boolean deletePlants(Cell cell) {
        if (cell.getCountAllPlants() > 0) {
            cell.plantsInCell.remove(0);
            return true;
        }
        return false;
    }

    public void multiply(Animal animal, Cell cell) {
        addAnimal(animal, cell);
    }

    public void multiply(Cell cell) {
        for (int i = 0; i < cell.getCountAllPlants(); i++) {
            addPlant(cell);
        }

    }

    private boolean isAllowedToAdd(int existValue, int maxValue) {
        return existValue + 1 <= maxValue;
    }


    public Cell getField(final int height, final int width) {
        return field[height][width];
    }


    public static FieldOfGame getInstance() {
        if (instance == null) {
            instance = new FieldOfGame();
        }
        return instance;
    }

    public static class Cell {

        public int getCountAllAnimals() {
            return animalsInCell.size();
        }

        @Getter
        private final List<Animal> animalsInCell = new ArrayList<>();
        private final List<Plants> plantsInCell = new ArrayList<>();

        public int getCountAllPlants() {
            return plantsInCell.size();
        }

        public int getCountExactAnimal(AnimalType animalType) {
            return (int) animalsInCell.stream().filter(s -> s.getType() == animalType).count();
        }

    }
}


