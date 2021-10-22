package simpletictactoe;

import java.util.Scanner;
// РАБОТАЕТ С o x -
class task2_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char [][] tikTakArr = new char[3][3];
        String line = "---------";
        String side = "|";
        String space = " ";
        char empty = '_';

        System.out.print("Enter cells: ");
        String userGame = scanner.next();
        int num = 0;
        System.out.println(line);
        for (int i = 0; i < tikTakArr.length; i++) {
            for (int j = 0; j < tikTakArr[i].length; j++) {
                if (j == 0) {
                  System.out.print(side + space);
                }
                if(userGame.length() <= num){
                    tikTakArr[i][j] = empty;
                } else {
                    tikTakArr[i][j] = userGame.charAt(num);
                }
                System.out.print(tikTakArr[i][j] + space);
                num++;
                if (j == 2) {
                    System.out.print(side);
                }
            }
            System.out.println();
        }
        System.out.println(line);
        int sumX = 0;
        int sumO = 0;
        boolean emptyCells = false;
        boolean winsX = false;
        boolean winsO = false;
        for (int i = 0; i < tikTakArr.length; i++) {
            for (char ch : tikTakArr[i]) {
                if (ch == '_') {
                    emptyCells = true;
                    break;
                }
                if (ch == 'x') {
                    sumX++;
                }
                if (ch == 'o') {
                    sumO++;
                }
            }

            if (tikTakArr[i][0] == 'x' && tikTakArr[i][1] == 'x' && tikTakArr[i][2] == 'x' ||
                tikTakArr[0][i] == 'x' && tikTakArr[1][i] == 'x' && tikTakArr[2][i] == 'x' ||
                tikTakArr[0][0] == 'x' && tikTakArr[1][1] == 'x' && tikTakArr[2][2] == 'x' ||
                tikTakArr[0][2] == 'x' && tikTakArr[1][1] == 'x' && tikTakArr[2][0] == 'x'){
                winsX = true;
            }
            if (tikTakArr[i][0] == 'o' && tikTakArr[i][1] == 'o' && tikTakArr[i][2] == 'o' ||
                tikTakArr[0][i] == 'o' && tikTakArr[1][i] == 'o' && tikTakArr[2][i] == 'o'||
                tikTakArr[0][0] == 'o' && tikTakArr[1][1] == 'o' && tikTakArr[2][2] == 'o' ||
                tikTakArr[0][2] == 'o' && tikTakArr[1][1] == 'o' && tikTakArr[2][0] == 'o') {
                winsO = true;
            }
        }
        if (winsX && winsO || sumX - sumO >= 2 || sumO - sumX >= 2 ){
            System.out.println("Impossible");

        } else if(!winsX && !winsO && emptyCells){
            System.out.println("Game not finished");
        }else if (!winsX && !winsO && !emptyCells){
            System.out.println("End");
        } else if (winsX){
            System.out.println("X wins");
        } else if (winsO){
            System.out.println("O wins");
        }
    }
}

