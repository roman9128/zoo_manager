package presenter;

import model.Service;
import model.animals.enums.AnimalType;

public class Presenter {
    private Service service;
    // private View view;


    public Presenter(/*View view*/){
        //this.view = view;
        service = new Service();
    }

    public void addNewAnimal(String name, AnimalType type) {
        service.addNewAnimal(name, type);
        service.getListbyID();
    }

    public void showCommands(int animalID) {
        service.showCommands(animalID);
    }

    public void teachNewCommands(int animalID, String commandsList) {
        service.teachNewCommands(animalID, commandsList);
    }

    public void getListbyID() {
        service.getListbyID();
    }

    public void getListbyBirthDate() {
        service.getListbyBirthDate();
    }

    public void filterListbyAnimalType(AnimalType type){
        service.filterListbyAnimalType(type);
    }

    public void makeSound (int animalID){
        service.animalMakesSound(animalID);
    }
}