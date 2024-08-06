package model.animals.pack_animals;

import model.animals.Animal;
import model.animals.AnimalType;

public abstract class PackAnimal extends Animal {

    public PackAnimal(int id, String name, AnimalType type) {
        super(id, name, type);
    }

}
