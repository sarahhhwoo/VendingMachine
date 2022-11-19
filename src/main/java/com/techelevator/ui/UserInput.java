package com.techelevator.ui;

import com.techelevator.models.Inventory;
import java.util.Map;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

/**
 * Responsibilities: This class should handle receiving ALL input from the User
 * 
 * Dependencies: None
 */
public class UserInput {
    private Scanner scanner = new Scanner(System.in);

    public String getHomeScreenOption()
    {
        System.out.println("What would you like to do?");
        System.out.println();

        System.out.println("D) Display Vending Machine Items");
        System.out.println("P) Purchase");
        System.out.println("E) Exit");

        System.out.println();
        System.out.print("Please select an option: ");

        String selectedOption = scanner.nextLine();
        String option = selectedOption.trim().toUpperCase();

        if (option.equals("D"))
        {
            return "display";
        }
        else if (option.equals("P"))
        {
            return "purchase";
        }
        else if (option.equals("E"))
        {
            return "exit";
        }
        else if (option.equals("S"))
        {
            return "sales report";
        }
        else
        {
            return "Unable to recognize input. Try again.";
        }

    }


    public String getPurchaseScreenOption(BigDecimal currentBalance)
    {

        System.out.println("M) Feed Money");
        System.out.println("S) Select Item");
        System.out.println("F) Finish Transaction");

        System.out.println();
        System.out.println("CURRENT BALANCE: $" + currentBalance.setScale(2, RoundingMode.HALF_UP));

        System.out.println();
        System.out.print("Please select an option: ");
        String selectedOption = scanner.nextLine();
        String option = selectedOption.trim().toUpperCase();
        System.out.println();

        if (option.equals("M"))
        {
            return "feed money";
        }
        else if (option.equals("S"))
        {
            return "select item";
        }
        else if (option.equals("F"))
        {
            return "finish transaction";
        }
        else
        {
            return "Unable to recognize input. Try again.";
        }
    }

    public void displayReturnHomeOption(){
        System.out.println();
        System.out.print("Press any key to return to HomeScreen: ");
        scanner.nextLine();
    }

    public String feedMoneyOption () {

        System.out.print("Please insert money: ");
        String cashIn = scanner.nextLine();
       System.out.println();
        return cashIn;
    }

    public String selectItemOption () {
        //list of items display
        System.out.println();
        System.out.println("Select item code: ");
        String itemCode = scanner.nextLine();
        return itemCode.trim().toUpperCase();
    }

    public boolean isItAvailable(Map<String, Inventory> stock, String itemCode) {
        if(!stock.containsKey(itemCode)){
            System.out.println("Please select a valid item");
            return false;
        }
        else if(stock.get(itemCode).getQuantity() < 1) {
            System.out.println("ITEM NO LONGER AVAILABLE");
            return false;
        }
        else{
            return true;
        }
    }
}
