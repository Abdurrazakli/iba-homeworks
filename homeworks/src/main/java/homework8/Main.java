package homework8;

import homework6.DayOfWeek;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Dog dog1 = new Dog("Scooby-doo");
        dog1.respond();
        System.out.printf("Dog: %s",dog1.getSpecies().toString());
        dog1.eat();
        DomesticCat cat1 = new DomesticCat("Tom");
        cat1.respond();
        cat1.eat();
        Map<String, String> schedule = new HashMap<>();
        schedule.put(DayOfWeek.SUNDAY.name(),"task 1");
                schedule.put(DayOfWeek.SUNDAY.name(),"task 1");
                schedule.put(DayOfWeek.MONDAY.name(),"task 1");
                schedule.put(DayOfWeek.TUESDAY.name(),"task 1");
                schedule.put(DayOfWeek.WEDNESDAY.name(),"task 1");
                schedule.put(DayOfWeek.THURSDAY.name(),"task 1");
                schedule.put(DayOfWeek.FRIDAY.name(),"task 1");
                schedule.put(DayOfWeek.SATURDAY.name(),"task 1");
        Man man = new Man("Rain","Josh",1999,(2020 - 1999),99, schedule);
        System.out.println(man.toString());
    }
}
