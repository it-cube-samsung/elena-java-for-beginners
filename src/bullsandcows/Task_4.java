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
        System.out.println(secretCode);




    }
}
