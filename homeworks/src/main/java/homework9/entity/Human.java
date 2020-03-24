package homework9.entity;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;

public class Human {
   private String name;
   private String surname;
   private int year;
   private int age;
   private int iq;
   private Family family;
   private Map<String,String> schedule;

    public Human(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.schedule = Collections.EMPTY_MAP;
    }
    public Human(){}
    public Human(String name, String surname, int year, int age, int iq, Map<String,String> schedule) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.age = age;
        this.iq = iq;
        this.schedule = schedule;
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

    public void setSchedule(Map<String,String> schedule) {
        this.schedule = schedule;
    }
    public Map<String, String> getSchedule() {
        return schedule;
    }
    public void greetPet(){
        System.out.println("Actually,there is not any pet :D");
    }

    @Override
    public String toString() {
        return String.format("Human{name='%s', surname='%s', year=%d, age=%d, iq=%d, schedule=%s}", name, surname, year, age, iq, schedule);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return year == human.year;
    }
    @Override
    public int hashCode() {
        return Objects.hash(year);
    }
}
