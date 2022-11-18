package com.techelevator.ui;

<<<<<<< HEAD
import com.techelevator.models.Inventory;
import java.util.Map;
=======
<<<<<<< Updated upstream
import com.techelevator.models.Balance;

import java.math.BigDecimal;
=======
import com.techelevator.models.Inventory;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;
>>>>>>> Stashed changes
>>>>>>> jeff
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


<<<<<<< HEAD
        System.out.println();
        System.out.println("CURRENT MONEY PROVIDED: $" + currentBalance );
=======
<<<<<<< Updated upstream

        System.out.print("CURRENT MONEY PROVIDED: $" + currentBalance );
=======
        System.out.println();
        System.out.println("CURRENT MONEY PROVIDED: $" + currentBalance.setScale(2, RoundingMode.HALF_UP));
>>>>>>> Stashed changes
>>>>>>> jeff
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
   @TODO //clean up formatting*********SET UP CONNECTION TO AUDIT
    public String feedMoneyOption () {

        System.out.print("Please insert money:");
        String cashIn = scanner.nextLine();
       System.out.println();
        return cashIn;
    }

<<<<<<< HEAD
=======
<<<<<<< Updated upstream
=======
>>>>>>> jeff
    public String selectItemOption () {
        //list of items display
        System.out.println();
        System.out.println("Select item code: ");
        String itemCode = scanner.nextLine();
<<<<<<< HEAD
        return itemCode;
    }
=======
        return itemCode.trim().toUpperCase();
    }
>>>>>>> Stashed changes
>>>>>>> jeff

// ===================================================================================
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

  /*  public String buttonPress(HashMap<String, Inventory> stock, String itemCode){
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

    }*/





}
