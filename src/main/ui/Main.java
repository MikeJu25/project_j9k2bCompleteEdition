package ui;


import model.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<String> order = new ArrayList<String>();


    public static void main(String[] args) throws IOException {
        Customer customer = new Customer("", 21);
        customer.load();
        startOrder();
    }

    public static void startOrder() throws IOException {
        Customer customer;
        ArrayList<String> order = new ArrayList<String>();
        Scanner scanner = new Scanner(System.in);
        print();
        String operation = scanner.nextLine();
        customer = new Customer(operation, 0);
        customer.save(operation);
        ArrayList<Customer> customers = new ArrayList<Customer>();
        checkName(customer, customers);
        makeOrderBurger();

    }

    public static void checkName(Customer customer, ArrayList<Customer> customers) {
        customer.extractName(customers);
        if (customers.size() == 0) {
            customer.addCustomerToList(customer);
            System.out.println("First time? Continue to oder with user name: " + customer.getName(customer));
        } else {

            if (customer.names.contains(customer.name)) {
                System.out.println("Continue to oder with user name: " + customer.getName(customer));
            } else {
                customer.addCustomerToList(customer);
                System.out.println("First time? Continue to oder with user name: " + customer.getName(customer));
            }
        }
    }


    public static void makeOrderBeefBurger() {
        Food beefBurger = new BeefBurger();
        String operation = "";
        System.out.println("Do you want some beef burgers?(Yes or No)");
        Scanner scanner = new Scanner(System.in);
        operation = scanner.nextLine();

        if (operation.equals("Yes")) {
            BeefBurger.printOrder();
            System.out.println("Do you want angus beef burgers?(Yes or No)");
            operation = scanner.nextLine();
            if (operation.equals("Yes")) {
                BeefBurger.printOrder1();
            }
        } else {
            makeOrderChickenBurger();
        }

    }

    public static void makeOrderBurger() {
        String operation = "";
        System.out.println("Do you want some burgers?(Yes or No)");
        Scanner scanner = new Scanner(System.in);
        operation = scanner.nextLine();

        if (operation.equals("Yes")) {
            Burger.printOrder();
            makeOrderBeefBurger();
        } else {
            makeOrderSnacks();
        }

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

    public static void print() {
        System.out.println("Welcome! Please input your name here");
    }

    public static void say() {
        System.out.println("You've done! Wait for your meal at front desk");
    }
}