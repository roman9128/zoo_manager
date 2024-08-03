package animals;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Animal {

    int id;
    String name;
    AnimalType type;
    LocalDate birthDate;
    ArrayList<String> commands;
}