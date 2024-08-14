package model.animals.comparator;

import java.util.Comparator;

import model.animals.Animal;

public class ComparatorByAge implements Comparator<Animal> {

    @Override
    public int compare(Animal o1, Animal o2) {
        if (o2.getBirthDate().isBefore(o1.getBirthDate())) {
            return 1;
        } else if (o2.getBirthDate().isAfter(o1.getBirthDate())) {
            return -1;
        } else {
            return 0;
        }
    }
}