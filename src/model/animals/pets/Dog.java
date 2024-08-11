package model.animals.pets;

import model.animals.enums.AnimalType;

public class Dog extends Pet {

    public Dog(int id, String name) {
        super(id, name, AnimalType.dog);
    }

    @Override
    public String voice() {
        return "woof";
    }
}