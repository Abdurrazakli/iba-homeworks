package homework3;

import java.util.Scanner;

import static java.lang.System.exit;

public class WeekPlanner {
    private static final String EXIT_COMMAND = "exit";
    private static final String[] weekdays = {
            "sunday",
            "monday",
            "tuesday",
            "wednesday",
            "thursday",
            "friday",
            "saturday"
    };
    private static final String[][] SCHEDULE = {
            {"Sunday","go to gym"},
            {"Monday","go to Club"},
            {"Tuesday","read a book"},
            {"Wednesday","code smth"},
            {"Thursday","just sleep"},
            {"Friday","prepare for the party"},
            {"Saturday","do whatever should be done"}
    };

    public static void main(String[] args) {
        while (true) {
            showTaskOfDay(getDay());
        }

    }
    private static void showTaskOfDay(String day){
        day = day.toLowerCase().trim();
        int dayNumber = -1;
        switch (day){
            case "sunday":
                dayNumber = 0;
                break;
            case "monday":
                dayNumber = 1;
                break;
            case "tuesday":
                dayNumber = 2;
                break;
            case "wednesday":
                dayNumber = 3;
                break;
            case "thursday":
                dayNumber = 4;
                break;
            case "friday":
                dayNumber = 5;
                break;
            case "saturday":
                dayNumber = 6;
                break;
            default:
                System.out.println("Illegal day passed to setSchedule()!");
                break;
        }
        if(dayNumber >= 0 && dayNumber < SCHEDULE.length){
            System.out.printf("Your tasks for %s %s\n",SCHEDULE[dayNumber][0]
                    ,SCHEDULE[dayNumber][1]);
        }
    }
    private static String getDay(){
        Scanner sc = new Scanner(System.in);
        String input;
        System.out.print("Please, input the day of the week: ");
        input = sc.nextLine().trim().toLowerCase();
        if(input.equals(EXIT_COMMAND)){
            exit(0);
        }else if(!isValidDay(input)){
            return getDay();
        }
        return input;
    }
    private static boolean isValidDay(String input){
        for (int i = 0; i < SCHEDULE.length; i++) {
            if(input.equalsIgnoreCase(SCHEDULE[i][0])){
                return true;
            }
        }
        System.out.println("Sorry, I don't understand you, please try again.");
        return false;
    }
    private void setSchedule(String day,String task){
        day = day.toLowerCase().trim();
        task = task.toLowerCase().trim();
        int dayNumber = -1;
        switch (day){
            case "sunday":
                dayNumber = 0;
                break;
            case "monday":
                dayNumber = 1;
                break;
            case "tuesday":
                dayNumber = 2;
                break;
            case "wednesday":
                dayNumber = 3;
                break;
            case "thursday":
                dayNumber = 4;
                break;
            case "friday":
                dayNumber = 5;
                break;
            case "saturday":
                dayNumber = 6;
                break;
            default:
                System.out.println("Illegal day passed to setSchedule()!");
                break;
        }
        if(dayNumber >= 0 && dayNumber < SCHEDULE.length){
            SCHEDULE[dayNumber][0] = weekdays[dayNumber];
            SCHEDULE[dayNumber][1] = task.toLowerCase();
        }
    }
}
