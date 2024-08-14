package model.animals.pack_animals;

import java.time.LocalDate;

import model.animals.Animal;
import model.animals.enums.AnimalGroup;
import model.animals.enums.AnimalType;

public abstract class PackAnimal extends Animal {

    public PackAnimal(int id, String name, AnimalType type, LocalDate birthDate) {
        super(id, name, type, AnimalGroup.pack_animals, birthDate);
    }

    public String whatAreYouDoing (){
        return "I work";
    }
}