package bullsandcows;

import java.util.Scanner;

public class Task_1 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("The secret code is prepared: ****");
//        String code = scan.nextLine();
        System.out.print(" ");
        int bulls = 0;
        int cows = 0;
        String code = "9846";
        String answer = scan.nextLine();
        cows = getCows(code, answer);
        bulls = getBulls(code, answer);

        System.out.println("you are have" + cows);
    }

    public static int getCows( String code, String answer) {
        int cow = 0;
        for (int i = 0; i < answer.length() ; i++) {
            for (int j = 0; j <= i; j++) {
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
