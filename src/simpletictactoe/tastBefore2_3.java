package simpletictactoe;

import java.util.Scanner;

class tastBefore2_3 {
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
        boolean emptyCells = false;
        boolean threeInRow = false;
        for (int i = 0; i < tikTakArr.length; i++) {
            for (char ch : tikTakArr[i]) {
                if (ch == '_') {
                    emptyCells = true;
                    break;
                }}
//            for (int j = 0; j < tikTakArr[i].length; j++) {
//                if (tikTakArr[i][j] == '_') {
//                    emptyCells = true;
//                }
//                if(tikTakArr[i][1] == 'x' && ){
//                }
//            }
        }
    }
}

