package machine;
import java.util.Scanner;



public class CoffeeMachine {

    public static boolean checkAmount(int[] machine, String s) {
        if (s.equals("espresso")) {
            return machine[0] >= 250 && machine[2] >= 16 && machine[3] >= 1;
        }
        else if (s.equals("latte")) {
            return machine[0] >= 350 && machine[1] >= 75 && machine[2] >= 20 && machine[3] >= 1;
        }
        else if (s.equals("cappuccino")) {
            return machine[0] >= 200 && machine[1] >= 100 && machine[2] >= 12 && machine[3] >= 1;
        }
        return false;
    }

    public static void printStatus(int[] machine) {
        System.out.println("The coffee machine has:\n" +
                machine[0] + " ml of water\n" +
                machine[1] + " ml of milk\n" +
                machine[2] + " g of coffee beans\n" +
                machine[3] + " disposable cups\n" +
                "$" + machine[4] + " of money");
    }

    public static void doBuy(int[] machine) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String s = scanner.next();
        int input;
        if (!s.equals("back"))
            input = Integer.parseInt(s);
        else
            return;
        if (input == 1) {
            if (checkAmount(machine, "espresso")) {
                machine[0] -= 250;
                machine[2] -= 16;
                machine[3] -= 1;
                machine[4] += 4;
                System.out.println("I have enough resources, making you a coffee!");
            }
            else {
                if (machine[0] < 250)
                    System.out.println("Sorry, not enough water!");
                else if (machine[2] < 15)
                    System.out.println("Sorry, not enough coffee beans!");
                else if (machine[3] < 1)
                    System.out.println("Sorry, not enough disposable cups!");
            }
        }
        if (input == 2) {
            if (checkAmount(machine, "latte")) {
                machine[0] -= 350;
                machine[1] -= 75;
                machine[2] -= 20;
                machine[3] -= 1;
                machine[4] += 7;
                System.out.println("I have enough resources, making you a coffee!");
            }
            else {
                if (machine[0] < 350)
                    System.out.println("Sorry, not enough water!");
                else if (machine[1] < 75)
                    System.out.println("Sorry, not enough milk!");
                else if (machine[2] < 20)
                    System.out.println("Sorry, not enough coffee beans!");
                else if (machine[3] < 1)
                    System.out.println("Sorry, not enough disposable cups!");
            }
        }
        if (input == 3) {
            if (checkAmount(machine, "cappuccino")) {
                machine[0] -= 200;
                machine[1] -= 100;
                machine[2] -= 12;
                machine[3] -= 1;
                machine[4] += 6;
                System.out.println("I have enough resources, making you a coffee!");
            }
            else {
                if (machine[0] < 200)
                    System.out.println("Sorry, not enough water!");
                else if (machine[1] < 100)
                    System.out.println("Sorry, not enough milk!");
                else if (machine[2] < 12)
                    System.out.println("Sorry, not enough coffee beans!");
                else if (machine[3] < 1)
                    System.out.println("Sorry, not enough disposable cups!");
            }
        }
    }

    public static void doFill(int[] machine) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many ml of water you want to add: ");
        machine[0] += scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add: ");
        machine[1] += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add: ");
        machine[2] += scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee you want to add: ");
        machine[3] += scanner.nextInt();
    }

    public static void doTake(int[] machine) {
        System.out.println("I gave you $" + machine[4]);
        machine[4] = 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] machine = new int[]  {400, 540, 120, 9, 550};
        String action;
        while (true) {
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            action = scanner.nextLine();
            if (action.equals("buy"))
                doBuy(machine);
            if (action.equals("fill"))
                doFill(machine);
            if (action.equals("take"))
                doTake(machine);
            if (action.equals("remaining"))
                printStatus(machine);
            if (action.equals("exit"))
                break;
        }
    }

}
