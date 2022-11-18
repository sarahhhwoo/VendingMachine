package com.techelevator.application;


import com.techelevator.models.Balance;
import com.techelevator.models.Inventory;
import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;

import java.math.BigDecimal;
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
            }
            else if(choice.equals("purchase")){
                while(true){
                String purchaseMenu = userInput.getPurchaseScreenOption(balanceObject.getCurrentBalance().doubleValue());
                if(purchaseMenu.equals("feed money")){
                    balanceObject.addmoney(userInput.feedMoneyOption());
                    System.out.println("Current Balance: $" + balanceObject.getCurrentBalance().doubleValue());
                } else if(purchaseMenu.equals("select item")){
                    for(Map.Entry<String, Inventory> entry : iIObject.getItemMap().entrySet()){
                        //if (entry.getValue.equals("0")
                        if(entry.getValue().getQuantity() >= 1){
                            System.out.println(entry.getKey() + " " + entry.getValue().getItemName() );
                        }






                } else if(purchaseMenu.equals("finish transaction")){

                }

                }}
                // make a purchase

            else if(choice.equals("exit"))
            {
                // good bye
                break;
            }
        }
    }
    
}
