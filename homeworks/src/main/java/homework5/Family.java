package homework5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Family {
    private Human mother;
    private Human father;
    private Human[] children;
    private Pet pet;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Family family = (Family) o;
        return mother.equals(family.mother) &&
                father.equals(family.father);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mother, father);
    }

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


    public Human[] getChildren() {
        return children;
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
        mother.setFamily(this);
        father.setFamily(this);
        children = new Human[0];
    }

    public void addChild(Human child){
        Human[] temp = Arrays.copyOf(children,children.length + 1);
        temp[temp.length - 1] = child;
        children = temp;
        child.setFamily(this);
    }
    public boolean deleteChild(int index){
        if(index - 1 >= children.length) return false;
        else{
        children[index - 1].setFamily(null);
        Human[] temp = new Human[children.length - 1];
            for (int i = 0,inx = 0; i < children.length; i++) {
                if(i == index - 1){
                    continue;
                }
                else {
                    temp[inx++] = children[i];
                }
            }
            children = temp;
        }
        return true;
    }
    public int countFamily(){
        int count = children.length;
        if(father.getFamily().equals(this)){
            count++;
        }
        if(mother.getFamily().equals(this)){
            count++;
        }
        return count;
    }
    @Override
    public String toString() {
        String result = String.format("Family{mother=%s, \nfather=%s",
                mother.toString(), father.toString());
        if(children.length > 0){
            result += String.format(", \nchildren=%s",Arrays.toString(children));
        }
        if(pet != null){
            result += String.format(", \npet=%s",pet.toString());
        }
        result += "}";
        return result;
    }
}
