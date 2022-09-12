package machine;

import java.util.Scanner;

public class CoffeeMachine {
    private static Scanner scanner = new Scanner(System.in);
    private static int currentWater = 400;
    private static int currentMilk = 540;
    private static int currentBeans = 120;
    private static int currentCups = 9;
    private static int currentMoney = 550;

    public static void main(String[] args) {
        String action = "";
        while (!action.equals("exit")) {
            System.out.println("\nWrite action (buy, fill, take, remaining, exit):");
            action = scanner.nextLine();

            if (action.equals("buy"))
                buy();
            if (action.equals("fill"))
                fill();
            if (action.equals("take"))
                take();
            if (action.equals("remaining"))
                showCurrents();
        }
    }

    private static void take() {
        System.out.println("I gave you $" + currentMoney);
        currentMoney = 0;
    }

    private static void fill() {
        System.out.println("Write how many ml of water you want to add:");
        currentWater += scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        currentMilk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        currentBeans += scanner.nextInt();
        System.out.println("Write how many disposable cups you want to add:");
        currentCups += scanner.nextInt();
    }

    private static void showCurrents() {
        System.out.println("The coffee machine has:\n" +
                currentWater + " ml of water\n" +
                currentMilk + " ml of milk\n" +
                currentBeans + " g of coffee beans\n" +
                currentCups + " disposable cups\n" +
                "$"+ currentMoney + " of money");
    }

    private static void buy() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String input = scanner.nextLine();
        if (input.equals("back"))
            return;
        int coffeeType = Integer.parseInt(input);
        
        switch (coffeeType) {
            case 1:
                if (currentWater >= 250 && currentBeans >= 16 && currentCups >= 1) {
                    System.out.println("I have enough resources, making you a coffee!");
                    currentWater -= 250;
                    currentBeans -= 16;
                    currentCups--;
                    currentMoney += 4;
                } else
                    System.out.println("Sorry");
                break;
            case 2:
                if (currentWater >= 350 && currentMilk >= 75 && currentBeans >= 20 && currentCups >= 1) {
                    System.out.println("I have enough resources, making you a coffee!");
                    currentWater -= 350;
                    currentMilk -= 75;
                    currentBeans -= 20;
                    currentCups--;
                    currentMoney += 7;
                } else
                    System.out.println("Sorry");
                break;
            case 3:
                if (currentWater >= 200 && currentMilk >= 100 && currentBeans >= 12 && currentCups >= 1) {
                    System.out.println("I have enough resources, making you a coffee!");
                    currentWater -= 200;
                    currentMilk -= 100;
                    currentBeans -= 12;
                    currentCups--;
                    currentMoney += 6;
                } else
                    System.out.println("Sorry");
                break;
        }
    }
}
