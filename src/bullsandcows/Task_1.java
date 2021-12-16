package bullsandcows;

import java.util.Scanner;

public class Task_1 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("The secret code is prepared: ****");
        int bulls = 0;
        int cows = 0;
        String code = "9846";
        int turn = 1;
        while (bulls < 4) {

            System.out.println("Turn " + turn + ". Answer:");
            String answer = scan.nextLine();
            cows = getCows(code, answer);
            bulls = getBulls(code, answer);


            System.out.println("Grade: " + bulls + " bull and " + cows + " cow.");

            turn++;
        }
        System.out.println("Congrats! The secret code is " + code + ".");



    }

    public static int getCows( String code, String answer) {
        int cow = 0;
        for (int i = 0; i < answer.length() ; i++) {
            for (int j = 0; j < answer.length(); j++) {
                if (code.charAt(i) == answer.charAt(j) && code.charAt(j) != answer.charAt(j)){
                    cow++;
//                    System.out.println(answer.charAt(j) + "    " + code.charAt(i));
                }
            }




        }
        return cow;
    }
// && code.charAt(j) != answer.charAt(j)
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
