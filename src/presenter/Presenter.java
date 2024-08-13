package presenter;

import model.Service;
import view.View;

public class Presenter {
    private Service service;
    private View view;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public void addNewAnimal(String name, String type) {
        service.addNewAnimal(name, type);
        getListbyID();
    }

    public void showCommands(int animalID) {
        String answer = service.showCommands(animalID);
        view.printAnswer(answer);
    }

    public void teachNewCommands(int animalID, String commandsList) {
        service.teachNewCommands(animalID, commandsList);
    }

    public void getListbyID() {
        String answer = service.getListbyID();
        view.printAnswer(answer);
    }

    public void getListbyBirthDate() {
        String answer = service.getListbyBirthDate();
        view.printAnswer(answer);
    }

    public void filterListbyAnimalType(String type) {
        String answer = service.filterListbyAnimalType(type);
        view.printAnswer(answer);
    }

    public void filterListbyAnimalGroup(String group) {
        String answer = service.filterListbyAnimalGroup(group);
        view.printAnswer(answer);
    }

    public void showTotalAmountOfAnimals() {
        String answer = service.showTotalAmountOfAnimals();
        view.printAnswer(answer);
    }

    public void makeSound(int animalID) {
        String answer = service.animalMakesSound(animalID);
        view.printAnswer(answer);
    }

    public void whatDoYouDo(int animalID) {
        String answer = service.animalDoes(animalID);
        view.printAnswer(answer);
    }
}