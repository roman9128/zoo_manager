package model.animals.pack_animals;

import java.time.LocalDate;

import model.animals.enums.AnimalType;

public class Donkey extends PackAnimal {

    public Donkey(int id, String name, LocalDate birthDate) {
        super(id, name, AnimalType.donkey, birthDate);
    }

    @Override
    public String voice() {
        return "hee-haw";
    }
}