package view;

import java.util.ArrayList;
import java.util.List;

import view.commands.AddAnimal;
import view.commands.AddNewCommands;
import view.commands.Command;
import view.commands.FilterList;
import view.commands.GetAdditionalInfo;
import view.commands.GetCommonListByAge;
import view.commands.GetCommonListByID;
import view.commands.Quit;
import view.commands.SetBirthDate;

public class Menu {
    private List<Command> commands;

    public Menu(ConsoleUI consoleUI) {
        commands = new ArrayList<>();
        commands.add(new AddAnimal(consoleUI));
        commands.add(new SetBirthDate(consoleUI));
        commands.add(new AddNewCommands(consoleUI));
        commands.add(new GetCommonListByID(consoleUI));
        commands.add(new GetCommonListByAge(consoleUI));
        commands.add(new FilterList(consoleUI));
        commands.add(new GetAdditionalInfo(consoleUI));
        commands.add(new Quit(consoleUI));
    }

    public String showMenu() {
        StringBuilder builder = new StringBuilder();
        builder.append("Choose action\n");
        for (int i = 0; i < commands.size(); i++) {
            builder.append(i + 1);
            builder.append(" - ");
            builder.append(commands.get(i).getDesc());
            builder.append("\n");
        }
        return builder.toString();
    }

    public void makeAction(int choice) {
        Command command = commands.get(choice - 1);
        command.execute();
    }

    public int size() {
        return commands.size();
    }
}