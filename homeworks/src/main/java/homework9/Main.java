package homework9;

import homework6.DayOfWeek;
import homework9.controller.FamilyController;
import homework9.dao.CollectionFamilyDAO;
import homework9.entity.*;
import homework9.entity.pets.Dog;
import homework9.entity.pets.DomesticCat;
import homework9.service.FamilyService;
import homework9.util.RandomComponents;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main1(String[] args) {
        Dog dog1 = new Dog("Scooby-doo");
        dog1.respond();
        System.out.printf("Dog: %s",dog1.getSpecies().toString());
        dog1.eat();
        DomesticCat cat1 = new DomesticCat("Tom");
        cat1.respond();
        cat1.eat();
        Map<String, String> schedule = new HashMap<>();
        schedule.put(DayOfWeek.SUNDAY.name(),"task 1");
                schedule.put(DayOfWeek.SUNDAY.name(),"task 1");
                schedule.put(DayOfWeek.MONDAY.name(),"task 1");
                schedule.put(DayOfWeek.TUESDAY.name(),"task 1");
                schedule.put(DayOfWeek.WEDNESDAY.name(),"task 1");
                schedule.put(DayOfWeek.THURSDAY.name(),"task 1");
                schedule.put(DayOfWeek.FRIDAY.name(),"task 1");
                schedule.put(DayOfWeek.SATURDAY.name(),"task 1");
        Man man = new Man("Rain","Josh",1999,(2020 - 1999),99, schedule);
        System.out.println(man.toString());
        CollectionFamilyDAO dao = new CollectionFamilyDAO();
        dao.getFamilyByIndex(5);
    }

    public static void main2(String[] args) {
        Map<String, String> schedule = new HashMap<>();
        schedule.put(DayOfWeek.SUNDAY.name(),"task 1");
        schedule.put(DayOfWeek.SUNDAY.name(),"task 1");
        schedule.put(DayOfWeek.MONDAY.name(),"task 1");
        schedule.put(DayOfWeek.TUESDAY.name(),"task 1");
        schedule.put(DayOfWeek.WEDNESDAY.name(),"task 1");
        schedule.put(DayOfWeek.THURSDAY.name(),"task 1");
        schedule.put(DayOfWeek.FRIDAY.name(),"task 1");
        schedule.put(DayOfWeek.SATURDAY.name(),"task 1");
        Man man = new Man("Rain","Josh",1999,(2020 - 1999),99, schedule);
        Woman woman = new Woman("Anna","yes");
        FamilyService service = new FamilyService();
        service.createNewFamily(man,woman);
        Family family = service.getAllFamilies().get(0);
      //  List<Boolean> collect = Stream.generate(() -> ((int)(Math.random() * 2)) == 0).limit(20).filter(s->s==true).collect(Collectors.toList());
        //System.out.println(collect.size());
        Human child= ((int)(Math.random() * 2)) == 0 ? new Woman() : new Man();
        service.bornAChild(family,"Adil","Aytac");
        service.getAllFamilies().get(0).getChildren().get(0).setAge(100);
        System.out.println(service.getAllFamilies().get(0).getChildren().get(0).getAge());
        service.deleteAllChildrenOlderThan(15);
        System.out.println(service.getAllFamilies().get(0).getChildren().size());

    }

    public static void main(String[] args) {
        FamilyController controller = new FamilyController();
        //creating 3 families
        for (int i = 0; i < 3 ; i++) {
            controller.createNewFamily(RandomComponents.getRandomMan(),RandomComponents.getRandomWoman());
        }
        //showing families
        controller.displayAllFamilies();
        //child born
        controller.bornAChild(controller.getFamilyById(0),"Alonzo","Resmiyye");
        System.out.printf("\nBorned child: %s\n\n",controller.getFamilyById(0).getChildren().get(0));
        //adding pet
        Dog dog1 = new Dog("Scooby-doo");
        controller.addPet(0,dog1);
        //adopting child
        Human child = RandomComponents.getRandomHuman();
        controller.adoptChild(controller.getFamilyById(0),child);
        controller.displayAllFamilies();

        System.out.printf("Number of families with 4 people: %d\n\n",
                controller.countFamiliesWithMemberNumber(4));
        System.out.printf("Number of families more than 2 people: %d\n\n",
                controller.getFamiliesBiggerThan(2).size());
        System.out.printf("Families less than 4 people: %s\n\n",
                controller.getFamiliesLessThan(4));
        System.out.println("After deleting children over 15");
        controller.deleteAllChildrenOlderThan(15);
        controller.displayAllFamilies();
        System.out.printf("Pets of family 0: %s\n",controller.getPets(0));

    }

}
