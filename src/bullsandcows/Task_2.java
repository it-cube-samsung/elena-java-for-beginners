package bullsandcows;

import java.util.Scanner;

public class Task_2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("The secret code is prepared: ****");
        int bulls = 0;
        int cows = 0;
        String code = "9305";

        System.out.println("Your answer > ");
            String answer = scan.nextLine();
            cows = getCows(code, answer);
            bulls = getBulls(code, answer);

        System.out.print("Grade: ");
        if (bulls == 0 && cows == 0) {
            System.out.print("None.");
        }
        if ( bulls > 0  && cows > 0){
            System.out.print(bulls + " bull(s) and " + cows + " cow(s).");
        } else if (cows > 0) {
            System.out.print(cows + " cow(s).");
        } else if (bulls > 0) {
            System.out.print(bulls + " bull(s).");
        }

        System.out.println(" The secret code is " + code + ".");
    }

    public static int getCows( String code, String answer) {
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
