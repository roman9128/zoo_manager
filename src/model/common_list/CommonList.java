package model.common_list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.animals.Animal;
import model.animals.AnimalIterator;
import model.animals.comparator.ComparatorByAge;
import model.animals.comparator.ComparatorByID;

public class CommonList implements Iterable<Animal> {

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

    public Animal getAnimalOnID(int animalID) {
        return animalList.get(animalID);
    }

    public int getTotalAmount() {
        return animalList.size();
    }

    public void sortByAge() {
        animalList.sort(new ComparatorByAge());
    }

    public void sortByID() {
        animalList.sort(new ComparatorByID());
    }

    @Override
    public Iterator<Animal> iterator() {
        return new AnimalIterator(animalList);
    }
}