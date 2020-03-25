package homework11.entity;

import java.util.Map;

public final class Woman extends Human {
    @Override
    public void greetPet() {
        System.out.println("Woman greets pet");
    }

    public Woman(String name, String surname) {
        super(name, surname);
    }

    public Woman() {
    }

    public Woman(String name, String surname, int year, int age, int iq, Map<String,String> schedule) {
        super(name, surname, year, age, iq, schedule);
    }
}
