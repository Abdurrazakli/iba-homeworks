package homework8;

public class Dog extends Pet {
    @Override
    public void respond() {
        System.out.println("Hav-hav-hav!");
    }

    public Dog(String nickname) {
        super(nickname);
        setSpecies(Species.DOG);
    }
}
