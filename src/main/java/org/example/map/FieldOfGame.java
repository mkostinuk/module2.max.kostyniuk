package org.example.map;

import org.example.organism.Organism;
import org.example.organism.animals.Animal;
import org.example.organism.plants.Plants;
import org.example.settings.ConfigLoader;

import java.util.ArrayList;
import java.util.List;

public class FieldOfGame {
    private final int HEIGHT;
    private final int WIDTH;
    private static FieldOfGame instance;
    private final int maxAnimalsCount;
    private final int maxPlantsCount;
    private final Cell[][] field;

    private FieldOfGame() {
        String CONFIG_KEY = "map.";
        HEIGHT = ConfigLoader.getIntegerProperty(CONFIG_KEY + "height");
        WIDTH = ConfigLoader.getIntegerProperty(CONFIG_KEY + "weight");
        maxAnimalsCount = ConfigLoader.getIntegerProperty(CONFIG_KEY + "animals.load");
        maxPlantsCount = ConfigLoader.getIntegerProperty(CONFIG_KEY + "plants.load");
        field = new Cell[HEIGHT][WIDTH];
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                field[i][j] = new Cell();
            }
        }
    }

    public void addAnimal(final Animal animal, final int height, final int width) {
        final Cell cell = field[height][width];
        if (isAllowedToAdd(cell.countAllAnimals, maxAnimalsCount, cell.countExactAnimal, animal.getMaxCount())) {
            cell.animalsInCell.add(animal);
            cell.countAllAnimals++;
            cell.countExactAnimal++;// FIXME: 17.12.2023
        }
    }

    public void addPlant(final Plants plants, final int height, final int width) {
        final Cell cell = field[height][width];
        if (isAllowedToAdd(cell.countAllPlants, maxPlantsCount)) {
            cell.plantsInCell.add(plants);
            cell.countAllPlants++;
        }
    }

    private boolean isAllowedToAdd(int existValue, int maxValue, int existExactValue, int maxExactValue) {
        return existValue + 1 <= maxValue && existExactValue + 1 <= maxExactValue;
    }

    private boolean isAllowedToAdd(int existValue, int maxValue) {
        return existValue + 1 <= maxValue;
    }

    public Cell getField(final int height, final int width) {
        return field[height][width];
    }
    public int getHEIGHT() {
        return HEIGHT;
    }

    public int getWIDTH() {
        return WIDTH;
    }

    public static FieldOfGame getInstance() {
        return instance == null ? new FieldOfGame() : instance;
    }

    public class Cell {
        private int countExactAnimal = 0;// FIXME: 17.12.2023
        private int countAllAnimals = 0;
        private int countAllPlants = 0;
        private final List<Animal> animalsInCell = new ArrayList<>();
        private final List<Plants> plantsInCell = new ArrayList<>();

        public int getCountExactAnimal() {
            return countExactAnimal;
        }

        public List<Animal> getAnimalsInCell() {
            return animalsInCell;
        }

        public List<Plants> getPlantsInCell() {
            return plantsInCell;
        }

        public int getCountAllAnimals() {
            return countAllAnimals;
        }

        public int getCountAllPlants() {
            return countAllPlants;
        }

    }
}


