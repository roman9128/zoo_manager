package view;

import java.util.ArrayList;
import java.util.List;

import view.commands.Command;

public class Menu {
    private List<Command> commands;

    public Menu(ConsoleUI consoleUI) {
        commands = new ArrayList<>();
        commands.add(new AddStudent(consoleUI));
        commands.add(new GetList(consoleUI));
        commands.add(new SortByAge(consoleUI));
        commands.add(new SortByName(consoleUI));
        commands.add(new Exit(consoleUI));
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