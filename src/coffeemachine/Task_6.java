package coffeemachine;

import java.util.Objects;
import java.util.Scanner;

public class Task_6 {
    static Scanner scanner = new Scanner(System.in);
    static boolean exit = false;

    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine();

        while (true) {
            if (coffeeMachine.status == Status.DEFAULT) {
                System.out.println("Write action (buy, fill, take, remaining, exit): ");
            }
            String command = scanner.nextLine();

            if ("exit".equals(command)) {
                break;
            }

            coffeeMachine.start(command);
        }
    }


//        public static void actionCheck() {
//            System.out.println("Write action (buy, fill, take, remaining, exit): ");
//            String action = scanner.next();
//            switch (action) {
//                case "buy": {
//                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back:");
//                    String actionCoffee = scanner.next();
//                    if (actionCoffee == "back") {
//                        break;
//                    } else {
//                        CoffeeMachine.chooseCoffee(actionCoffee);
//                    }
//                    break;
//                }
//                case "fill": fillMachine();
//                    break;
//                case "take": CoffeeMachine.takeMoneyOut();
//                    break;
//                case "exit":  System.exit(0);
//                    break;
//                case "remaining":  CoffeeMachine.printCoffeeMachineHas();
//                    break;
//                default:
//                    break;
//
//            }
//        }

    public void fillMachine() {
        System.out.println("Write how many ml of water you want to add:");
        int numAdd = scanner.nextInt();
//        CoffeeMachine.putWater(numAdd);
        System.out.println("Write how many ml of milk you want to add:");
        numAdd = scanner.nextInt();
//        CoffeeMachine.putMilk(numAdd);

        System.out.println("Write how many grams of coffee beans you want to add:");
        numAdd = scanner.nextInt();
//        CoffeeMachine.putBeans(numAdd);
        System.out.println("Write how many disposable cups of coffee you want to add:");
        numAdd = scanner.nextInt();
//        CoffeeMachine.putCups(numAdd);
    }


}

enum Status {
    BUY,
    FILL,
    DEFAULT
}

class CoffeeMachine {
    int hasMilk = 540;
    int hasWater = 400;
    int hasCoffeeBeans = 120;
    int hasMoney = 550;
    int hasDisposableCups = 9;

    String state = "default";
    Status status = Status.DEFAULT;

    void start(String command) {
        System.out.println("i have command " + command);
        if (status == Status.BUY) {
            chooseCoffee(command);
        }
        switch (command) {
            case "buy": {
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back:");
                status = Status.BUY;
                //change state
                break;
            }
            case "fill":
                break;
            case "take":
                takeMoneyOut();
                break;
            case "remaining":
                printCoffeeMachineHas();
                break;
            default:
                break;

        }
    }

    void chooseCoffee (String num) {
        switch (num) {
            case "1":
                makeCoffee(250, 0, 16);
                hasMoney += 4;
                state = "default";
                break;
            case "2":
                makeCoffee(350, 75, 20);
                hasMoney += 7;
                state = "default";
                break;
            case "3":
                makeCoffee(200, 100, 12);
                hasMoney += 6;
                state = "default";
                break;
            case "back":
                state = "defaul";
                break;
            default:
                System.out.println("Unsuitable action, please, try again");
        }
    }

    public boolean lackCoffeeResources(int water, int milk, int beans){
        return water > hasWater || milk > hasMilk || beans > hasCoffeeBeans;
    }

    void makeCoffee(int needWater, int needMilk, int needBeans){
        boolean boo = lackCoffeeResources(needWater, needMilk, needBeans);
        if (!boo){
            hasWater -= needWater;
            hasMilk -= needMilk;
            hasCoffeeBeans -= needBeans;
            hasDisposableCups--;
            System.out.println("I have enough resources, making you a coffee!");
        } else {
            System.out.println("I don't have enough resources");
        }

    }

    private void takeMoneyOut() {
        System.out.println("I gave you $" + hasMoney);
        hasMoney = 0;
    }

    private void printCoffeeMachineHas(){
        System.out.println("The coffee machine has:\n" +
                hasWater +" ml of water\n" +
                hasMilk +" ml of milk\n" +
                hasCoffeeBeans +" g of coffee beans\n" +
                hasDisposableCups +" disposable cups\n" +
                "$" + hasMoney + " of money");
    }
    public  void putWater(int num){
        hasWater += num;
    }
    public void putMilk(int num){
        hasMilk += num;
    }
    public void putBeans(int num){
        hasCoffeeBeans += num;
    }
    public void putCups(int num){
        hasDisposableCups += num;
    }
}