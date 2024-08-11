package model.animals.pack_animals;

import model.animals.enums.AnimalType;

public class Camel extends PackAnimal {

    public Camel(int id, String name) {
        super(id, name, AnimalType.camel);
    }

    @Override
    public String voice() {
        return "mghr";
    }
}