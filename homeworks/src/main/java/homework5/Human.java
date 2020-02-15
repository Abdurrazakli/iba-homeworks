package homework5;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Objects;

public class Human {
   private String name;
   private String surname;
   private int year;
   private int age;
   private int iq;
   private Family family;
   /*private Pet pet;
   private Human mother;
   private Human father;*/
   private String[][] schedule;
    @Override
    public String toString(){
        return String.format("Human{name='%s', surname='%s'," +
                        " year=%d, iq=%d, schedule=%s",name,surname,year,iq, getScheduleAsAString());
    }
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

    public int getIq() {
        return iq;
    }

    public void setIq(int iq) {
        this.iq = iq;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    public Human(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }
    public Human(){}

    public Human(String name, String surname, int year, int age, int iq, String[][] schedule) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.age = age;
        this.iq = iq;
        this.schedule = schedule;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return year == human.year;
    }
    public String getScheduleAsAString(){
        StringBuilder sb = new StringBuilder();
        for (String[] x: schedule
             ) {
            for (String s: x
                 ) {
                sb.append(s).append(" ");
            }
            sb.append(",");
        }
        return sb.toString();
    }
    @Override
    public int hashCode() {
        return Objects.hash(year);
    }
    //fixme arrays should be set/get different
    public String[][] getSchedule() {
        String temp[][] = new String[schedule.length][schedule[0].length];
        for (int i = 0; i < schedule.length ; i++) {
            for (int j = 0; j < schedule[i].length; j++) {
                temp[i][j] = schedule[i][j];
            }
        }
        return temp;
    }

    public void setSchedule(String[][] schedule) {
        String temp[][] = new String[schedule.length][schedule[0].length];
        for (int i = 0; i < schedule.length ; i++) {
            for (int j = 0; j < schedule[i].length; j++) {
                temp[i][j] = schedule[i][j];
            }
        }
        this.schedule = temp;
    }

    /* public Pet getPet() {
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
    }*/



    /*
    public void greetPet(){
        System.out.printf("Hello, %s\n",pet.getNickname());
    }
    public void describePet(){
        System.out.printf("I have a %s, he is %d years old, he is %s\n",
                pet.getSpecies(), pet.getAge(),
                pet.isSly() ? "very sly" : "almost not sly");
    }

     */
}
