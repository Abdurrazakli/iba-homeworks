package homework5;

import java.util.ArrayList;
import java.util.Arrays;

public class Family {
    private Human mother;
    private Human father;
    private ArrayList<Human> children;
    private Pet pet;

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }
    //fixme non-primitive types should not be handled this way i think


    public ArrayList<Human> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<Human> children) {
        this.children = children;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Family(Human mother, Human father) {
        this.mother = mother;
        this.father = father;
        children = new ArrayList<Human>();
    }

    public void addChild(Human child){
        children.add(child);
        child.setFamily(this);
    }
    public boolean deleteChild(int index){
        if(index - 1 >= children.size()) return false;
        else{
        children.get(index - 1).setFamily(null);
        children.remove(index - 1);
        }
        return true;
    }
    @Override
    public String toString() {
        return String.format("Family{mother=%s, father=%s, children=%s, pet=%s}",
                mother.toString(), father.toString(), children.toString(), pet.toString());
    }
}
