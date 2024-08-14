package model.animals.pack_animals;

import java.time.LocalDate;

import model.animals.enums.AnimalType;

public class Camel extends PackAnimal {

    public Camel(int id, String name, LocalDate birthDate) {
        super(id, name, AnimalType.camel, birthDate);
    }

    @Override
    public String voice() {
        return "mghr";
    }
}