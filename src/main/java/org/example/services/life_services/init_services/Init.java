package org.example.services.life_services.init_services;

import org.example.map.FieldOfGame;
import org.example.organism.animals.Animal;
import org.example.organism.animals.AnimalType;

import java.util.Random;

public abstract class Init {
    protected AnimalType[] values = AnimalType.values();
    protected final String configKey = "init.";
    private final FieldOfGame field = FieldOfGame.getInstance();
    private final static Random RANDOM = new Random();

    public abstract void init();

    protected void initOrganism(int baseCount, AnimalType type) {
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
}
