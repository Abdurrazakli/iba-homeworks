package homework8;

public class RoboCat extends Pet {
    @Override
    public void respond() {
        System.out.println("Not a robot, not a cat, I am robocat");
    }

    public RoboCat(String nickname) {
        super(nickname);
        setSpecies(Species.ROBOCAT);
    }
}
