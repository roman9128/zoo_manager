package model.common_list;

import java.util.ArrayList;
import java.util.List;

import model.animals.Animal;

public class CommonList {

    List<Animal> animalList;

    public CommonList() {
        animalList = new ArrayList<>();
    }

    public void addAnimal(Animal animal) {
        animalList.add(animal);
    }

    public List<Animal> getAnimalList() {
        return animalList;
    }
}