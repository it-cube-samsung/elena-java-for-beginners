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
                chooseCoffee(actionCoffee);
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

    static void chooseCoffee (int num) {
        switch (num) {
            case 1:
                makeCoffee(250, 0, 16);
                hasMoney += 4;
                break;
            case 2:
                makeCoffee(350, 75, 20);
                hasMoney += 7;
                break;
            case 3:
                makeCoffee(200, 100, 12);
                hasMoney += 6;
                break;
            default:
                System.out.println("Unsuitable action, please, try again");
        }

    }
    static  void makeCoffee(int needWater, int needMilk, int needBeans){
        hasWater -= needWater;
        hasMilk -= needMilk;
        hasCoffeeBeans -= needBeans;
        hasDisposableCups--;
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


