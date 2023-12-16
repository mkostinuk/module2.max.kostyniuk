package org.example.map;

import org.example.organism.animals.Animal;
import org.example.organism.plants.Plants;
import org.example.settings.ConfigLoader;

import java.util.ArrayList;
import java.util.List;

public class FieldOfGame {
private final String CONFIG_KEY;
private final int HEIGHT;
private final int WIDTH;
private static FieldOfGame instance;
private final int maxAnimalsCount;
private final int maxPlantsCount;
private final Cell[][] field;
private FieldOfGame(){
    CONFIG_KEY="map.";
    HEIGHT=ConfigLoader.getIntegerProperty(CONFIG_KEY+"height");
    WIDTH=ConfigLoader.getIntegerProperty(CONFIG_KEY+"weight");
    maxAnimalsCount=ConfigLoader.getIntegerProperty(CONFIG_KEY+"animals.load");
    maxPlantsCount=ConfigLoader.getIntegerProperty(CONFIG_KEY+"plants.load");
    field=new Cell[HEIGHT][WIDTH];
    for(int i=0; i<HEIGHT; i++){
        for (int j = 0; j <WIDTH ; j++) {
            field[i][j]=new Cell();
        }
    }
}
public void addAnimal(){
    // TODO: 16.12.2023
    }
    public void addPlant(){
        // TODO: 16.12.2023  
    }

    public Cell getField(final int height, final int width) {
        return field[height][width];
    }

    public static FieldOfGame getInstance() {
        return instance==null? new FieldOfGame() : instance;
    }

    public class Cell {
        private int countAnimals = 0;
        private int countPlants = 0;
        private final List<Animal> animalsInCell = new ArrayList<>();
        private final List<Plants> plantsInCell = new ArrayList<>();

        public List<Animal> getAnimalsInCell() {
            return animalsInCell;
        }

        public List<Plants> getPlantsInCell() {
            return plantsInCell;
        }

        public int getCountAnimals() {
            return countAnimals;
        }

        public int getCountPlants() {
            return countPlants;
        }


    }
}


