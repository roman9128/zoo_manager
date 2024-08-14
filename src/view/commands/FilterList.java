package view.commands;

import view.ConsoleUI;

public class FilterList extends Command {

    public FilterList(ConsoleUI consoleUI) {
        super("Find animals of specified kind", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().filterList();
    }
}