package homework13.entity;

import java.util.Map;

public final class Man extends Human {
    public Man(String name, String surname) {
        super(name, surname);
    }

    public Man() {
    }

    public Man(String name, String surname, String dateOfBirth, int iq) {
        super(name, surname, dateOfBirth, iq);
    }

    public Man(String name, String surname, int year, int age, int iq, Map<String,String> schedule) {
        super(name, surname, year, age, iq, schedule);
    }
    public void repairCar(){
        System.out.println("It is hard to deal with cars :/");
    }

    @Override
    public void greetPet() {
        System.out.println("Man greets pet");
    }
}
