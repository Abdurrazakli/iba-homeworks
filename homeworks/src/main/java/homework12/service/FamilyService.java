package homework12.service;

import homework12.dao.CollectionFamilyDAO;
import homework12.entity.Family;
import homework12.entity.Human;
import homework12.entity.Man;
import homework12.entity.Woman;
import homework12.entity.pets.Pet;
import homework12.exceptions.FamilyOverflowException;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FamilyService {
    private CollectionFamilyDAO familyDAO;

    public FamilyService() {
        this.familyDAO = new CollectionFamilyDAO();
    }
    public List<Family> getAllFamilies(){
        return familyDAO.getAll();
    }
    public void displayAllFamilies(){
        familyDAO.getAll().forEach(f-> System.out.println(f.prettyFormat()));
    }
    public List<Family>getFamiliesBiggerThan(int numberOfPeople){
        return familyDAO.getAll()
                .stream()
                .filter(f->f.countFamily() > numberOfPeople)
                .collect(Collectors.toList());
    }
    public List<Family>getFamiliesLessThan(int numberOfPeople){
        return familyDAO.getAll()
                .stream()
                .filter(f->f.countFamily() < numberOfPeople)
                .collect(Collectors.toList());
    }
    public int countFamiliesWithMemberNumber(int numberOfPeople){
        return familyDAO.getAll()
                .stream()
                .filter(f->f.countFamily() == numberOfPeople)
                .collect(Collectors.toList()).size();
    }
    public boolean createNewFamily(Human parent1, Human parent2){
        Woman mother = parent1 instanceof Woman ? (Woman)parent1 : (Woman)parent2;
        Man father = parent1 instanceof Man ? (Man)parent1 : (Man)parent2;
        Family newFamily = new Family(mother,father);
        return familyDAO.saveFamily(newFamily);
    }
    public boolean createNewFamily(Family newFamily){
        return familyDAO.saveFamily(newFamily);
    }
    public boolean deleteFamilyByIndex(int index){
        return familyDAO.deleteFamily(index);
    }
    public Family bornAChild(Family family, String manName, String womanName) throws FamilyOverflowException {
            if(family.countFamily() > 6){
                throw new FamilyOverflowException("Family overflow: Be wise and stop making baby!");
            }
           Human child= ((int)(Math.random() * 2)) == 0 ? new Woman() : new Man() ;
           String name = child instanceof Woman ? womanName : manName;
           String surname = family.getFather().getSurname();
           int age = 0;
           int iq = (family.getFather().getIq() + family.getMother().getIq()) / 2;
           int year = 2020;
           Map<String,String> schedule = Collections.EMPTY_MAP;

           child.setFamily(family);
           child.setAge(age);
           child.setIq(iq);
           child.setName(name);
           child.setSurname(surname);
           child.setBirthDate(year);
           child.setSchedule(schedule);

           family.getChildren().add(child);
           familyDAO.saveFamily(family);
           return family;
    }
    public Family adoptChild(Family family, Human child){
        child.setFamily(family);
        family.getChildren().add(child);
        familyDAO.saveFamily(family);
        return family;
    }
    public void deleteAllChildrenOlderThan(int age){
        familyDAO.getAll().stream()
                .forEach(f->f.getChildren().removeIf(child->child.getAge() > age));
    }
    public int countOfFamilies(){
        return familyDAO.getAll().size();
    }
    public Family getFamilyById(int index){
        return familyDAO.getFamilyByIndex(index);
    }
    public List<Pet> getPets(int familyIndex){
        return familyDAO.getFamilyByIndex(familyIndex)
                .getPets()
                .stream()
                .collect(Collectors.toList());
    }
    public boolean addPet(int familyIndex, Pet pet){
        Family familyByIndex = familyDAO.getFamilyByIndex(familyIndex);
        familyByIndex.getPets().add(pet);
        return familyDAO.saveFamily(familyByIndex);
    }


}
