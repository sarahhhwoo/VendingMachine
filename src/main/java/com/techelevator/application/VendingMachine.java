package com.techelevator.application;


import com.techelevator.models.Balance;
import com.techelevator.models.Inventory;
import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;

<<<<<<< Updated upstream
import java.math.BigDecimal;
=======
import java.math.RoundingMode;
>>>>>>> Stashed changes
import java.util.Map;

public class VendingMachine 
{
    public void run()
    {
        UserOutput userOutput = new UserOutput();
        UserInput userInput = new UserInput();
        InventoryInitialize iIObject = new InventoryInitialize();
        iIObject.initializeInventory();
        Balance balanceObject = new Balance();

        while(true)
        {
            userOutput.displayHomeScreen();
            String choice = userInput.getHomeScreenOption();


            if(choice.equals("display"))
            {
                // display the vending machine slots
               // iIObject.initializeInventory();
                for(Map.Entry<String, Inventory> entry : iIObject.getItemMap().entrySet()){
                    //if (entry.getValue.equals("0")
                    if(entry.getValue().getQuantity() < 1){
                        System.out.println(entry.getKey() + " " + entry.getValue().getItemName() + " NO LONGER AVAILABLE");
                    } else{
                    System.out.println(entry.getKey() + " " + entry.getValue().getItemName() + " " + entry.getValue().getPrice());
                    }
                }
                // for(String eachKey : mapOfItems) {
                //     sout(eachKey.getName + " has " + eachKey)
<<<<<<< Updated upstream
            }
            else if(choice.equals("purchase")){
                while(true){
                String purchaseMenu = userInput.getPurchaseScreenOption(balanceObject.getCurrentBalance().doubleValue());
                if(purchaseMenu.equals("feed money")){
                    balanceObject.addmoney(userInput.feedMoneyOption());
                    System.out.println("Current Balance: $" + balanceObject.getCurrentBalance().doubleValue());
                }
=======
            } else if (choice.equals("purchase")) {
                while (true) {
                    userOutput.displayPurchaseScreen();
                    String purchaseMenu = userInput.getPurchaseScreenOption(balanceObject.getCurrentBalance().setScale(2, RoundingMode.HALF_UP));
                    if (purchaseMenu.equals("feed money")) {
                        balanceObject.addmoney(userInput.feedMoneyOption());
                        userOutput.displayMessage("Current Balance: $" + balanceObject.getCurrentBalance().setScale(2, RoundingMode.HALF_UP));
                    } else if (purchaseMenu.equals("select item")) {
                        for (Map.Entry<String, Inventory> entry : iIObject.getItemMap().entrySet()) {
                            //if (entry.getValue.equals("0")
                            if (entry.getValue().getQuantity() >= 1) {
                                System.out.println(entry.getKey() + " " + entry.getValue().getItemName() + " $" + entry.getValue().getPrice());
                            }
>>>>>>> Stashed changes

                }}
                // make a purchase

<<<<<<< Updated upstream
            else if(choice.equals("exit"))
            {
                // good bye
=======
                        }
                        // dont forget to think about the sales report and audit text.
                    }
                    else if (purchaseMenu.equals("finish transaction")) {
                        // return change
                        balanceObject.returnChange();
                        //set currentbalance to zero
                        //reference return change method (can do all these functions in that method)
                        break;
                    }
                }
              }
            else if (choice.equals("exit")) {
                userOutput.displayGoodByeScreen();
>>>>>>> Stashed changes
                break;
            }
        }
    }
    
}
