package model.animals.pets;

import model.animals.AnimalType;

public class Cat extends Pet {

    public Cat(int id, String name) {
        super(id, name, AnimalType.cat);
    }

    @Override
    public String voice() {
        return "meow";
    }
}