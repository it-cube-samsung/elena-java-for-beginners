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
            Arrays.fill(tikTakArr[i], empty);
        }
        do{
            System.out.println(line);
            for (int i = 0; i < tikTakArr.length; i++) {
                System.out.print(side + space);
                for (int j = 0; j < tikTakArr[i].length; j++) {
                    System.out.print(tikTakArr[i][j] + space);
                }
                System.out.println(side);
            }
            System.out.println(line);

            System.out.println("Enter the coordinates: ");
            var userX = scanner.next().charAt(0);
            var userY = scanner.next().charAt(0);
                if (userX < '0' || userX > '9' || userY < '0' || userY > '9'){
                    System.out.println("You should enter numbers!");
                    continue;
                } else if (userX < '1' || userY < '1' || userX > '3' || userY > '3') {
                    System.out.println("Coordinates should be from 1 to 3!");
                    continue;
                }else if (tikTakArr[Character.getNumericValue(userX) - 1][Character.getNumericValue(userY) - 1] != '_') {
                    System.out.println("This cell is occupied! Choose another one!");
                    continue;
                }
            int indexX = Character.getNumericValue(userX) - 1;
            int indexY = Character.getNumericValue(userY) - 1;
            char player = (numStep % 2 == 0) ? 'x' : 'o';
            tikTakArr[indexX][indexY] = player;

            for (int i = 0; i < tikTakArr.length; i++) {
                if (tikTakArr[i][0] == player && tikTakArr[i][1] == player && tikTakArr[i][2] == player ||
                        tikTakArr[0][i] == player && tikTakArr[1][i] == player && tikTakArr[2][i] == player ||
                        tikTakArr[0][0] == player && tikTakArr[1][1] == player && tikTakArr[2][2] == player ||
                        tikTakArr[0][2] == player && tikTakArr[1][1] == player && tikTakArr[2][0] == player) {
                    if(player == 'x'){
                        winsX = true;
                    } else {
                        winsO = true;
                    }

                }
            }
            numStep++;
            if (!winsX && !winsO && numStep == 9){
                System.out.println("End");
                inputCorrect = true;
            } else if (winsX){
                System.out.println("X wins");
                inputCorrect = true;

            } else if (winsO){
                System.out.println("O wins");
                inputCorrect = true;
            }


        } while(!inputCorrect);

        System.out.println(line);
        for (int i = 0; i < tikTakArr.length; i++) {
            System.out.print(side + space);
            for (int j = 0; j < tikTakArr[i].length; j++) {
                System.out.print(tikTakArr[i][j] + space);
            }
            System.out.println(side);
        }
        System.out.println(line);
    }
}
