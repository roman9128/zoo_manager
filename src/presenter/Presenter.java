package presenter;

import java.util.Arrays;

import model.Service;
import view.View;

public class Presenter {
    private Service service;
    private View view;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public void addNewAnimal(String name, String type, String birthDateString) {
        service.addNewAnimal(name, type, birthDateString);
    }

    public void setBirthDate(String animalIDString, String birthDateString) {
        service.setBirthDate(animalIDString, birthDateString);
    }

    public void teachNewCommands(String animalIDString, String commandsList) {
        service.teachNewCommands(animalIDString, commandsList);
    }

    public void getListbyID() {
        String answer = service.getListbyID();
        view.printAnswer(answer);
    }

    public void getListbyBirthDate() {
        String answer = service.getListbyBirthDate();
        view.printAnswer(answer);
    }

    public void filterList(String animalKind) {
        String answer;
        String[] animalGroup = new String[] { "pets", "pack_animals" };
        String[] animalType = new String[] { "camel", "donkey", "horse", "cat", "dog", "hamster" };
        if (Arrays.asList(animalGroup).contains(animalKind)) {
            answer = service.filterListbyAnimalGroup(animalKind);
        } else if (Arrays.asList(animalType).contains(animalKind)) {
            answer = service.filterListbyAnimalType(animalKind);
        } else {
            answer = "No such type";
        }
        view.printAnswer(answer);
    }

    public void getMoreInfo(String animalIDString) {
        String answer = service.getMoreInfo(animalIDString);
        view.printAnswer(answer);
    }
}