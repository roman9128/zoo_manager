package model.animals.comparator;

import java.util.Comparator;

import model.animals.Animal;

public class ComparatorByID implements Comparator<Animal> {

    @Override
    public int compare(Animal o1, Animal o2) {
        return o1.getId() - o2.getId();
    }
}