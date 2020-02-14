package homework4;

public class Main {
    public static void main(String[] args) {
        createSeveralFamilies();
        createMomSonDadPet();
    }
    public static void createSeveralFamilies(){
        //Family number one
        Human grandmaShark = new Human("GrandmaShark","SharkSon",1905);
        Human grandpaShark = new Human();
        Human dadyShark = new Human("DadyShark","SharkSonNew",1975,grandmaShark,grandpaShark);

        //Family number 2
        Human momyShark = new Human("MomyShark","Milano",1980);
        Human babyShark = new Human("BabyShark","SharkSon",2003,
                (2020-2003),89,new Pet("Hen","Yellow Chicken"),
                momyShark,
                dadyShark,
                new String[][]{{"Sunday","go to gym"},
                {"Monday","go to Club"},
                {"Tuesday","read a book"},
                {"Wednesday","code smth"},
                {"Thursday","just sleep"},
                {"Friday","prepare for the party"},
                {"Saturday","do whatever should be done"}});

        System.out.printf("About GrandmaShark: %s %s %d\n",grandmaShark.name,grandmaShark.surname,grandmaShark.year);
        System.out.printf("About GrandpaShark: Nothing\n");
        System.out.printf("About DadyShark: %s %s %d \n",dadyShark.name,dadyShark.surname,dadyShark.year);
        System.out.printf("About MomyShark: %s %s %d\n",momyShark.name,momyShark.surname,momyShark.year);
        System.out.println(babyShark.toString());
    }
    public static void createMomSonDadPet(){
        Pet snake = new Pet("Snake","Lovely",5,98,
                new String[]{"bite","drink","swim"});
        Human dad = new Human("Johny","English",1985);
        Human mom = new Human("Emma","Watson",1992);
        Human child = new Human("Elhovset","English",2009,(2020 - 2009),
                99,snake,mom,dad,
                new String[][]{{"Sunday","go to gym"},
                        {"Monday","go to Club"},
                        {"Tuesday","read a book"},
                        {"Wednesday","code smth"},
                        {"Thursday","just sleep"},
                        {"Friday","prepare for the party"},
                        {"Saturday","do whatever should be done"}});
        //Calling Child's available behaviors
        child.describePet();
        child.greetPet();
        System.out.println(child.toString());
        //calling pet's available behaviors
        snake.eat();
        snake.fuel();
        snake.respond();
        System.out.println(snake.toString());
    }
}
