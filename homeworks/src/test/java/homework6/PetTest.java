package homework6;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
}