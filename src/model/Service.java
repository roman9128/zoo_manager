package model;

import java.time.LocalDate;

import model.animals.Animal;
import model.animals.AnimalBuilder;
import model.animals.enums.*;
import model.common_list.CommonList;

public class Service {

    private CommonList commonList;
    private AnimalBuilder animalBuilder;

    public Service() {
        commonList = new CommonList();
        animalBuilder = new AnimalBuilder();
    }

    public void addNewAnimal(String name, String type, String birthDateString) {
        try {
            LocalDate birthDate = transferToDate(birthDateString);
            Animal animal = animalBuilder.makeAnimal(name, AnimalType.valueOf(type), birthDate);
            commonList.addAnimal(animal);
        } catch (Exception e) {
            System.out.println("Smth went wrong. Check the animal type you've entered & try again");
        }
    }

    public void setBirthDate(String animalIDString, String birthDateString) {
        try {
            int animalID = transferID(animalIDString);
            LocalDate birthDate = transferToDate(birthDateString);
            commonList.getAnimalOnID(animalID).setBirthDate(birthDate);
        } catch (Exception e) {
            System.out.println("Errare humanum est. Try again");
        }
    }

    public void teachNewCommands(String animalIDString, String commandsList) {
        try {
            int animalID = transferID(animalIDString);
            commonList.getAnimalOnID(animalID).addCommandsAsList(commandsList);
        } catch (Exception e) {
            System.out.println("Try again");
        }
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
        builder.append("\n________________________________________________________________________\n");
        builder.append("id\tname\tgroup\t\ttype\tbirthDate\tcommands\n");
        for (Animal animal : commonList) {
            builder.append(animal);
            builder.append("\n");
        }
        builder.append("\nTotal amount of animals in this table: ");
        builder.append(showTotalAmountOfAnimals());
        builder.append("\n________________________________________________________________________\n");
        return builder.toString();
    }

    public String filterListbyAnimalType(String type) {
        commonList.sortByID();
        StringBuilder builder = new StringBuilder();
        int count = 0;
        builder.append("\n________________________________________________________________________\n");
        builder.append("id\tname\tgroup\t\ttype\tbirthDate\tcommands\n");
        for (Animal animal : commonList) {
            if (animal.getType().equals(AnimalType.valueOf(type))) {
                count++;
                builder.append(animal);
                builder.append("\n");
            }
        }
        builder.append("Found animals: ");
        builder.append(count);
        builder.append(" of ");
        builder.append(showTotalAmountOfAnimals());
        builder.append("\n________________________________________________________________________\n");
        return builder.toString();
    }

    public String filterListbyAnimalGroup(String group) {
        commonList.sortByID();
        int count = 0;
        StringBuilder builder = new StringBuilder();
        builder.append("\n________________________________________________________________________\n");
        builder.append("id\tname\tgroup\t\ttype\tbirthDate\tcommands\n");
        for (Animal animal : commonList) {
            if (animal.getGroup().equals(AnimalGroup.valueOf(group))) {
                count++;
                builder.append(animal);
                builder.append("\n");
            }
        }
        builder.append("Found animals: ");
        builder.append(count);
        builder.append(" of ");
        builder.append(showTotalAmountOfAnimals());
        builder.append("\n________________________________________________________________________\n");
        return builder.toString();
    }

    public String showTotalAmountOfAnimals() {
        return Integer.toString(commonList.getTotalAmount());
    }

    public String getMoreInfo(String animalIDString) {
        try {
            int animalID = transferID(animalIDString);
            StringBuilder builder = new StringBuilder();
            builder.append("\n");
            builder.append("This animal could say ");
            builder.append(commonList.getAnimalOnID(animalID).whatAreYouDoing());
            builder.append(", but it only says ");
            builder.append(commonList.getAnimalOnID(animalID).voice());
            return builder.toString();
        } catch (Exception e) {
            return "There is no animal with this ID";
        }
    }

    private int transferID(String idString) {
        int animalID;
        if (checkChoice(idString)) {
            animalID = Integer.parseInt(idString) - 1;
        } else {
            animalID = -1;
        }
        return animalID;
    }

    private LocalDate transferToDate(String dateString) {
        try {
            String[] dateArr = dateString.split("-");
            int year = 1000;
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
            return LocalDate.of(1000, 1, 1);
        }
    }

    private boolean checkForInt(String string) {
        if (string.matches("[0-9]*")) {
            return true;
        }
        return false;
    }

    private boolean checkChoice(String choiceString) {
        if (choiceString.matches("[0-9]*")) {
            int choice = Integer.parseInt(choiceString);
            return choice >= 1 && choice <= commonList.getTotalAmount();
        }
        return false;
    }
}