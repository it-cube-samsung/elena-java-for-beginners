package bullsandcows;

import java.util.Random;
import java.util.Scanner;

public class Task5 {
    static char alfabet []= {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i' ,'j' , 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    static int bulls = 0;
    static int cows = 0;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder secretCode;

        System.out.println("Please, enter the secret code's length:");
        int lengthSecretCode = scan.nextInt();
        System.out.println("Input the number of possible symbols in the code:");
        int possibleSymbols = scan.nextInt();
        secretCode = getSecretCode(lengthSecretCode, possibleSymbols);

        System.out.println("The secret is prepared: " + getCodeInfo(lengthSecretCode, possibleSymbols));

        System.out.println("Okay, let's start a game!");
        scan.nextLine();

        printGame(secretCode);

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

    public static  StringBuilder getSecretCode(int length, int possibleSymbols) {
        StringBuilder str;
        if (possibleSymbols <= 10) {
            str = getNumbersCode(length, possibleSymbols);
        } else {
            str = getNumbersLettersCode(length, possibleSymbols);
        }
        return  str;
    }

    public static StringBuilder getNumbersLettersCode (int length, int possibleSymbols) {
        StringBuilder str = new StringBuilder();
        Random random = new Random();
        while (str.length() < length) {
            int numOrStr = random.nextInt(2);
            if (numOrStr == 0) {
                str.append(getNumbersCode(1, 10));
            } else {
                str.append(getLetterCode(possibleSymbols - 10));
            }

        }

        return str;
    }
    public static StringBuilder getLetterCode (int possibleSymbols) {
        Random random = new Random();
        StringBuilder str = new StringBuilder();

        int index = random.nextInt(possibleSymbols);
        str.append(alfabet[index]);

        return str;
    }

    public static StringBuilder getNumbersCode(int length, int possibleSymbols) {
        StringBuilder str = new StringBuilder();
        Random random = new Random();
        while (str.length() < length) {
            int randomNum = random.nextInt(possibleSymbols);
            str.append(randomNum);
        }
        return str;
    }

    public  static void printGame (StringBuilder secretCode) {
        int turn = 0;
        Scanner scan = new Scanner(System.in);
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
                System.out.println(bulls + " bull(s) and " + cows + " cow(s).");
            } else if (cows > 0) {
                System.out.println(cows + " cow(s).");
            } else if (bulls > 0) {
                System.out.println(bulls + " bull(s).");
            }
        }
        System.out.println("Congratulations! You guessed the secret code.");
    }

    public static String getCodeInfo (int length, int possibleSymbols) {
        String str = new String();
        String stars = "";
        while (stars.length() < length) {
            stars += "*";
        }
        str += stars + " ";

        int num;

        if (possibleSymbols > 9) {
            num = 9;
        } else {
            num = length - 1;
        }

        str = str + "(" + 0 + "-" + num + ")";

        if (possibleSymbols > 10) {
            int index = possibleSymbols - 11;
            str += ", (a-" + alfabet[index] + ")";
        }

        return  str;
    }


}
