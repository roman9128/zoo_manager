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

    public void addNewAnimal(String name, String type) {
        presenter.addNewAnimal(name, type);
    }

    public void showCommands(int animalID) {
        presenter.showCommands(animalID);
    }

    public void teachNewCommands(int animalID, String commandsList) {
        presenter.teachNewCommands(animalID, commandsList);
    }

    public void getListbyID() {
        presenter.getListbyID();
    }

    public void getListbyBirthDate() {
        presenter.getListbyBirthDate();
    }

    public void filterListbyAnimalType(String type) {
        presenter.filterListbyAnimalType(type);
    }

    public void filterListbyAnimalGroup(String group) {
        presenter.filterListbyAnimalType(group);
    }

    public void showTotalAmountOfAnimals() {
        presenter.showTotalAmountOfAnimals();
    }

    public void makeSound(int animalID) {
        presenter.makeSound(animalID);
    }

    public void whatDoYouDo(int animalID) {
        presenter.whatDoYouDo(animalID);
    }

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }
}