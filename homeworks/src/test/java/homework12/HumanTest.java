package homework12;

import homework10.entity.Human;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HumanTest {

    @Test
    void testToString() {
        Map<String,String> manSchedule = new HashMap<>();
        manSchedule.put("Sunday","go to gym");
        manSchedule.put("Monday","go to Club");
        manSchedule.put("Tuesday","read a book");
        manSchedule.put("Wednesday","code smth");
        manSchedule.put("Thursday","just sleep");
        manSchedule.put("Friday","prepare for the party");
        manSchedule.put("Saturday","do whatever should be done");
        String expected = "Human{name='Rain', surname='Josh', birth date=01/01/1970, age=21, iq=99, schedule={Monday=go to Club, Thursday=just sleep, Friday=prepare for the party, Sunday=go to gym, Wednesday=code smth, Tuesday=read a book, Saturday=do whatever should be done}}";
        Human man = new Human("Rain","Josh",1999,(2020 - 1999),99, manSchedule);
        assertEquals(expected,man.toString(),"To string not working properly");
    }
    @Test
    void equalsTest(){
        Map<String,String> manSchedule1 = new HashMap<>();
        manSchedule1.put("Sunday","go to gym");
        manSchedule1.put("Monday","go to Club");
        manSchedule1.put("Tuesday","read a book");
        manSchedule1.put("Wednesday","code smth");
        manSchedule1.put("Thursday","just sleep");
        manSchedule1.put("Friday","prepare for the party");
        manSchedule1.put("Saturday","do whatever should be done");

        Map<String,String> manSchedule2 = new HashMap<>();
        manSchedule2.put("Sunday","go to gym");
        manSchedule2.put("Monday","go to Club");
        manSchedule2.put("Tuesday","read a book");
        manSchedule2.put("Wednesday","code smth");
        manSchedule2.put("Thursday","just sleep");
        manSchedule2.put("Friday","prepare for the party");
        manSchedule2.put("Saturday","do whatever should be done");

        Human man1 = new Human("Rain","Josh",1999,(2020 - 1999),99,manSchedule1);
        Human man2 = new Human("Rain","Josh",1999,(2020 - 1999),99, manSchedule2);
        assertEquals(man1,man2,"Humans are not same");
    }
}