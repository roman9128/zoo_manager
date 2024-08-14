package view.commands;

import view.ConsoleUI;

public class GetCommonListByID extends Command {

    public GetCommonListByID(ConsoleUI consoleUI) {
        super("Show common animal list sorted by their ID", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().getListbyID();
    }
}