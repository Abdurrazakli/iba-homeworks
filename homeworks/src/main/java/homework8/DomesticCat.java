package homework8;

public class DomesticCat extends Pet {
    @Override
    public void respond() {
        System.out.println("Miyau. I need attention");
    }

    public DomesticCat(String nickname) {
        super(nickname);
        setSpecies(Species.DOMESTICCAT);
    }
}
