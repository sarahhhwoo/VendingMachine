package com.techelevator.ui;


import com.techelevator.models.Inventory;

/**
 * Responsibilities: This class should handle formatting and displaying ALL
 * messages to the user
 * 
 * Dependencies: None
 */
public class UserOutput {

    public void displayMessage(String message) {
        System.out.println();
        System.out.println(message);
        System.out.println();
    }

    public void displayHomeScreen() {
        System.out.println();
        System.out.println("***************************************************");
        System.out.println("                      Home");
        System.out.println("***************************************************");
        System.out.println();
    }

    public void displayDisplayVIScreen() {
        System.out.println();
        System.out.println("***************************************************");
        System.out.println("              Displaying All Items");
        System.out.println("***************************************************");
        System.out.println();
    }

    public void displayPurchaseScreen() {
        System.out.println();
        System.out.println("***************************************************");
        System.out.println("                   Purchase");
        System.out.println("***************************************************");
        System.out.println();
    }

    public void displayGoodByeScreen() {
        System.out.println();
        System.out.println("***************************************************");
        System.out.println("     Thank you for using J&S Vending Machine");
        System.out.println("***************************************************");
        System.out.println();
    }

    //============================================
    public void displayItemTypeMessage(Inventory inventory) {
        if (inventory.getType().equals("Munchy")) {
            System.out.println("Munchy, Munchy, so Good!");
        } else if (inventory.getType().equals("Candy")) {
            System.out.println("Sugar, Sugar, so Sweet!");
        } else if (inventory.getType().equals("Drink")) {
            System.out.println( "Drinky, Drinky, Slurp Slurp!");
        } else if (inventory.getType().equals("Gum")) {
            System.out.println("Chewy, Chewy, Lots O Bubbles!");
        }
    }
}
