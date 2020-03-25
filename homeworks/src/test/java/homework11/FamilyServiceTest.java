package homework11;

import homework9.entity.Family;
import homework9.entity.Human;
import homework9.entity.Man;
import homework9.entity.Woman;
import homework9.entity.pets.Dog;
import homework9.entity.pets.Pet;
import homework9.entity.pets.RoboCat;
import homework9.service.FamilyService;
import homework9.util.RandomComponents;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class FamilyServiceTest {
    FamilyService service;
    List<Man> men;
    List<Woman> women;
    List<Family> families = new ArrayList<>();;
    int numberOfFamilies = 5;
    @BeforeEach
    void init(){
        service = new FamilyService();
        men = Stream.generate(()->RandomComponents.getRandomMan())
                .limit(numberOfFamilies)
                .collect(Collectors.toList());
        women = Stream.generate(()->RandomComponents.getRandomWoman())
                .limit(numberOfFamilies)
                .collect(Collectors.toList());
        for (int i = 0; i < numberOfFamilies; i++) {
            families.add(new Family(women.get(i),men.get(i)));
            service.createNewFamily(men.get(i),women.get(i));
        }
    }
    @Test
    void getAllFamilies() {
        assertEquals(families,service.getAllFamilies(),"GetAllFamilies dont return correct result");
    }

    @Test
    void getFamiliesBiggerThan() {
        //basically each family consist of 2
        service.adoptChild(service.getFamilyById(0),RandomComponents.getRandomHuman());
        service.adoptChild(service.getFamilyById(1),RandomComponents.getRandomHuman());
        service.adoptChild(service.getFamilyById(2),RandomComponents.getRandomHuman());

        assertEquals(3,service.getFamiliesBiggerThan(2).size(),
                "GetFamiliesBiggerThan should return a list of size 3, it doesnt");
    }

    @Test
    void getFamiliesLessThan() {
        service.adoptChild(service.getFamilyById(0),RandomComponents.getRandomHuman());
        service.adoptChild(service.getFamilyById(0),RandomComponents.getRandomHuman());
        assertEquals(numberOfFamilies - 1,service.getFamiliesLessThan(4).size(),
                "getFamiliesLessThan doesn't work when comparing sizes");
    }

    @Test
    void countFamiliesWithMemberNumber() {
        service.adoptChild(service.getFamilyById(0),RandomComponents.getRandomHuman());
        service.adoptChild(service.getFamilyById(0),RandomComponents.getRandomHuman());
        //all families are consist of 2 member except family with 0 index
        assertEquals(1,service.countFamiliesWithMemberNumber(4),
                "CountFamiliesWithMemberNumber doesnt work");
    }

    @Test
    void createNewFamily() {
        service = new FamilyService();
        Man man = RandomComponents.getRandomMan();
        Woman woman = RandomComponents.getRandomWoman();
        service.createNewFamily(woman,man);
        Family family = new Family(woman,man);
        assertEquals(family,service.getAllFamilies().get(0),"Create new family doesn't work properly");
    }

    @Test
    void deleteFamilyByIndex() {
        Family family = service.getAllFamilies().get(0);
        service.deleteFamilyByIndex(0);
        assertNotEquals(family,service.getAllFamilies().get(0),"Family wasn't deleted by index");
    }

    @Test
    void bornAChild() {
        int before = service.getFamilyById(0).getChildren().size();
        service.bornAChild(service.getFamilyById(0),"ManName","WomanName");
        assertEquals(before+1,service.getFamilyById(0).getChildren().size(),"Born a child doesn't add a child");
    }

    @Test
    void adoptChild() {
        int before = service.getFamilyById(0).getChildren().size();
        Human child = RandomComponents.getRandomHuman();
        service.adoptChild(service.getFamilyById(0),child);
        assertTrue(service.getFamilyById(0).getChildren().contains(child),"Adoption doesn't work");

    }

    @Test
    void deleteAllChildrenOlderThan() {
        String before = service.getAllFamilies().toString();
        //adding to 2 families people as a child over 10. before this operation there is no child in any family
        service.adoptChild(service.getFamilyById(0),RandomComponents.getRandomHuman());
        service.adoptChild(service.getFamilyById(1),RandomComponents.getRandomHuman());

        service.deleteAllChildrenOlderThan(10);
        String after = service.getAllFamilies().toString();
        assertEquals(before,after,"Delete All children doesn't work");

    }

    @Test
    void countOfFamilies() {
        assertEquals(numberOfFamilies,service.countOfFamilies(),"Counts dont match");
    }

    @Test
    void getFamilyById() {
        service = new FamilyService();
        Man man = RandomComponents.getRandomMan();
        Woman woman = RandomComponents.getRandomWoman();
        service.createNewFamily(woman,man);
        Family family = new Family(woman,man);
        assertEquals(family,service.getFamilyById(0),"Get family by id doesn't work properly");
    }

    @Test
    void getPets() {
        Pet pet1 = new Dog("Dog");
        RoboCat cat = new RoboCat("Robocat");
        List<Pet> pets = new ArrayList<>();
        pets.add(pet1);
        pets.add(cat);

        service.addPet(0,pet1);
        service.addPet(0,cat);
        assertEquals(pets,service.getFamilyById(0).getPets(),"Get pets don't work");
    }

    @Test
    void addPet() {
        Pet pet1 = new Dog("Dog");
        RoboCat cat = new RoboCat("Robocat");
        List<Pet> pets = new ArrayList<>();
        pets.add(pet1);
        pets.add(cat);

        service.addPet(0,pet1);
        service.addPet(0,cat);
        assertEquals(pets,service.getFamilyById(0).getPets(),"Add pets don't work");

    }
}