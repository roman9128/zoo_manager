package model.animals.pack_animals;

import model.animals.Animal;
import model.animals.enums.AnimalGroup;
import model.animals.enums.AnimalType;

public abstract class PackAnimal extends Animal {

    public PackAnimal(int id, String name, AnimalType type) {
        super(id, name, type, AnimalGroup.pack_s);
    }

    public String whatAreYouDoing (){
        return "I work";
    }
}