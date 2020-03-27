package homework12;

import homework12.entity.Family;
import homework12.entity.Human;
import homework12.io.Manager;
import homework12.util.RandomComponents;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main1(String[] args) {
        Human adoptedChild = new Human("Adolf","Rudolino","15/03/1990",75);
        System.out.println(RandomComponents.getRandomFamily());
        Family randomFamily = RandomComponents.getRandomFamily();
        randomFamily.addChild(adoptedChild);
        randomFamily.addChild(adoptedChild);
        randomFamily.setPets(Stream.generate(()->RandomComponents.getRandomPet()).limit(3).collect(Collectors.toList()));
        System.out.println(randomFamily.prettyFormat());
    }

    public static void main(String[] args) {
        Manager manager = new Manager();
        manager.run();
    }
}
