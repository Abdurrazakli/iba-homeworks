package homework7;

import homework7.Family;
import homework7.Human;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class FamilyTest {
    Woman mother;
    Man father;
    Human child;
    Family celebrities;
    @BeforeEach
    void init(){
         mother = new Woman("Emma","Watson",1992,(2020-1992),95,
                new String[][]{{"Sunday","go to gym"},
                        {"Monday","go to Club"},
                        {"Tuesday","read a book"},
                        {"Wednesday","code smth"},
                        {"Thursday","just sleep"},
                        {"Friday","prepare for the party"},
                        {"Saturday","do whatever should be done"}});
         father = new Man("Capitan","Amerika",1985,(2020-1985),91,
                new String[][]{{"Sunday","go to gym"},
                        {"Monday","go to Club"},
                        {"Tuesday","go to work"},
                        {"Wednesday","SMM"},
                        {"Thursday","just sleep"},
                        {"Friday","make a barbeque party"},
                        {"Saturday","do whatever should be done"}});
         child = new Man(   "Baby","Joda",2019,(2020-2019),99,
                new String[][]{{"Sunday","make a new caps"},
                        {"Monday","go to Club"},
                        {"Tuesday","go to nearest star"},
                        {"Wednesday","looking with wet eyes"},
                        {"Thursday","just sleep"},
                        {"Friday","help family"},
                        {"Saturday","do whatever should be done"}});
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