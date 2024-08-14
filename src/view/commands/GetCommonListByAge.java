package view.commands;

import view.ConsoleUI;

public class GetCommonListByAge extends Command {

    public GetCommonListByAge(ConsoleUI consoleUI) {
        super("Show common animal list sorted by their age", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().getListbyBirthDate();
    }
}