package homework6;

public class Main {
    public static void main(String[] args) {
        int MAX_LIMIT = 100000000;
        Pet p = new Pet(Species.CAT,"Kitty");
        System.out.println(p.toString());
        Human man = new Human("Rain","Josh",1999,(2020 - 1999),99,
                new String[][]{
                {DayOfWeek.SUNDAY.name(),"task 1"},
                {DayOfWeek.MONDAY.name(),"task 1"},
                {DayOfWeek.TUESDAY.name(),"task 1"},
                {DayOfWeek.WEDNESDAY.name(),"task 1"},
                {DayOfWeek.THURSDAY.name(),"task 1"},
                {DayOfWeek.FRIDAY.name(),"task 1"},
                {DayOfWeek.SATURDAY.name(),"task 1"},
        });

        for (int i = 0; i < MAX_LIMIT; i++) {
            Human k = new Human();
        }
    }
}
