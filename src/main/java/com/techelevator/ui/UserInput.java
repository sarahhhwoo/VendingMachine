package com.techelevator.ui;

import com.techelevator.models.Balance;
import com.techelevator.models.Inventory;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Responsibilities: This class should handle receiving ALL input from the User
 * 
 * Dependencies: None
 */
public class UserInput
{
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
        else
        {
            return "";
        }

    }


    public String getPurchaseScreenOption(double currentBalance)
    {

        System.out.println("M) Feed Money");
        System.out.println("S) Select Item");
        System.out.println("F) Finish Transaction");



        System.out.print("CURRENT MONEY PROVIDED: $" + currentBalance );
        System.out.println();
        System.out.print("Please select an option: ");
        String selectedOption = scanner.nextLine();
        String option = selectedOption.trim().toUpperCase();

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
            return "";
        }

    }
   @TODO //clean up formatting*********SET UP CONNECTION TO AUDIT
    public String feedMoneyOption () {

        System.out.println("Please insert money:");
        String cashIn = scanner.nextLine();
        return cashIn;
    }
    public void selectItemOption () {
        //list of items display
        System.out.println();
        System.out.println("Select item code: ");
        String itemCode = scanner.nextLine();
    }

    public String buttonPress(HashMap<String, Inventory> stock, String itemCode){
        if(!stock.containsKey(itemCode)){
            System.out.println("Please select a valid item");
            return "purchase";
        }
        else if(stock.get(itemCode).getQuantity() < 1) {
            System.out.println("ITEM NO LONGER AVAILABLE");
            return "purchase";
        }
        else{
            System.out.print(stock.get(itemCode).getItemName() + stock.get(itemCode).getPrice() + " ");
            //RETURN TO THIS
        }
        return "purchase";

    }





}
