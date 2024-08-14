package model.animals.pets;

import java.time.LocalDate;

import model.animals.enums.AnimalType;

public class Dog extends Pet {

    public Dog(int id, String name, LocalDate birthDate) {
        super(id, name, AnimalType.dog, birthDate);
    }

    @Override
    public String voice() {
        return "woof";
    }
}