package com.techelevator.ui;

<<<<<<< Updated upstream
import com.techelevator.models.Balance;

import java.math.BigDecimal;
=======
import com.techelevator.models.Inventory;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;
>>>>>>> Stashed changes
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


    public String getPurchaseScreenOption(BigDecimal currentBalance)
    {

        System.out.println("M) Feed Money");
        System.out.println("S) Select Item");
        System.out.println("F) Finish Transaction");


<<<<<<< Updated upstream

        System.out.print("CURRENT MONEY PROVIDED: $" + currentBalance );
=======
        System.out.println();
        System.out.println("CURRENT MONEY PROVIDED: $" + currentBalance.setScale(2, RoundingMode.HALF_UP));
>>>>>>> Stashed changes
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

    public String feedMoneyOption () {

        System.out.println("Please insert money");
        String cashIn = scanner.nextLine();
        return cashIn;

<<<<<<< Updated upstream
=======
    public String selectItemOption () {
        //list of items display
        System.out.println();
        System.out.println("Select item code: ");
        String itemCode = scanner.nextLine();
        return itemCode.trim().toUpperCase();
    }
>>>>>>> Stashed changes

    }
}
