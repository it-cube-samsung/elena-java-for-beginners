package simpletictactoe;

import java.util.Arrays;
import java.util.Scanner;

public class Task4_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char [][] tikTakArr = new char[3][3];
        String line = "---------";
        String side = "|";
        String space = " ";
        char empty = '_';
        boolean inputCorrect = false;
        int numStep = 0;
        boolean emptyCells = false;
        boolean winsX = false;
        boolean winsO = false;

        for (int i = 0; i < tikTakArr.length; i++) {
            Arrays.fill(tikTakArr[i], '_');
            System.out.println();
        }

        while (!inputCorrect) {
            System.out.println(line);
            for (int i = 0; i < tikTakArr.length; i++) {
                for (int j = 0; j < tikTakArr[i].length; j++) {
                    if (j == 0) {
                        System.out.print(side + space);
                    }
                    System.out.print(tikTakArr[i][j] + space);
                    if (j == 2) {
                        System.out.print(side);
                    }
                }
                System.out.println();
            }
            System.out.println(line);

            System.out.println("Enter the coordinates: ");
            var userX = scanner.next().charAt(0);
            var userY = scanner.next().charAt(0);

            if (userX < '0' || userX > '9' || userY < '0' || userY > '9'){
                System.out.println("You should enter numbers!");
                System.out.println("Enter the coordinates: ");

                userX = scanner.next().charAt(0);
                userY = scanner.next().charAt(0);
            } else if (userX < '1' || userY < '1' || userX > '3' || userY > '3') {
                System.out.println("Coordinates should be from 1 to 3!");
                System.out.println("Enter the coordinates: ");

                userX = scanner.next().charAt(0);
                userY = scanner.next().charAt(0);
            }else if (tikTakArr[Character.getNumericValue(userX) - 1][Character.getNumericValue(userY) - 1] != '_') {

                System.out.println("This cell is occupied! Choose another one!");
                System.out.println("Enter the coordinates: ");

                userX = scanner.next().charAt(0);
                userY = scanner.next().charAt(0);
            }

            if (numStep % 2 == 0) {
                tikTakArr[Character.getNumericValue(userX) - 1][Character.getNumericValue(userY) - 1] = 'x';
            } else {
                tikTakArr[Character.getNumericValue(userX) - 1][Character.getNumericValue(userY) - 1] = 'o';

            }

            for (int i = 0; i < tikTakArr.length; i++) {
                for (char ch : tikTakArr[i]) {
                    if (ch == '_') {
                        emptyCells = true;
                        break;
                    }

                }
                if (tikTakArr[i][0] == 'x' && tikTakArr[i][1] == 'x' && tikTakArr[i][2] == 'x' ||
                        tikTakArr[0][i] == 'x' && tikTakArr[1][i] == 'x' && tikTakArr[2][i] == 'x' ||
                        tikTakArr[0][0] == 'x' && tikTakArr[1][1] == 'x' && tikTakArr[2][2] == 'x' ||
                        tikTakArr[0][2] == 'x' && tikTakArr[1][1] == 'x' && tikTakArr[2][0] == 'x') {
                    winsX = true;
                }
                if (tikTakArr[i][0] == 'o' && tikTakArr[i][1] == 'o' && tikTakArr[i][2] == 'o' ||
                        tikTakArr[0][i] == 'o' && tikTakArr[1][i] == 'o' && tikTakArr[2][i] == 'o' ||
                        tikTakArr[0][0] == 'o' && tikTakArr[1][1] == 'o' && tikTakArr[2][2] == 'o' ||
                        tikTakArr[0][2] == 'o' && tikTakArr[1][1] == 'o' && tikTakArr[2][0] == 'o') {
                    winsO = true;
                }
            }
             if (!winsX && !winsO && !emptyCells){
                 System.out.println(line);
                 for (int i = 0; i < tikTakArr.length; i++) {
                     for (int j = 0; j < tikTakArr[i].length; j++) {
                         if (j == 0) {
                             System.out.print(side + space);
                         }
                         System.out.print(tikTakArr[i][j] + space);
                         if (j == 2) {
                             System.out.print(side);
                         }
                     }
                     System.out.println();
                 }
                 System.out.println(line);
                System.out.println("End");

                 inputCorrect = true;

             } else if (winsX){
                 System.out.println(line);
                 for (int i = 0; i < tikTakArr.length; i++) {
                     for (int j = 0; j < tikTakArr[i].length; j++) {
                         if (j == 0) {
                             System.out.print(side + space);
                         }
                         System.out.print(tikTakArr[i][j] + space);
                         if (j == 2) {
                             System.out.print(side);
                         }
                     }
                     System.out.println();
                 }
                 System.out.println(line);
                System.out.println("X wins");
                 inputCorrect = true;

             } else if (winsO){
                 System.out.println(line);
                 for (int i = 0; i < tikTakArr.length; i++) {
                     for (int j = 0; j < tikTakArr[i].length; j++) {
                         if (j == 0) {
                             System.out.print(side + space);
                         }
                         System.out.print(tikTakArr[i][j] + space);
                         if (j == 2) {
                             System.out.print(side);
                         }
                     }
                     System.out.println();
                 }
                 System.out.println(line);
                System.out.println("Y wins");
                 inputCorrect = true;

             }
             numStep++;
        }
    }
}