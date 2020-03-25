package homework11.controller;

import homework11.FamilyService;
import homework11.entity.Family;
import homework11.entity.Human;
import homework11.entity.pets.Pet;

import java.util.List;

public class FamilyController {
    private FamilyService service;
    public FamilyController() {
        this.service = new FamilyService();
    }
    public List<Family> getAllFamilies(){
        return service.getAllFamilies();
    }
    public void displayAllFamilies(){
        service.getAllFamilies().forEach(f-> System.out.println(f));
    }
    public List<Family>getFamiliesBiggerThan(int numberOfPeople){
        return service.getFamiliesBiggerThan(numberOfPeople);
    }
    public List<Family>getFamiliesLessThan(int numberOfPeople){
        return service.getFamiliesLessThan(numberOfPeople);
    }
    public int countFamiliesWithMemberNumber(int numberOfPeople){
        return service.countFamiliesWithMemberNumber(numberOfPeople);
    }
    public boolean createNewFamily(Human parent1, Human parent2){
        return service.createNewFamily(parent1,parent2);
    }
    public boolean deleteFamilyByIndex(int index){
        return service.deleteFamilyByIndex(index);
    }
    public Family bornAChild(Family family, String manName, String womanName){
        return service.bornAChild(family,manName,womanName);
    }
    public Family adoptChild(Family family, Human child){
        return service.adoptChild(family,child);
    }
    public void deleteAllChildrenOlderThan(int age){
        service.deleteAllChildrenOlderThan(age);
    }
    public int countOfFamilies(){
        return service.countOfFamilies();
    }
    public Family getFamilyById(int index){
        return service.getFamilyById(index);
    }
    public List<Pet> getPets(int familyIndex){
        return service.getPets(familyIndex);
    }
    public boolean addPet(int familyIndex, Pet pet){
        return service.addPet(familyIndex,pet);
    }

}
