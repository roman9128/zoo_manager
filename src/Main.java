import model.Service;
import model.animals.AnimalType;

public class Main {

    public static void main(String[] args) {
        Service service = new Service();
        service.addNewAnimal("Vasia", AnimalType.cat);
        service.setBirthDate(0, "2019-06-06");
        service.teachNewCommands(0, "voice");
        service.addNewAnimal("Dolia", AnimalType.cat);
        service.setBirthDate(1, "2018-07-10");
        System.out.println(service.getListbyID());
        System.out.println(service.showTotalAmountOfAnimals());
    }

}
