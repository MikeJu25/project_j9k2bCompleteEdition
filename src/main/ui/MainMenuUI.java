package ui;

import model.AngusBeefBurger;
import model.Food;
import model.GoldVip;
import model.SilverVip;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainMenuUI extends JFrame implements ActionListener {
    private JPanel panelMainMenu;
    private JPanel panelBurgerMenu;
    private JPanel angusBeefBurgerMenu;
    private JLabel price;
    private JLabel ingredient;
    private JLabel addToCartMessage;
    //  private JLabel burger;
    private JButton snack;
    private JButton burger;
    private JButton angusBeefBurger;
    private JButton addToCart;
    private JButton backToBeefBurger;
    private JButton readyToPay;
    public static ArrayList<Food> foods = new ArrayList<>();

    public MainMenuUI() {
        panelMainMenu = new JPanel();
        panelBurgerMenu = new JPanel();
        angusBeefBurgerMenu = new JPanel();
        burger = new JButton();
        angusBeefBurger = new JButton();
        price = new JLabel("Price: $23.99");
        addToCart = new JButton("Add to cart");
        backToBeefBurger = new JButton("Return");
        ingredient = new JLabel(AngusBeefBurger.ingredient);
        addToCartMessage = new JLabel("You've successfully ordered Angus Beef Burger");
        readyToPay = new JButton("Ready to pay");
        snack = new JButton("Snack");

        burger.setText("Burger Menu");
        angusBeefBurger.setText("Angus Beef Burger");

        add(panelMainMenu);
        panelMainMenu.add(burger);
        panelMainMenu.add(snack);
        panelBurgerMenu.add(angusBeefBurger);
        panelBurgerMenu.add(readyToPay);
        angusBeefBurgerMenu.add(price);
        angusBeefBurgerMenu.add(ingredient);
        angusBeefBurgerMenu.add(addToCart);
        angusBeefBurgerMenu.add(backToBeefBurger);

        panelMainMenu.setLayout(new GridLayout(4, 1));
        panelBurgerMenu.setLayout(new GridLayout(4, 1));
        angusBeefBurgerMenu.setLayout(new GridLayout(5, 1));
        burger.addActionListener(this);
        angusBeefBurger.addActionListener(this);
        backToBeefBurger.addActionListener(this);
        addToCart.addActionListener(this);
        readyToPay.addActionListener(this);
        snack.addActionListener(this);


        setTitle("Main Menu");
        setSize(450, 250);
        setVisible(true);


    }

    public static double totalPriceCalculator() {
        double totalPrice = 0;
        for (Food food : foods) {
            totalPrice += food.getPrice();
        }
        if (SilverVip.promoteToSilver(MembershipUI.customer)) {
            return Math.round(totalPrice * 0.85);
        }
        if (GoldVip.promoteToGold(MembershipUI.customer)) {
            return Math.round(totalPrice * 0.7);
        } else {
            return totalPrice;
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JButton jbutton = (JButton) e.getSource();
        if (jbutton.getText() == "Burger Menu") {
            remove(panelMainMenu);
            add(panelBurgerMenu);
            setTitle("Burger Menu");
            setSize(450, 250);
            setVisible(true);
            pack();
        }
        if (jbutton.getText() == "Angus Beef Burger") {
            remove(panelBurgerMenu);
            add(angusBeefBurgerMenu);
            setTitle("Angus Beef Burger");
            pack();
        }
        if (jbutton.getText() == "Return") {
            remove(angusBeefBurgerMenu);
            add(panelBurgerMenu);
            setTitle("Burger Menu");
            pack();
        }
        if (jbutton.getText() == "Add to cart") {
            foods.add(new AngusBeefBurger());
            angusBeefBurgerMenu.add(addToCartMessage);
            pack();
        }
        if (jbutton.getText() == "Ready to pay") {
            dispose();
            new PayUI();
        }
        if (jbutton.getText() == "Snack") {
            dispose();
            new SnackMenuUI();
        }
    }
}