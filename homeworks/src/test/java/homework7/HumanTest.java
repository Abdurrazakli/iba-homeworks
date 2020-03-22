package homework7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HumanTest {

    @Test
    void testToString() {
        String expected = "Human{name='Rain', surname='Josh', year=1999, iq=99, schedule=SUNDAY task 1 ,MONDAY task 1 ,TUESDAY task 1 ,WEDNESDAY task 1 ,THURSDAY task 1 ,FRIDAY task 1 ,SATURDAY task 1 ,";
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
        assertEquals(expected,man.toString(),"To string not working properly");
    }
    @Test
    void equalsTest(){
        Human man1 = new Human("Rain","Josh",1999,(2020 - 1999),99,
                new String[][]{
                        {DayOfWeek.SUNDAY.name(),"task 1"},
                        {DayOfWeek.MONDAY.name(),"task 1"},
                        {DayOfWeek.TUESDAY.name(),"task 1"},
                        {DayOfWeek.WEDNESDAY.name(),"task 1"},
                        {DayOfWeek.THURSDAY.name(),"task 1"},
                        {DayOfWeek.FRIDAY.name(),"task 1"},
                        {DayOfWeek.SATURDAY.name(),"task 1"},
                });
        Human man2 = new Human("Rain","Josh",1999,(2020 - 1999),99,
                new String[][]{
                        {DayOfWeek.SUNDAY.name(),"task 1"},
                        {DayOfWeek.MONDAY.name(),"task 1"},
                        {DayOfWeek.TUESDAY.name(),"task 1"},
                        {DayOfWeek.WEDNESDAY.name(),"task 1"},
                        {DayOfWeek.THURSDAY.name(),"task 1"},
                        {DayOfWeek.FRIDAY.name(),"task 1"},
                        {DayOfWeek.SATURDAY.name(),"task 1"},
                });
        assertEquals(man1,man2,"Humans are not same");
    }
}