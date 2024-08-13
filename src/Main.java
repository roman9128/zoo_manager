import model.Service;
import model.animals.enums.AnimalGroup;
import model.animals.enums.AnimalType;

public class Main {

    public static void main(String[] args) {
        Service service = new Service();
        service.addNewAnimal("Vasia", AnimalType.cat);
        service.setBirthDate(0, "2019-06-06");
        service.teachNewCommands(0, "voice");
        service.addNewAnimal("Dolia", AnimalType.cat);
        service.setBirthDate(1, "2018-07-10");
        service.addNewAnimal("Linda", AnimalType.dog);
        service.setBirthDate(2, "2010-05-10");
        service.addNewAnimal("Donkey", AnimalType.donkey);
        service.setBirthDate(3, "2010-05-10");
        System.out.println(service.getListbyID());
        // System.out.println(service.showTotalAmountOfAnimals());
        // System.out.println(service.animalMakesSound(0));
        // System.out.println(service.animalMakesSound(2));
        // System.out.println(service.filterListbyAnimalGroup(AnimalGroup.pack_s));
    }
}