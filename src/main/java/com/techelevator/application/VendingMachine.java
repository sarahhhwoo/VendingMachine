package com.techelevator.application;

import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;

import java.util.Map;

public class VendingMachine 
{
    public void run()
    {
        UserOutput userOutput = new UserOutput();
        UserInput userInput = new UserInput();
        InventoryInitialize iIObject = new InventoryInitialize();
        iIObject.initializeInventory();

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
            else if(choice.equals("purchase"))
            {
                // make a purchase
            }
            else if(choice.equals("exit"))
            {
                // good bye
                break;
            }
        }
    }
    
}
