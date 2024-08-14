package view.commands;

import view.ConsoleUI;

public class AddAnimal extends Command {

    public AddAnimal(ConsoleUI consoleUI) {
        super("Add new animal", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().addNewAnimal();
    }
}