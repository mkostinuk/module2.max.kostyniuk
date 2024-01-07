package org.example.map;

import org.example.organism.Organism;
import org.example.organism.animals.Animal;
import org.example.organism.plants.Plants;
import org.example.settings.ConfigLoader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class FieldOfGame {
    private final int HEIGHT;
    private final int WIDTH;
    private static FieldOfGame instance;
    private final int maxPlantsCount;
    private final Cell[][] field;

    private FieldOfGame() {
        String CONFIG_KEY = "map.";
        HEIGHT = ConfigLoader.getIntegerProperty(CONFIG_KEY + "height");
        WIDTH = ConfigLoader.getIntegerProperty(CONFIG_KEY + "width");
        maxPlantsCount = ConfigLoader.getIntegerProperty(CONFIG_KEY + "plants.load");
        field = new Cell[HEIGHT][WIDTH];
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                field[i][j] = new Cell();
            }
        }
    }

    public boolean addAnimal(final Animal animal, final int height, final int width) {
        final Cell cell = field[height][width];
        if (isAllowedToAdd(cell.getCountExactAnimal(animal), animal.getMaxCount())) {
            cell.animalsInCell.add(animal);
            cell.countAllAnimals++;
            return true;
        }
        return false;
    }

    public boolean addPlant(final int height, final int width) {
        Plants plants = new Plants();
        final Cell cell = field[height][width];
        if (isAllowedToAdd(cell.countAllPlants, maxPlantsCount)) {
            cell.plantsInCell.add(plants);
            cell.countAllPlants++;
            return true;
        }
        return false;
    }

    public void deleteAnimal(Animal animal, int height, int width) {
        final Cell cell = field[height][width];
        cell.animalsInCell.remove(animal);
        cell.countAllAnimals--;
    }

    public void deletePlants(int height, int width) {
        final Cell cell = field[height][width];
        cell.plantsInCell.remove(0);
        cell.countAllPlants--;
    }

    public void multiply(Organism organism, int height, int width) {
        if (organism instanceof Animal) {
                addAnimal((Animal) organism, height, width);
        } else if (organism instanceof Plants) {
                addPlant(height, width);
        }
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
        if(instance==null) {
            instance=new FieldOfGame();
        }
        return instance;
    }

    public class Cell {
        private int countAllPlants = 0;
        private int countAllAnimals = 0;

        public int getCountAllAnimals() {
            return countAllAnimals;
        }

        public Map<Animal, Integer> getSaturate() {
            Map<Animal, Integer> saturate = new HashMap<>();
            for (int i = 0; i < getAnimalsInCell().size(); i++) {
                saturate.put(animalsInCell.get(i), 0);
            }
            return saturate;
        }

        private final List<Animal> animalsInCell = new ArrayList<>();
        private final List<Plants> plantsInCell = new ArrayList<>();

        public List<Animal> getAnimalsInCell() {
            return animalsInCell;
        }


        public int getCountAllPlants() {
            return countAllPlants;
        }

        public int getCountExactAnimal(Animal animal) {
            List<Animal> animals = animalsInCell.stream().filter(s -> s.getClass().getSimpleName().equals(animal.getClass().getSimpleName())).toList();
            return animals.size();
        }

    }
}


