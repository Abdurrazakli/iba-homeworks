package homework7;

public class Main {
    public static void main(String[] args) {
        Dog dog1 = new Dog("Scooby-doo");
        dog1.respond();
        System.out.printf("Dog: %s",dog1.getSpecies().toString());
        dog1.eat();
        DomesticCat cat1 = new DomesticCat("Tom");
        cat1.respond();
        cat1.eat();

    }
}
