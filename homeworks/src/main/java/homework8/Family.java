package homework8;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Family {
    private Woman mother;
    private Man father;
    private List<Human> children;
    private Set<Pet> pet;


    public Woman getMother() {
        return mother;
    }

    public void setMother(Woman mother) {
        this.mother = mother;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Man father) {
        this.father = father;
    }

    public Set<Pet> getPet() {
        return pet;
    }

    public void setPet(Set<Pet> pet) {
        this.pet = pet;
    }

    public Family(Woman mother, Man father) {
        this.mother = mother;
        this.father = father;
        mother.setFamily(this);
        father.setFamily(this);
        children = new ArrayList<Human>();
    }

    public void addChild(Human child){
        children.add(child);
        child.setFamily(this);
    }

    public List<Human> getChildren() {
        return children;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }

    public boolean deleteChild(int index){
        if(index - 1 >= children.size()) return false;
        else{
        children.get(index - 1).setFamily(null);
        children.remove(index - 1);
        }
        return true;
    }
    public boolean deleteChild(Human child){
        return children.remove(child);
    }
    public int countFamily(){
        int count = children.size();
        if(father.getFamily().equals(this)){
            count++;
        }
        if(mother.getFamily().equals(this)){
            count++;
        }
        return count;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Family object is removed!");
        super.finalize();
    }
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
    @Override
    public String toString() {
        String result = String.format("Family{mother=%s, father=%s",
                mother.toString(), father.toString());
        if(children.size() > 0){
            result += String.format(", children=%s",children.toString());
        }
        if(pet != null){
            result += String.format(", pet=%s",pet.toString());
        }
        result += "}";
        return result;
    }

}
