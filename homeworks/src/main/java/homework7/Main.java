package homework7;

import homework6.DayOfWeek;
import homework6.Human;

public class Main {
    public static void main(String[] args) {
        Dog dog1 = new Dog("Scooby-doo");
        dog1.respond();
        System.out.printf("Dog: %s",dog1.getSpecies().toString());
        dog1.eat();
        DomesticCat cat1 = new DomesticCat("Tom");
        cat1.respond();
        cat1.eat();
        Man man = new Man("Rain","Josh",1999,(2020 - 1999),99,
                new String[][]{
                        {homework6.DayOfWeek.SUNDAY.name(),"task 1"},
                        {homework6.DayOfWeek.MONDAY.name(),"task 1"},
                        {homework6.DayOfWeek.TUESDAY.name(),"task 1"},
                        {homework6.DayOfWeek.WEDNESDAY.name(),"task 1"},
                        {homework6.DayOfWeek.THURSDAY.name(),"task 1"},
                        {homework6.DayOfWeek.FRIDAY.name(),"task 1"},
                        {DayOfWeek.SATURDAY.name(),"task 1"},
                });
        System.out.println(man.toString());
    }
}
