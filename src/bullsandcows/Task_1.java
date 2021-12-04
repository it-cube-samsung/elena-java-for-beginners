package bullsandcows;

import java.util.Scanner;

public class Task_1 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("The secret code is prepared: ****");
        int bulls = 0;
        int cows = 0;
        String code = "9846";

        while (bulls < 4) {
            int turn = 1;
            System.out.println("Turn " + turn + ". Answer:");
            String answer = scan.nextLine();
            cows = getCows(code, answer);
            bulls = getBulls(code, answer);

//            if (cows > 0 && bulls > 0) {
//                System.out.println("Grade: " + bulls + " bull and " + cows + " cow.");
//            } else  if (bulls > 0 && cows == 0) {
//                System.out.println("Grade: " + bulls + " bull.");
//            }/* else  if (cows > 0 && bulls == 0) {
//                System.out.println("Grade: " + bulls + " bull.");
//            } */else if (cows == 0 ) {
//                System.out.println("Grade: " + cows + " cow.");
//            } else  if (bulls == 0) {
//                System.out.println("Grade: " + bulls + " bull.");
//            } else {
//                System.out.println("Grade: None.");
//            }
                System.out.println("Grade: " + bulls + " bull and " + cows + " cow.");

            turn++;
        }
        System.out.println("Congrats! The secret code is " + code + ".");



    }

    public static int getCows( String code, String answer) {
        int cow = 0;
        for (int i = 0; i <- answer.length() ; i++) {
            for (int j = 0; j <= i; j++) {
                if (code.charAt(j) == answer.charAt(i) && code.charAt(j) != answer.charAt(j)){
                    cow++;
                }
            }
        }
        return cow;
    }

    public  static int getBulls(String code, String answer) {
        int bulls = 0;
        for (int i = 0; i < answer.length(); i++) {
            if (code.charAt(i) == answer.charAt(i)) {
                bulls++;
            }
        }

        return bulls;
    }
}
