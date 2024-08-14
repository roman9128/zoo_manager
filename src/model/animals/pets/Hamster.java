package model.animals.pets;

import java.time.LocalDate;

import model.animals.enums.AnimalType;

public class Hamster extends Pet {

    public Hamster(int id, String name, LocalDate birthDate) {
        super(id, name, AnimalType.hamster, birthDate);
    }

    @Override
    public String voice() {
        return "pee";
    }
}