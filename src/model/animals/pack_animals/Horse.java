package model.animals.pack_animals;

import model.animals.AnimalType;

public class Horse extends PackAnimal {

    public Horse(int id, String name) {
        super(id, name, AnimalType.horse);
    }

    @Override
    public String voice() {
        return "igo-go";
    }
}