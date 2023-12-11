package org.example.gameAlg;

import org.example.organism.animals.Animal;
import org.example.organism.plants.Plants;

import java.util.*;

public class Square {
    private final int i;
    private final int j;
    private final List<Square> neighbours = new ArrayList<>();
    private final Map<String, Set<Plants>> plantsInSquare = new HashMap<>();
    private final Map<String, Set<Animal>> animalsInSquare = new HashMap<>();

    public List<Square> getNeighbours() {
        return neighbours;
    }

    public Map<String, Set<Plants>> getPlantsInSquare() {
        return plantsInSquare;
    }

    public Map<String, Set<Animal>> getAnimalsInSquare() {
        return animalsInSquare;
    }

    public Square(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public void addNeighboursInSquare(Square square) {
        neighbours.add(square);
    }


}
