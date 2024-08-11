package model.animals.pack_animals;

import model.animals.enums.AnimalType;

public class Donkey extends PackAnimal {

    public Donkey(int id, String name) {
        super(id, name, AnimalType.donkey);
    }

    @Override
    public String voice() {
        return "hee-haw";
    }
}