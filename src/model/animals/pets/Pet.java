package model.animals.pets;

import model.animals.Animal;
import model.animals.AnimalType;

public abstract class Pet extends Animal {

    public Pet(int id, String name, AnimalType type) {
        super(id, name, type);
    }
}