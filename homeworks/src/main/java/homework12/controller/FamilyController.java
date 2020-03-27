package homework12.controller;

import homework12.exceptions.FamilyOverflowException;
import homework12.io.Console;
import homework12.service.FamilyService;
import homework12.entity.Family;
import homework12.entity.Human;
import homework12.entity.pets.Pet;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class FamilyController {
    private Console console;
    private FamilyService service;

    public FamilyController(Console console) {
        this.service = new FamilyService();
        this.console = console;
    }

    public List<Family> getAllFamilies(){
        return service.getAllFamilies();
    }
    public void displayAllFamilies(){
        AtomicInteger index = new AtomicInteger(1);
        service.getAllFamilies().forEach(f->
                console.printLn(String.format("%d. %s",
                        index.getAndIncrement(),f.prettyFormat())));
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
    public boolean createNewFamily(Family newFamily){
        return service.createNewFamily(newFamily);
    }
    public boolean deleteFamilyByIndex(int index){
        return service.deleteFamilyByIndex(index);
    }
    public Family bornAChild(Family family, String manName, String womanName){
        try {
            return service.bornAChild(family,manName,womanName);
        }catch (FamilyOverflowException ex){
            console.printLn(ex.toString());
        }
        return null;
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
