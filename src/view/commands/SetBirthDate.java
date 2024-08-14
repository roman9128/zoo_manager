package view.commands;

import view.ConsoleUI;

public class SetBirthDate extends Command {

    public SetBirthDate(ConsoleUI consoleUI) {
        super("Set the animal's birth date if you haven't done it early", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().setBirthDate();
    }
}