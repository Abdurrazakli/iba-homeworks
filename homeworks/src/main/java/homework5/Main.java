package homework5;

public class Main {
    public static void main(String[] args) {
        Human mother = new Human("Emma","Watson",1992,(2020-1992),95,
                new String[][]{{"Sunday","go to gym"},
                        {"Monday","go to Club"},
                        {"Tuesday","read a book"},
                        {"Wednesday","code smth"},
                        {"Thursday","just sleep"},
                        {"Friday","prepare for the party"},
                        {"Saturday","do whatever should be done"}});
        Human father = new Human("Capitan","Amerika",1985,(2020-1985),91,
                new String[][]{{"Sunday","go to gym"},
                        {"Monday","go to Club"},
                        {"Tuesday","go to work"},
                        {"Wednesday","SMM"},
                        {"Thursday","just sleep"},
                        {"Friday","make a barbeque party"},
                        {"Saturday","do whatever should be done"}});
        Human child = new Human("Baby","Joda",2019,(2020-2019),99,
                new String[][]{{"Sunday","make a new caps"},
                        {"Monday","go to Club"},
                        {"Tuesday","go to nearest star"},
                        {"Wednesday","looking with wet eyes"},
                        {"Thursday","just sleep"},
                        {"Friday","help family"},
                        {"Saturday","do whatever should be done"}});
        Family celebrities = new Family(mother,father);
        celebrities.addChild(child);
        System.out.printf("Mom: %s\n",mother.toString());
        System.out.printf("Dad: %s\n",father.toString());
        System.out.printf("Let's see are mom and dad in the same family: %s\n",
                String.valueOf(father.getFamily().equals(mother.getFamily())));
        System.out.printf("Family to string: %s\n",celebrities.toString());
        System.out.printf("%s %s 's family %s\n",child.getName(),child.getSurname(),child.getFamily().toString());

        System.out.printf("Number of members in family before deleting child %d\n",celebrities.countFamily());
        celebrities.deleteChild(1);
        System.out.printf("Number of members in family after deleting child %d\n",celebrities.countFamily());
    }
}
