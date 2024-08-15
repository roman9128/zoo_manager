package view.commands;

import view.ConsoleUI;

public class Remove extends Command {

    public Remove(ConsoleUI consoleUI) {
        super("Remove an animal from the list", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().removeAnimal();
    }
}