package model.animals;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import model.animals.enums.AnimalType;

public abstract class Animal {

    int id;
    String name;
    AnimalType type;
    LocalDate birthDate;
    List<String> commands;

    public Animal(int id, String name, AnimalType type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public abstract String voice();

    public void addCommandsAsList(String commandsList) {
        String[] commandsListArray = commandsList.split(", ");
        if (commands == null) {
            commands = new ArrayList<>();
        }
        Collections.addAll(commands, commandsListArray);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AnimalType getType() {
        return type;
    }

    public void setType(AnimalType type) {
        this.type = type;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public List<String> getCommands() {
        return commands;
    }

    public void setCommands(ArrayList<String> commands) {
        this.commands = commands;
    }

    public int getAge() {
        return getPeriod(birthDate, LocalDate.now());
    }

    private int getPeriod(LocalDate birthDate, LocalDate now) {
        if (birthDate == null) {
            birthDate = LocalDate.of(2000, 1, 1);
        }
        Period period = Period.between(birthDate, now);
        return period.getDays();
    }

    @Override
    public String toString() {
        return id + "\t" + name + "\t" + type + "\t" + birthDate + "\t" + commands;
    }
}