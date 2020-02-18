package homework7;

public final class Woman extends Human {
    @Override
    public void greetPet() {
        System.out.println("Woman greets pet");
    }

    public Woman(String name, String surname) {
        super(name, surname);
    }

    public Woman() {
    }

    public Woman(String name, String surname, int year, int age, int iq, String[][] schedule) {
        super(name, surname, year, age, iq, schedule);
    }
}
