package homework4;

public class Human {
   private String name;
   private String surname;
   private int year;
   private int age;
   private Pet pet;
   private Human mother;
   private Human father;
   private String[][] schedule = {
           {"Sunday","go to gym"},
           {"Monday","go to Club"},
           {"Tuesday","read a book"},
           {"Wednesday","code smth"},
           {"Thursday","just sleep"},
           {"Friday","prepare for the party"},
           {"Saturday","do whatever should be done"}
   };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
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

    //fixme arrays should be set/get different
    public String[][] getSchedule() {
        return schedule;
    }

    public void setSchedule(String[][] schedule) {
        this.schedule = schedule;
    }

    public void greetPet(){
        System.out.printf("Hello, %s\n",pet.getNickname());
    }
    public void describePet(){
        System.out.printf("I have a %s, he is %d years old, he is %s\n",
                pet.getSpecies(), pet.getAge(),
                pet.isSly() ? "very sly" : "almost not sly");
    }
}
