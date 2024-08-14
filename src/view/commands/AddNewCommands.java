package view.commands;

import view.ConsoleUI;

public class AddNewCommands extends Command {
    
    public AddNewCommands(ConsoleUI consoleUI) {
        super("Add new commands an animal learned", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().addNewCommands();
    }
}