package homework8;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class FamilyTest {
    Woman mother;
    Man father;
    Human child;
    Family celebrities;
    @BeforeEach
    void init(){
        Map<String,String> motherSchedule = new HashMap<>();
        motherSchedule.put("Sunday","go to gym");
        motherSchedule.put("Monday","go to Club");
        motherSchedule.put("Tuesday","read a book");
        motherSchedule.put("Wednesday","code smth");
        motherSchedule.put("Thursday","just sleep");
        motherSchedule.put("Friday","prepare for the party");
        motherSchedule.put("Saturday","do whatever should be done");

        Map<String,String> fatherSchedule = new HashMap<>();
        fatherSchedule.put("Sunday","go to gym");
        fatherSchedule.put("Monday","run");
        fatherSchedule.put("Tuesday","read a book");
        fatherSchedule.put("Wednesday","code smth");
        fatherSchedule.put("Thursday","code step proj");
        fatherSchedule.put("Friday","prepare for the party");
        fatherSchedule.put("Saturday","love");

        Map<String,String> childSchedule = new HashMap<>();
        fatherSchedule.put("Sunday","go to school");
        fatherSchedule.put("Monday","go to playground");
        fatherSchedule.put("Tuesday","read a book");
        fatherSchedule.put("Wednesday","listen to music");
        fatherSchedule.put("Thursday","code step proj");
        fatherSchedule.put("Friday","help mom");
        fatherSchedule.put("Saturday","love");
         mother = new Woman("Emma","Watson",1992,(2020-1992),95,motherSchedule);
         father = new Man("Capitan","Amerika",1985,(2020-1985),91,fatherSchedule);
         child = new Man(   "Baby","Joda",2019,(2020-2019),99,childSchedule);
        celebrities = new Family(mother,father);
    }

    @Test
    void addChildIncreaseTest() {
        int beforeAdd = celebrities.getChildren().size();
        celebrities.addChild(child);
        int afterAdd = celebrities.getChildren().size();
        assertEquals(beforeAdd + 1,afterAdd,"Add child should increase number of children just 1");
    }

    @Test
    void addChildReferenceTest() {
        celebrities.addChild(child);
        Human acceptedChild  = (Human) celebrities.getChildren().get(celebrities.getChildren().size() - 1);
        assertEquals(child,acceptedChild,"Child should be same");
        }
    @Test
    void deleteExistingChildTest() {
        celebrities.addChild(child);
       final int beforeDeleting = celebrities.getChildren().size();
        assertEquals(true,celebrities.deleteChild(child),"Child didn't deleted");
       final int afterDeleting = celebrities.getChildren().size();
        assertNotEquals(beforeDeleting,afterDeleting,"It doesn't delete any child");
    }
    @Test
    void deleteNonExistingChildTest() {
        final int beforeDeleting = celebrities.getChildren().size();
        assertEquals(false,celebrities.deleteChild(child),
                "Trying to delete non-existing child");
        final int afterDeleting = celebrities.getChildren().size();
        assertEquals(beforeDeleting,afterDeleting,
                "It should stay same");

    }
    @Test
    void deleteExistingChildIndexTest() {
        celebrities.addChild(child);
        final int beforeDeleting = celebrities.getChildren().size();
        assertEquals(true,celebrities.deleteChild(1),
                "Child index didn't deleted");
       final int afterDeleting = celebrities.getChildren().size();
        assertNotEquals(beforeDeleting,afterDeleting,
                "It doesn't delete any child index");
    }
    @Test
    void deleteNonExistingChildIndexTest() {

        final int beforeDeleting = celebrities.getChildren().size();
        assertEquals(false,celebrities.deleteChild(5),
                "Trying to delete non existing index");
        final int afterDeleting = celebrities.getChildren().size();
        assertEquals(beforeDeleting,afterDeleting,
                "It should remain same because of non existing index deletion process");
    }
    @Test
    void countFamily() {
        celebrities.addChild(child);
        assertEquals(3,celebrities.countFamily(),
                "Family members were not count in a right way");
    }
    @Test
    void equalsTest(){
        Family testFamily = new Family(mother,father);
        assertEquals(celebrities,testFamily,"Families are not equal");
    }
}