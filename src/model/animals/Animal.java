package model.animals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import model.animals.enums.*;

public abstract class Animal {

    int id;
    String name;
    AnimalType type;
    AnimalGroup group;
    LocalDate birthDate;
    List<String> commands;

    public Animal(int id, String name, AnimalType type, AnimalGroup group, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.group = group;
        this.birthDate = birthDate;
    }

    public abstract String voice();

    public abstract String whatAreYouDoing();

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

    public AnimalGroup getGroup() {
        return group;
    }

    public void setGroup(AnimalGroup group) {
        this.group = group;
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

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(id);
        builder.append("\t");
        builder.append(name);
        builder.append("\t");
        builder.append(group);
        builder.append("\t");
        if (!group.equals(AnimalGroup.pack_animals)) {
            builder.append("\t");
        }
        builder.append(type);
        builder.append("\t");
        builder.append(birthDate);
        builder.append("\t");
        if (birthDate == null) {
            builder.append("\t");
        }
        builder.append(commands);
        return builder.toString();
    }
}