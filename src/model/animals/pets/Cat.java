package model.animals.pets;

import java.time.LocalDate;

import model.animals.enums.AnimalType;

public class Cat extends Pet {

    public Cat(int id, String name, LocalDate birthDate) {
        super(id, name, AnimalType.cat, birthDate);
    }

    @Override
    public String voice() {
        return "meow";
    }
}