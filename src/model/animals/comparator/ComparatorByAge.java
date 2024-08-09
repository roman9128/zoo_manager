package model.animals.comparator;

import java.util.Comparator;

import model.animals.Animal;

public class ComparatorByAge implements Comparator<Animal> {

    @Override
    public int compare(Animal o1, Animal o2) {
        return o2.getAge() - o1.getAge();
    }
}