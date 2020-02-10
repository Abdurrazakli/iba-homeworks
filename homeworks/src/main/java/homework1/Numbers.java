package homework1;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Numbers {
    public static void main(String[] args) {
        final int MAX_RANDOM_LIMIT = 100;
        int usersGuess;
        int[] allEnteredNumbers = new int[0];
        while(true){
            //initializing before each game
            allEnteredNumbers = new int[0];
            final String NAME = invite();
            final int RANDOM_NUMBER = generateRandomNumber(MAX_RANDOM_LIMIT);
            showStartMessage();
            boolean endGame = false;

            //round starts
            while(endGame==false){
                usersGuess = getUsersGuess();
                allEnteredNumbers = addNumber(allEnteredNumbers,usersGuess);

                if(usersGuess < RANDOM_NUMBER){
                    System.out.println("Your number is too small. Please, try again..");
                }else if (usersGuess > RANDOM_NUMBER){
                    System.out.println("Your number is too big. Please, try again.");
                }else {
                    endGame = true;
                    System.out.printf("Congratulations, %s!\n",NAME);
                    showAllNumbers(allEnteredNumbers);
                }
            }
        }
    }

    private static void showAllNumbers(int[] allEnteredNumbers) {
        Arrays.sort(allEnteredNumbers);
        System.out.print("Your numbers: ");
        for (int i = allEnteredNumbers.length - 1; i >= 0; i--) {
            System.out.printf("%d ",allEnteredNumbers[i]);
        }
        System.out.println();
    }

    private static int[] addNumber(int[] allEnteredNumbers, int usersGuess) {
        int[] temp = Arrays.copyOf(allEnteredNumbers,allEnteredNumbers.length + 1);
        temp[temp.length - 1] = usersGuess;
        return temp;
    }

    private static int getUsersGuess() {
        Scanner sc = new Scanner(System.in);
        int number ;
        try {
            System.out.print("Please enter a number: ");
            number = Integer.parseInt(sc.nextLine().trim());
            return number;
        } catch (NumberFormatException e) {
            System.out.println("Enter the number again!");
            return getUsersGuess();
        }
    }

    private static void showStartMessage() {
        System.out.println("Let the game begin!");
    }

    private static int generateRandomNumber(int max_random_limit) {
        Random random = new Random();
        return random.nextInt(max_random_limit + 1);
    }

    private static String invite() {
        Scanner sc = new Scanner(System.in);
        String name;
        System.out.print("Please enter your name: ");
        name = sc.nextLine().trim();
        if (name.isEmpty()) {
            return invite();
        }
        return name;
    }


}
