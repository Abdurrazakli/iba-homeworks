package homework13.io;

import homework13.controller.FamilyController;
import homework13.entity.Human;
import homework13.entity.Man;
import homework13.entity.Woman;
import homework13.util.RandomComponents;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Manager {
    private Console console;
    private FamilyController familyController;
    public Manager() {
        Scanner sc = new Scanner(System.in);
        console = new ConsoleX(sc);
        familyController = new FamilyController(console);
    }

    public void run(){
        boolean quit = false;
        while (!quit){
            showCommands();
            console.printLn("Please enter the id of command: ");
            String commandId = console.readLn().trim();
            switch (commandId){
                case "1":
                    familyController.loadData();
                    break;
                case "2":
                    familyController.displayAllFamilies();
                    break;
                case "3":
                    showFamilyMoreThan();
                    break;
                case "4":
                    showFamilyLessThan();
                    break;
                case "5":
                    showFamilyWithNumberOfPeoples();
                    break;
                case "6":
                    createNewFamily();
                    break;
                case "7":
                    deleteFamilyByIndex();
                    break;
                case "8":
                    editFamilyByItsIndex();
                    break;
                case "9":
                    removeGrownChildren();
                    break;
                case "10":
                    console.printLn("BYE!");
                    familyController.saveData();
                    quit = true;
                    break;
                default:
                    console.printLn("Please enter a valid id of command!");
                    break;
            }
        }
    }

    private void fillWithTestData() {
        Stream.generate(()-> RandomComponents.getRandomFamily())
                .limit(10)
                .forEach(family -> familyController.createNewFamily(family));
    }

    private void removeGrownChildren() {
        console.printLn("Please enter age to let children free over this age:");
        int age = getNumber();
        familyController.deleteAllChildrenOlderThan(age);
    }

    private void editFamilyByItsIndex() {
            boolean quit = false;
            while (!quit) {
                String message = "1. Give birth to a baby\n" +
                        "2. Adopt a child\n" +
                        "3. Return to main menu";
                console.printLn(message);
                console.printLn("Please enter the operation id:");
                String opId = console.readLn().trim();
                switch (opId) {
                    case "1":
                        giveBirthToBaby();
                        break;
                    case "2":
                        adoptChild();
                        break;
                    case "3":
                        quit = true;
                        break;
                    default:
                        console.printLn("Please enter a valid operation id!");
                    break;
                }
            }
    }

    private void adoptChild() {
        console.printLn("Please enter the family id:");
        int famID = getNumber() - 1;
        console.printLn("Please enter credentials for child");
        List<String> childData = getInformationToCreateNewPerson();
        Human child = new Human(childData.get(0),childData.get(1),childData.get(2),Integer.parseInt(childData.get(3)));
        familyController.adoptChild(familyController.getFamilyById(famID),child);
    }

    private void giveBirthToBaby() {
        int famID;
        String nameBoy;
        String nameGirl;
        console.printLn("Please enter the family id:");
        famID = getNumber() - 1;
        console.printLn("Please enter the name if he is boy: ");
        nameBoy = console.readLn().trim();
        console.printLn("Please enter the name if she is girl: ");
        nameGirl = console.readLn().trim();
        familyController.bornAChild(familyController.getFamilyById(famID),nameBoy,nameGirl);
    }

    private void showFamilyMoreThan() {
        console.printLn("Please enter the number of people:");
        int numberOfPeople = getNumber();
        familyController.getFamiliesBiggerThan(numberOfPeople).forEach(s->console.printLn(s.prettyFormat()));
    }

    private void showFamilyLessThan() {
        console.printLn("Please enter the number of people:");
        int numberOfPeople = getNumber();
        familyController.getFamiliesLessThan(numberOfPeople).forEach(s->console.printLn(s.prettyFormat()));
    }

    private void showFamilyWithNumberOfPeoples() {
        console.printLn("Please enter the number of people:");
        int numberOfPeople = getNumber();
        console.printLn(String.format("There are %d families that consist of %d people.",
                familyController.countFamiliesWithMemberNumber(numberOfPeople),numberOfPeople));
    }

    private void deleteFamilyByIndex() {
        console.printLn("Please enter id of family: ");
        int id = getNumber();
        familyController.deleteFamilyByIndex(id-1);
    }

    private void createNewFamily() {
        console.printLn("Please enter credentials for mother");
        List<String> mData = getInformationToCreateNewPerson();
        console.printLn("Please enter credentials for father");
        List<String> fData = getInformationToCreateNewPerson();
        Man father = new Man(fData.get(0),fData.get(1),fData.get(2),Integer.parseInt(fData.get(3)));
        Woman mother = new Woman(mData.get(0),mData.get(1),mData.get(2),Integer.parseInt(mData.get(3)));
        familyController.createNewFamily(father,mother);
    }

    private List<String> getInformationToCreateNewPerson() {
        ArrayList<String> data = new ArrayList<>();
        console.printLn("name");
        data.add(console.readLn().trim());
        console.printLn("last name");
        data.add(console.readLn().trim());
        console.printLn("birth date(day/month/year example: 01/12/2011");
        data.add(console.readLn().trim());
        console.printLn("iq");
        data.add(Integer.toString(getNumber()));
        return data;
    }

    private void showCommands() {
        String commands = String.format("1. Load previous data\n" +
                "2. Display the entire list of families (displays a list of all families with indexation starting with 1)\n" +
                "3. Display a list of families where the number of people is greater than the specified number\n" +
                "4. Display a list of families where the number of people is less than the specified number\n" +
                "5. Calculate the number of families where the number of members is\n" +
                "6. Create a new family\n" +
                "7. Delete a family by its index in the general list\n" +
                "8. Edit a family by its index in the general list\n" +
                "9. Remove all children over the age of majority (all families remove children over the age of majority - let us assume they have grown up)\n" +
                "10. Exit"
        );
        console.print(commands);
    }

    private int getNumber(){
        try {
            int number = Integer.parseInt(console.readLn().trim());
            return number;
        }
        catch (NumberFormatException e){
            console.printLn("Please enter a number!");
            return getNumber();
        }
    }
}
