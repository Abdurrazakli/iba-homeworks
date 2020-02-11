package homework2;

import java.util.Random;
import java.util.Scanner;

public class Shooting {
    static char[][] BOARD;
    final static char TARGET_SYMBOL = '#';
    final static int SQUARE_SIZE = 5;
    final static char SHOOTED_SYMBOL = '*';
    final static char HITTED_SYMBOL = 'x';
    final static char defaultCharacter = '-';

    public static void main1(String[] args) {
        BOARD = new char[SQUARE_SIZE][SQUARE_SIZE];
        setBOARD();
        generateRandomTarget();
        showStartMessage();
        printBoard();
    }
    public static void main(String[] args) {
        int yCoordinate;
        int xCoordinate;
           while(true){
               BOARD = new char[SQUARE_SIZE][SQUARE_SIZE];
               setBOARD();
               generateRandomTarget();
               showStartMessage();
               boolean endGame = false;
               do {
                   yCoordinate = getCoordinateFromUser("Y") - 1;
                   xCoordinate = getCoordinateFromUser("X") - 1;
                   endGame = isHit(xCoordinate,yCoordinate);
                   if(endGame){
                       showFinalMessage();
                   }
                   printBoard();
               }while(!endGame);
           }
    }
    private static boolean isHit(int x, int y){
        if(BOARD[y][x] != TARGET_SYMBOL ){
            BOARD[y][x] = SHOOTED_SYMBOL;
            return false;
        }else {
            BOARD[y][x] = HITTED_SYMBOL;
            return true;
        }

    }
    private static void showFinalMessage(){
        System.out.println("You have won!");
    }
    private static void showStartMessage(){
        System.out.println("All set. Get ready to rumble!");
    }
    private static void setBOARD(){
        for (int i = 0; i <BOARD.length ; i++) {
            for (int j = 0; j < BOARD[i].length ; j++) {
                BOARD[i][j] = defaultCharacter;
            }
        }
    }
    private static void generateRandomTarget(){
        Random random = new Random();
        int x = random.nextInt(5);
        int y = random.nextInt(5);
        BOARD[y][x] = TARGET_SYMBOL;
    }
    private static int getCoordinateFromUser(String coordinateName) {
        Scanner sc = new Scanner(System.in);
        int coordinate ;
        try {
            System.out.printf("Please enter a %s coordinate to shoot: ",coordinateName);
            coordinate = Integer.parseInt(sc.nextLine().trim());
            if(coordinate < 1 || coordinate > SQUARE_SIZE)
                throw new NumberFormatException("Just entered wrong coordinate!");
            return coordinate;
        } catch (NumberFormatException e) {
            System.out.printf("Please enter a valid %s coordinate to shoot: ",coordinateName);
            return getCoordinateFromUser(coordinateName);
        }
    }
    private static void printBoard(){
        // first heading row
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i <= SQUARE_SIZE;i++){
            stringBuilder.append(String.format(" %d |",i));
        }
        stringBuilder.append("\n");

        for (int y = 0; y <BOARD.length ; y++) {
            for (int x = 0; x < BOARD[y].length; x++) {
                if(x==0){
                    stringBuilder.append(String.format(" %d |",(y+1)));
                }
                stringBuilder.append(String.format(" %c |",
                        BOARD[y][x] == TARGET_SYMBOL ? '-' : BOARD[y][x]));
            }
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder.toString());
    }
}
