package homework7;

import homework6.Pet;
import homework6.Species;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PetTest {
    @DisplayName("Pet's to string:")
    @Test
    void testToString() {
        Species specy = Species.DOG;
        String nickname = "Tom";
        int age = 15;
        int trickLevel = 99;
        String[] habits = {"eating","running"};
        String expected = "DOG{nickname='Tom', age=15, trickLevel=99, habits=[eating, running]}";
        Pet cat = new Pet(specy,nickname);
        cat.setAge(age);
        cat.setHabits(habits);
        cat.setTrickLevel(trickLevel);
        assertEquals(expected,cat.toString());
    }
    @Test
    void equalsTestIfTwoObjectsSameReturnTrue(){
        Pet cat = new Pet(Species.CAT,"Tom");
        cat.setAge(10);
        cat.setHabits(new String[]{"eat","sleep"});
        cat.setTrickLevel(30);
        Pet cat2 = new Pet(Species.CAT,"Tom");
        cat2.setAge(10);
        cat2.setHabits(new String[]{"eat","sleep"});
        cat2.setTrickLevel(30);
        assertEquals(cat,cat2,"Cats are not same");
    }
}