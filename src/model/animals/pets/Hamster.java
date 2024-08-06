package model.animals.pets;

import model.animals.AnimalType;

public class Hamster extends Pet {

    public Hamster(int id, String name) {
        super(id, name, AnimalType.hamster);
    }

    @Override
    public String voice() {
        return "pee";
    }
}