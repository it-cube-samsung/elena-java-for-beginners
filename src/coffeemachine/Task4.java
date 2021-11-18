package coffeemachine;

import java.util.Scanner;

public class Task4 {
    static Scanner scanner = new Scanner(System.in);
    static int hasMilk = 540;
    static int hasWater = 400;
    static int hasCoffeeBeans = 120;
    static int hasMoney = 550;
    static int hasDisposableCups = 9;
    public static void main(String[] args) {
        printCoffeeMachineHas();
        actionCheck();
        printCoffeeMachineHas();
    }

    public static void actionCheck() {
        System.out.println("Write action (buy, fill, take): ");
        String action = scanner.next();
        switch (action) {
            case "buy":
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
                int actionCoffee = scanner.nextInt();
                buyCoffee(actionCoffee);
                break;
            case "fill":
                fillMachine();
                break;
            case "take":
                takeMoneyOut();
                break;
            default:
                System.out.println("Unsuitable action, please, try again");
        }
    }
    public static void buyCoffee(int num) {
        int waterForEspresso = 250;
        int coffeeBeansForEspresso = 16;
        int costEspresso = 4;

        int waterForLatte = 350;
        int milkForLatte = 75;
        int coffeeBeansForLatte = 20;
        int costLatte = 7;

        int waterForCappuccino = 200;
        int milkForCappuccino = 100;
        int coffeeBeansForCappuccino = 12;
        int costCuppuccino = 6;

        switch (num) {
            case 1:
                hasWater -= waterForEspresso;
                hasCoffeeBeans -= coffeeBeansForEspresso;
                hasMoney += costEspresso;
                hasDisposableCups--;
                break;
            case 2:
                hasWater -= waterForLatte;
                hasMilk -= milkForLatte;
                hasCoffeeBeans -= coffeeBeansForLatte;
                hasMoney += costLatte;
                hasDisposableCups--;
                break;
            case 3:
                hasWater -= waterForCappuccino;
                hasMilk -= milkForCappuccino;
                hasCoffeeBeans -= coffeeBeansForCappuccino;
                hasMoney += costCuppuccino;
                hasDisposableCups--;
                break;
            default:
                System.out.println("Unsuitable action, please, try again");
        }
    }

    public static void fillMachine() {
        System.out.println("Write how many ml of water you want to add:");
        int numAdd = scanner.nextInt();
        hasWater += numAdd;
        System.out.println("Write how many ml of milk you want to add:");
        numAdd = scanner.nextInt();
        hasMilk += numAdd;
        System.out.println("Write how many grams of coffee beans you want to add:");
        numAdd = scanner.nextInt();
        hasCoffeeBeans += numAdd;
        System.out.println("Write how many disposable cups of coffee you want to add:");
        numAdd = scanner.nextInt();
        hasDisposableCups += numAdd;
    }

    public static void takeMoneyOut() {
        System.out.println("I gave you $" + hasMoney);
        hasMoney = 0;
    }

    public static void printCoffeeMachineHas(){
        System.out.println("The coffee machine has:\n" +
                hasWater +" ml of water\n" +
                hasMilk +" ml of milk\n" +
                hasCoffeeBeans +" g of coffee beans\n" +
                hasDisposableCups +" disposable cups\n" +
                "$" + hasMoney + " of money");
    }
}


