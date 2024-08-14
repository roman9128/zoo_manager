package view.commands;

import view.ConsoleUI;

public class Quit extends Command {

    public Quit(ConsoleUI consoleUI) {
        super("Quit", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().finish();
    }
}