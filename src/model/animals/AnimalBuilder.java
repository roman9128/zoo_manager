package model.animals;

import java.time.LocalDate;

import model.animals.enums.AnimalType;
import model.animals.pack_animals.*;
import model.animals.pets.*;

public class AnimalBuilder {

    private int id = 1;

    public Animal makeAnimal(String name, AnimalType type, LocalDate birthDate) {
        if (type.equals(AnimalType.camel)) {
            return new Camel(id++, name, birthDate);
        }
        else if (type.equals(AnimalType.cat)) {
            return new Cat(id++, name, birthDate);
        }
        else if (type.equals(AnimalType.dog)) {
            return new Dog(id++, name, birthDate);
        }
        else if (type.equals(AnimalType.donkey)) {
            return new Donkey(id++, name, birthDate);
        }
        else if (type.equals(AnimalType.hamster)) {
            return new Hamster(id++, name, birthDate);
        }
        else if (type.equals(AnimalType.horse)) {
            return new Horse(id++, name, birthDate);
        }
        return null;
    }
}