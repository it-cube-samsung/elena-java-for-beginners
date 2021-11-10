package coffeemachine;

import java.util.Scanner;

public class Task2_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.println("Write how many ml of water the coffee machine has: ");
        int waterHas = scanner.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has:");
        int milkHas = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has: ");
        int coffeeHas = scanner.nextInt();
        System.out.println("Write how many cups of coffee you will need: ");
        int needCups = scanner.nextInt();
        int cupsHas = getNumCups(waterHas, milkHas, coffeeHas);
        if (needCups <= cupsHas) {
            System.out.print("Yes, I can make that amount of coffee");
        }
        if(needCups < cupsHas){
            System.out.println(" (and even " + (cupsHas - needCups) + " more than that)");
        }
        if (needCups > cupsHas) {
            System.out.println("No, I can make only " + needCups + " cup(s) of coffee");
        }



    }

    public static int getNumCups(int waterHas, int milkHas, int coffeeHas) {
        // for one cup:
        int water = 200;
        int milk = 50;
        int coffeeBeans = 15;

        int cupsHas;
        int drugNum;

        cupsHas = waterHas / water;
        drugNum = milkHas / milk;
        if (drugNum < cupsHas){
            cupsHas = drugNum;
        }
        drugNum = coffeeHas / coffeeBeans;
        if (drugNum < cupsHas){
            cupsHas = drugNum;
        }

        return cupsHas;
    }
}
