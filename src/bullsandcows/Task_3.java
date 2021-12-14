package bullsandcows;

import java.util.Random;
import java.util.Scanner;

public class Task_3 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder secretCode = new StringBuilder();
        int lengthSecretCode = scan.nextInt();
        Random random = new Random();

        if (secretCode.length() > 10) {
            System.out.println("Error: can't generate a secret number " +
                    "with a length of 11 because there aren't enough unique digits.");

        } else {

            while (secretCode.length() < lengthSecretCode) {
                int randomNum = random.nextInt(9);
                if (randomNum == 0 && secretCode.length() == 0) {
                    randomNum++;
                }
                secretCode.append(randomNum);
            }
            System.out.println("The random secret number is " + secretCode);
        }


    }


}
