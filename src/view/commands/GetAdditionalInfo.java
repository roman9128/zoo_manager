package view.commands;

import view.ConsoleUI;

public class GetAdditionalInfo extends Command {

    public GetAdditionalInfo(ConsoleUI consoleUI) {
        super("Get some additional information about an animal", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().getAddinionalInfoAboutAnimal();
    }
}