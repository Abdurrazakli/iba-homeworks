package homework10.entity.pets;

public class Fish extends Pet {
    @Override
    public void respond() {
        System.out.println("Blob,blob,give me water and oxygen!");
    }

    public Fish(String nickname) {
        super(nickname);
        setSpecies(Species.FISH);
    }
}
