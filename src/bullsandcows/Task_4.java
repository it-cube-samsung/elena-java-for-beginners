package bullsandcows;

import java.util.Random;
import java.util.Scanner;

public class Task_4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder secretCode = new StringBuilder();
        Random random = new Random();
        int bulls = 0;
        int cows = 0;
        int turn = 0;
        System.out.println("Please, enter the secret code's length:");
        int lengthSecretCode = scan.nextInt();

        while (secretCode.length() < lengthSecretCode) {
            int randomNum = random.nextInt(9);

            if (randomNum == 0 && secretCode.length() == 0) {
                randomNum++;
            }
            secretCode.append(randomNum);
        }

        System.out.println("Okay, let's start a game!");

        while (bulls < secretCode.length()) {
            turn++;
            System.out.println("Turn: " + turn);
            System.out.println("> ");

            String answer = scan.nextLine();
            cows = getCows(secretCode, answer);
            bulls = getBulls(secretCode, answer);

            System.out.print("Grade: ");
            if (bulls == 0 && cows == 0) {
                System.out.print("None. ");
            }
            if ( bulls > 0  && cows > 0){
                System.out.print(bulls + " bull(s) and " + cows + " cow(s).");
            } else if (cows > 0) {
                System.out.print(cows + " cow(s).");
            } else if (bulls > 0) {
                System.out.print(bulls + " bull(s).");
            }
            System.out.println(secretCode);

        }



    }

    public static int getCows( StringBuilder code, String answer) {
        int cow = 0;
        for (int i = 0; i < answer.length() ; i++) {
            for (int j = 0; j < answer.length(); j++) {
                if (code.charAt(i) == answer.charAt(j) && code.charAt(j) != answer.charAt(j)){
                    cow++;
                }
            }
        }
        return cow;
    }

    public  static int getBulls(StringBuilder code, String answer) {
        int bulls = 0;
        for (int i = 0; i < answer.length(); i++) {
            if (code.charAt(i) == answer.charAt(i)) {
                bulls++;
            }
        }
        return bulls;
    }
}
