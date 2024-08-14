package model.animals.pack_animals;

import java.time.LocalDate;

import model.animals.enums.AnimalType;

public class Horse extends PackAnimal {

    public Horse(int id, String name, LocalDate birthDate) {
        super(id, name, AnimalType.horse, birthDate);
    }

    @Override
    public String voice() {
        return "igo-go";
    }
}