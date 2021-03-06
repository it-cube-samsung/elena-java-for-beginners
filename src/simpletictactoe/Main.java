package simpletictactoe;

import java.util.Scanner;
// РАБОТАЕТ С y x -
class Main {
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

        System.out.println("Enter the coordinates: ");
        int userX = scanner.nextInt();
        int userY = scanner.nextInt();
        if (tikTakArr[userX - 1][userY - 1] == '_'){
            tikTakArr[userX - 1][userY - 1] = 'x';
        } else if(userX < 1 || userY < 1 || userY > 3 || userY > 3){
            System.out.println("You should enter numbers!");
        }

        System.out.println(line);
        int sumX = 0;
        int sumY = 0;
        boolean emptyCells = false;
        boolean winsX = false;
        boolean winsY = false;
        for (int i = 0; i < tikTakArr.length; i++) {
            for (char ch : tikTakArr[i]) {
                if (ch == '_') {
                    emptyCells = true;
                    break;
                }
                if (ch == 'x') {
                    sumX++;
                }
                if (ch == 'y') {
                    sumY++;
                }
            }

            if (tikTakArr[i][0] == 'x' && tikTakArr[i][1] == 'x' && tikTakArr[i][2] == 'x' ||
                tikTakArr[0][i] == 'x' && tikTakArr[1][i] == 'x' && tikTakArr[2][i] == 'x' ||
                tikTakArr[0][0] == 'x' && tikTakArr[1][1] == 'x' && tikTakArr[2][2] == 'x' ||
                tikTakArr[0][2] == 'x' && tikTakArr[1][1] == 'x' && tikTakArr[2][0] == 'x') {
                winsX = true;
            }
            if (tikTakArr[i][0] == 'y' && tikTakArr[i][1] == 'y' && tikTakArr[i][2] == 'y' ||
                tikTakArr[0][i] == 'y' && tikTakArr[1][i] == 'y' && tikTakArr[2][i] == 'y' ||
                tikTakArr[0][0] == 'y' && tikTakArr[1][1] == 'y' && tikTakArr[2][2] == 'y' ||
                tikTakArr[0][2] == 'y' && tikTakArr[1][1] == 'y' && tikTakArr[2][0] == 'y') {
                winsY = true;
            }
        }
        if (winsX && winsY || sumX - sumY >= 2 || sumY - sumX >= 2 ){
            System.out.println("Impossible");

        } else if(!winsX && !winsY && emptyCells){
            System.out.println("Game not finished");
        }else if (!winsX && !winsY && !emptyCells){
            System.out.println("End");
        } else if (winsX){
            System.out.println("X wins");
        } else if (winsY){
            System.out.println("Y wins");
        }
    }
}

//xy-yx-y-x