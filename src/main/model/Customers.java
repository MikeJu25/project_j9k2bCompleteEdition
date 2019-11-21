package model;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static ui.MakeOrder.splitOnSpace;


public class Customers {
    private static List<Customer> customers;

    public Customers() {
        customers = new ArrayList<>();
    }

    public static void addCustomerToList(Customer customer) {
        customers.add(customer);
    }

    public int getSize() {
        return customers.size();
    }

//    public Set<Customer> getCustomers() {
//        return customers;
//    }

    public boolean checkIfContains(String customer) {
        //get a set of string of all the names in the customers array, then check if that contains string customer
        return customers.contains(customer);
    }

    public double getCustomerBalance(Customer customer) {
        if (customers.contains(customer)) {
            return customer.getBalance();
        }
        return 0;
    }

    public static ArrayList<String> getAllCustomersName() {
        ArrayList<String> names = new ArrayList<>();
        for (Customer customer : customers) {
            names.add(customer.getName());
        }
        return  names;
    }

    public static Customer getCustomerWithName(String customerName) {
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getName().equals(customerName)) {
                return customers.get(i);
            }
        }
        return null;
    }

    public void load() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("inputfile"));
        if (!(lines.size() == 0)) {
            for (String line : lines) {
                ArrayList<String> partsOfLine = splitOnSpace(line);
                addCustomerToList(new Customer(partsOfLine.get(0), Double.parseDouble(partsOfLine.get(1))));
            }
        }
    }

//    for (int i = 0; i < lines.size(); i++) {
//        ArrayList<String> partsOfLine = splitOnSpace(lines.get(i));
//        addCustomerToList(new Customer(partsOfLine.get(0),Double.parseDouble(partsOfLine.get(1))));
////            if (lines.size() == 0) {
////                break;
////            }

    public void save() throws IOException {
        PrintWriter writer = new PrintWriter("inputfile", "UTF-8");
        for (Customer c : customers) {
            writer.println(c.name + " " + c.getBalance());
        }
        writer.close();

    }

}

