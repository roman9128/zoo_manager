package model.animals.pets;

import java.time.LocalDate;

import model.animals.Animal;
import model.animals.enums.AnimalGroup;
import model.animals.enums.AnimalType;

public abstract class Pet extends Animal {

    public Pet(int id, String name, AnimalType type, LocalDate birthDate) {
        super(id, name, type, AnimalGroup.pets, birthDate);
    }

    public String whatAreYouDoing (){
        return "I enjoy my life";
    }
}