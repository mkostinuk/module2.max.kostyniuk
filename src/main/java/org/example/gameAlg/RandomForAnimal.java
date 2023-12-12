package org.example.gameAlg;



import org.example.organism.animals.Animal;
import org.example.organism.animals.Herbivorous.*;
import org.example.organism.animals.Predators.*;

import java.util.Random;

public class RandomForAnimal {
    Random random=new Random();
    public Animal nextAnimal(){
        int result=random.nextInt(1, 15);
        return switch(result){
            case 1 -> new Bear();
            case 2 -> new Boa();
            case 3 -> new Eagle();
            case 4 -> new Fox();
            case 5 -> new Wolf();
            case 6 -> new Boar();
            case 7 -> new Buffalo();
            case 8 -> new Bug();
            case 9 -> new Deer();
            case 10 -> new Duck();
            case 11 -> new Goat();
            case 12 -> new Horse();
            case 13 -> new Mouse();
            case 14 -> new Rabbit();
            case 15 -> new Sheep();
           default -> throw new IllegalStateException("Error of generation");
       };
    }
}
