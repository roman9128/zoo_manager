package view;

import java.util.Scanner;

import presenter.Presenter;

public class ConsoleUI implements View {
    private Scanner scanner;
    private Presenter presenter;
    private boolean work;
    private Menu menu;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
        menu = new Menu(this);
    }

    @Override
    public void start() {
        System.out.println("Let's begin");
        while (work) {
            System.out.println(menu.showMenu());
            String choiceString = scanner.nextLine();
            if (checkChoice(choiceString)) {
                int choice = Integer.parseInt(choiceString);
                menu.makeAction(choice);
            } else
                continue;
        }
    }

    public boolean checkChoice(String choiceString) {
        if (choiceString.matches("[0-9]*")) {
            int choice = Integer.parseInt(choiceString);
            return choice >= 1 && choice <= menu.size();
        }
        return false;
    }

    public void finish() {
        System.out.println("Ciao!");
        work = false;
    }

    public void addNewAnimal() {
        System.out.println("Enter animal's name: ");
        String name = scanner.nextLine();
        System.out.println(
                "What type is this animal?\nEnter one of the following:\ncamel, donkey, horse, cat, dog, hamster");
        String type = scanner.nextLine();
        System.out.println("Do you know the birth date of this animal?");
        System.out.println("Enter 'y' for 'yes' or anything else for 'no'");
        String birthDate;
        String choice = scanner.nextLine();
        if (choice.equals("y")) {
            System.out.println("Enter date as YYYY-MM-DD");
            birthDate = scanner.nextLine();
            presenter.addNewAnimal(name, type, birthDate);
        } else {
            presenter.addNewAnimal(name, type, "1000-01-01");
        }
        getListbyID();
    }

    public void setBirthDate() {
        getListbyID();
        System.out.println("Whose birth date do you want to set?\nEnter ID: ");
        String animalIDString = scanner.nextLine();
        System.out.println("Enter date as YYYY-MM-DD");
        String birthDateString = scanner.nextLine();
        presenter.setBirthDate(animalIDString, birthDateString);
        getListbyID();
    }

    public void addNewCommands() {
        getListbyID();
        System.out.println("Which animal has learned new commands?\nEnter ID: ");
        String animalIDString = scanner.nextLine();
        System.out.println("Enter new commands separated with comma and space (, )");
        String commandsList = scanner.nextLine();
        presenter.teachNewCommands(animalIDString, commandsList);
        getListbyID();
    }

    public void removeAnimal() {
        getListbyID();
        System.out.println("To remove an animal from the list\nEnter ID: ");
        String animalIDString = scanner.nextLine();
        presenter.removeAnimal(animalIDString);
        getListbyID();
    }

    public void getListbyID() {
        presenter.getListbyID();
    }

    public void getListbyBirthDate() {
        presenter.getListbyBirthDate();
    }

    public void filterList() {
        System.out.println("What kind of animals do you want to find?");
        System.out.println("Enter one of the following:");
        System.out.println("pets, pack_animals, camel, donkey, horse, cat, dog, hamster");
        String animalKind = scanner.nextLine();
        presenter.filterList(animalKind);
    }

    public void getAddinionalInfoAboutAnimal() {
        getListbyID();
        System.out.println("If you want to get more information about an animal\nEnter ID: ");
        String animalIDString = scanner.nextLine();
        presenter.getMoreInfo(animalIDString);
    }

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }
}