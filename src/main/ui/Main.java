package ui;
// how can customer choose the amount their food want to be

import exception.TooLongName;
import model.*;
import network.ReadWebPageEx;

import java.io.IOException;
import java.util.*;

public class Main {

    public static ArrayList<String> names = new ArrayList<String>();
//    public static KitchenPedal kitchenPedal = new KitchenPedal();
//    public static Order order = new Order();

    public static void main(String[] args) throws IOException, TooLongName {
       // MakeOrder.load();
        SingletonHolder.getInstance();
        ReadWebPageEx.getWelcomeLetter();
        ReadWebPageEx.getWeather();
        MakeOrder makeOrder = new MakeOrder();
     //   order.addObserver(kitchenPedal);
        new WelcomeUI();
//        try {
//            //new LoginUI();
//            makeOrder.startOrder();
//        } catch (TooLongName tooLongName) {
//            System.out.println("Please input your user name less than 10 characters");
//        } catch (RepeatedName repeatedName) {
//            System.out.println("This name has been used");
//        } catch (SelectionNotValid selectionNotValid) {
//            System.out.println("Selection not valid");
//        } finally {
//            System.out.println("Thank you for ordering with automatic ordering machine!");
//            makeOrder.startOrder();
//        }
    }

/*
    public static void startOrder() throws IOException, TooLongName, RepeatedName {
        Customer customer;
        ArrayList<String> order = new ArrayList<String>();
        input = new Scanner(System.in);
        print();
        String operation = input.nextLine();
        if (checkNameLegal(operation)) {
            customer = new Customer(operation, 0);
            customer.save(operation);
            ArrayList<Customer> customers = new ArrayList<Customer>();
            checkName(customer, customers);
            makeOrderMainMenu();
        }
    }

    public static boolean checkNameLegal(String s) throws TooLongName, RepeatedName {
       // names = new ArrayList<String>();
        if (s.length() > 10) {
            throw new TooLongName();
        } else {
            if (names.contains(s)) {
                throw new RepeatedName();
            }
        }
        return true;
    }

    public static void makeOrderMainMenu() {
        boolean keepGoing = true;
        String command = null;
        // init();
        while (keepGoing) {
            displayMenu();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("b")) {
                makeOrderBurger();
            } else if (command.equals("s")) {
                makeOrderSnacks();
//            else if(command.equals("d"))
//                ();
            } else if (command.equals("q")) {
                keepGoing = false;
            } else {
                System.out.println("Selection not valid...");
            }
        }

        System.out.println("\nThank you for ordering with automatic machine, goodbye!");
    }


    private static void displayMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\tb -> Burger");
        System.out.println("\ts -> Snacks");
        // System.out.println("\td -> Drinks");
        // System.out.println("\tc -> Combo");
        System.out.println("\tq -> quit");
    }

    public static void checkName(Customer customer, ArrayList<Customer> customers) {
        customer.extractName(customers);
        if (customers.size() == 0) {
            customer.addCustomerToList(customer);
            System.out.println("First time? Continue to order with user name: " + customer.getName(customer));
        } else {
            if (customer.names.contains(customer.name)) {
                System.out.println("Continue to order with user name: " + customer.getName(customer));
            } else {
                customer.addCustomerToList(customer);
                System.out.println("First time? Continue to order with user name: " + customer.getName(customer));
            }
        }
    }


    public static void makeOrderBeefBurger() {
        boolean keepGoing = true;
        while (keepGoing) {
            displayBeefBurgerMenu();
            String command = input.next();
            command = command.toLowerCase();
            if (command.equals("a")) {
                angusBeefBurger();
            } else if (command.equals("q")) {
                keepGoing = false;
            } else if (command.equals("r")) {
                makeOrderBurger();
            } else if (command.equals("p")) {
                printOrderMain();
            } else {
                System.out.println("Selection not valid...");
            }
        }
        System.out.println("\nThank you for ordering with automatic machine, goodbye!");
    }

    // Food beefBurger = new BeefBurger();

//        String operation = "";
//        System.out.println("Do you want some beef burgers?(Yes or No)");
//        Scanner scanner = new Scanner(System.in);
//        operation = scanner.nextLine();
//
//        if (operation.equals("Yes")) {
//            BeefBurger.printOrder();
//            System.out.println("Do you want angus beef burgers?(Yes or No)");
//            operation = scanner.nextLine();
//            if (operation.equals("Yes")) {
//                Burger.printOrder1();
//            }
//        } else {
//            makeOrderChickenBurger();
//        }


    public static void angusBeefBurger() {
        boolean keepGoing = true;
        String command = null;
        while (keepGoing) {
            System.out.println("price: $23.99");
            System.out.println("Do you want Angus Beef Burger?( y or n )");
            command = input.next();
            command = command.toLowerCase();
            if (command.equals("y")) {
                System.out.println("you've successfully ordered Angus Beef Burger");
                order.add("Angus Beef Burger");
                makeOrderBeefBurger();
            } else if (command.equals("n")) {
                keepGoing = false;
            } else {
                System.out.println("Selection not valid...");
            }
            makeOrderBeefBurger();
        }
    }

//    BeefBurger beefBurger = new BeefBurger();
//        beefBurger.printName1();
//        beefBurger.printPrice1();
//        beefBurger.printIngredient1();
//        beefBurger.printPopularity1();


    private static void displayBeefBurgerMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\ta -> Angus Beef Burger");
        System.out.println("\tr -> Return");
        System.out.println("\tp -> Ready to pay");
        System.out.println("\tq -> quit");
        // System.out.println("\tq -> quit");
    }


    public static void makeOrderBurger() {
        boolean keepGoing = true;
        while (keepGoing) {
            displayBurgerMenu();
            String command = input.next();
            command = command.toLowerCase();
            if (command.equals("b")) {
                makeOrderBeefBurger();
            } else if (command.equals("q")) {
                keepGoing = false;
            } else if (command.equals("r")) {
                makeOrderMainMenu();
            } else if (command.equals("p")) {
                printOrderMain();
            } else {
                System.out.println("Selection not valid...");
            }
        }
        System.out.println("\nThank you for ordering with automatic machine, goodbye!");
    }
//} else if (command.equals("c")) {
//        makeOrderChickenBurger();


    public static void printOrderMain() {
        for (String str : order) {
            System.out.println("your order is " + str);
        }
    }

    private static void displayBurgerMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\tb -> Beef Burger");
        System.out.println("\tc -> Chicken Burger");
        System.out.println("\tr -> Return");
        System.out.println("\tp -> Ready to pay");
        // System.out.println("\tc -> Combo");
        System.out.println("\tq -> quit");
    }

    public static void makeOrderSnacks() {
        Food chickenStripes = new Snacks();
        String operation = "";
        System.out.println("Do you want a chickenStripes?(Yes or No)");
        chickenStripes.printPrice1();
        chickenStripes.printIngredient1();
        chickenStripes.printPopularity1();
        Scanner scanner = new Scanner(System.in);
        operation = scanner.nextLine();

        if (operation.equals("Yes")) {
            Snacks.printOrder();
            order.add("chickenStripes");
        } else {
            say();
        }

    }

    public static void makeOrderChickenBurger() {
        String operation = "";
        System.out.println("Do you want some chicken burgers?(Yes or No)");
        Scanner scanner = new Scanner(System.in);
        operation = scanner.nextLine();

        if (operation.equals("Yes")) {
            ChickenBurger.printOrder();
            System.out.println("Do you want classical chicken burgers?(Yes or No)");
            operation = scanner.nextLine();
            if (operation.equals("Yes")) {
                ChickenBurger.printOrder1();
            }
        } else {
            makeOrderSnacks();
        }


    }

    public static void load() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("inputfile"));
        PrintWriter writer = new PrintWriter("outputfile", "UTF-8");
//        lines.add("Mike 8.99");
        for (String line : lines) {
            ArrayList<String> partsOfLine = splitOnSpace(line);
            System.out.print("Customer: " + partsOfLine.get(0) + "  ");
            //      System.out.println("Balance: " + partsOfLine.get(1));
            writer.println(line);
        }
        writer.close();
    }

    public static ArrayList<String> splitOnSpace(String line) throws IOException {
        String[] splits = line.split(" ");
        return new ArrayList<>(Arrays.asList(splits));

    }

    public static void save(String s) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("inputfile"));
        PrintWriter writer = new PrintWriter("outputfile", "UTF-8");
        lines.add(s);
        for (String line : lines) {
            ArrayList<String> partsOfLine = splitOnSpace(line);
            System.out.print("Customer: " + partsOfLine.get(0) + "  ");
            //    System.out.println("Balance: " + partsOfLine.get(1));
            writer.println(line);
        }
        writer.close();
    }


    public static void print() {
        System.out.println("Welcome! Please input your name here");
    }

    public static void say() {
        System.out.println("You've done! Wait for your meal at front desk");
    }
*/
}