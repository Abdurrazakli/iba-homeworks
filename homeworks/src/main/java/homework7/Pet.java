package homework7;

import java.util.Arrays;
import java.util.Objects;

public abstract class Pet {
    private Species species;
    private String nickname;
    private int age;
    private int trickLevel;
    private String[] habits;

    public void eat(){
        System.out.println("I am eating!");
    }
    public abstract void respond();
    //todo I dont know what to with fuel
    public void fuel(){
        System.out.println("I need to cover it up");
    }
    public boolean isSly(){
        return trickLevel > 50;
    }

    public Pet(String nickname) {
        this.nickname = nickname;
        setSpecies(Species.UNKNOWN);
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Pet object is removed!");
        super.finalize();
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return species.equals(pet.species);
    }

    @Override
    public int hashCode() {
        return Objects.hash(species);
    }

    @Override
    public String toString() {
        return String.format("%s{nickname='%s', age=%d, trickLevel=%d, habits=%s}",
                species.name(), nickname, age, trickLevel, Arrays.toString(habits));
    }

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getTrickLevel() {
        return trickLevel;
    }

    public void setTrickLevel(int trickLevel) {
        this.trickLevel = trickLevel;
    }

    public String[] getHabits() {
        return habits;
    }

    public void setHabits(String[] habits) {
        this.habits = habits;
    }

}
