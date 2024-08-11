package model;

import java.time.LocalDate;

import model.animals.Animal;
import model.animals.AnimalBuilder;
import model.animals.enums.AnimalGroup;
import model.animals.enums.AnimalType;
import model.common_list.CommonList;

public class Service {

    private CommonList commonList;
    private AnimalBuilder animalBuilder;

    public Service() {
        commonList = new CommonList();
        animalBuilder = new AnimalBuilder();
    }

    public void addNewAnimal(String name, AnimalType type) {
        Animal animal = animalBuilder.makeAnimal(name, type);
        commonList.addAnimal(animal);
    }

    public void setBirthDate(int animalID, String birthDateString) {
        try {
            LocalDate birthDate = transferToDate(birthDateString);
            commonList.getAnimalOnID(animalID).setBirthDate(birthDate);
        } catch (Exception e) {
            System.out.println("Errare humanum est. Try again");
        }
    }

    public String showCommands(int animalID) {
        return commonList.getAnimalOnID(animalID).getCommands().toString();
    }

    // public void teachOneNewCommand(int animalID, String command) {
    // commonList.getAnimalOnID(animalID).addNewCommand(command);
    // }

    public void teachNewCommands(int animalID, String commandsList) {
        commonList.getAnimalOnID(animalID).addCommandsAsList(commandsList);
    }

    public String getListbyID() {
        commonList.sortByID();
        return printList();
    }

    public String getListbyBirthDate() {
        commonList.sortByAge();
        return printList();
    }

    private String printList() {
        StringBuilder builder = new StringBuilder();
        builder.append("id\tname\ttype\tbirthDate\tcommands\n");
        for (Animal animal : commonList) {
            builder.append(animal);
            builder.append("\n");
        }
        return builder.toString();
    }

    public String filterListbyAnimalType(AnimalType type) {
        commonList.sortByID();
        StringBuilder builder = new StringBuilder();
        builder.append("id\tname\ttype\tbirthDate\tcommands\n");
        for (Animal animal : commonList) {
            if (animal.getType().equals(type)) {
                builder.append(animal);
                builder.append("\n");
            }
        }
        return builder.toString();
    }

    // public String filterListbyAnimalGroup(AnimalGroup group) {
    //     commonList.sortByID();
    //     StringBuilder builder = new StringBuilder();
    //     builder.append("id\tname\ttype\tbirthDate\tcommands\n");
    //     for (Animal animal : commonList) {
    //         if (animal instanceof Animal) {
    //             builder.append(animal);
    //             builder.append("\n");
    //         }
    //     }
    //     return builder.toString();
    // }

    public int showTotalAmountOfAnimals() {
        return commonList.getTotalAmount();
    }

    public String animalMakesSound(int animalID) {
        return commonList.getAnimalOnID(animalID).voice();
    }

    private LocalDate transferToDate(String dateString) {
        try {
            String[] dateArr = dateString.split("-");
            int year = 2000;
            int month = 1;
            int day = 1;
            if (checkForInt(dateArr[0])) {
                year = Integer.parseInt(dateArr[0]);
            }
            if (checkForInt(dateArr[1])) {
                month = Integer.parseInt(dateArr[1]);
            }
            if (checkForInt(dateArr[2])) {
                day = Integer.parseInt(dateArr[2]);
            }
            LocalDate date_to_send = LocalDate.of(year, month, day);
            return date_to_send;
        } catch (Exception e) {
            return null;
        }
    }

    private boolean checkForInt(String string) {
        if (string.matches("[0-9]*")) {
            return true;
        }
        return false;
    }
}