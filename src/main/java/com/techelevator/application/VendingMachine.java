package com.techelevator.application;


import com.techelevator.models.Balance;
import com.techelevator.models.Inventory;
import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;

import java.math.BigDecimal;

import java.math.RoundingMode;

import java.util.Map;

public class VendingMachine {
    public void run() {
        UserOutput userOutput = new UserOutput();
        UserInput userInput = new UserInput();
        InventoryInitialize iIObject = new InventoryInitialize();
        iIObject.initializeInventory();
        Balance balanceObject = new Balance();

        while (true) {
            userOutput.displayHomeScreen();
            String choice = userInput.getHomeScreenOption();


            if (choice.equals("display")) {
                userOutput.displayDisplayVIScreen();
                // display the vending machine slots
                // iIObject.initializeInventory();
                for (Map.Entry<String, Inventory> entry : iIObject.getItemMap().entrySet()) {
                    //if (entry.getValue.equals("0")
                    if (entry.getValue().getQuantity() < 1) {
                        System.out.println(entry.getKey() + " " + entry.getValue().getItemName() + " NO LONGER AVAILABLE");
                    } else {
                        System.out.println(entry.getKey() + " " + entry.getValue().getItemName() + " " + entry.getValue().getPrice());
                    }
                }
                // for(String eachKey : mapOfItems) {
                //     sout(eachKey.getName + " has " + eachKey)

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
                            }}


                            //===============================================================
                        String itemCode = userInput.selectItemOption();
                        if (userInput.isItAvailable(iIObject.getItemMap(), itemCode)) {
                            Inventory inventory = iIObject.getItemMap().get(itemCode);
                            // need to check if the person can afford it... maybe a boolean method in balance??
                            if (balanceObject.isItAffordable(inventory)) {
                                //need to change the cost to reflect the discount, but balance.buyitem accounts for it already
                                // Will add this to balance.buyItem to see if it works! - it worked System.out.println("Dispensing: " + inventory.getItemName() + ", cost: $" + inventory.getPrice() + " remaining money: $" + balanceObject.getCurrentBalance());
                                balanceObject.buyItem(inventory);
                                userOutput.displayItemTypeMessage(inventory); // change this for later.. where to put this???? maybe in useroutput?
                            } else {
                                userOutput.displayMessage("Need to input more money!");

                                // dont forget to think about the sales report and audit text.
                            }
                        }
                        } else if (purchaseMenu.equals("finish transaction")) {
                        // return change

                        balanceObject.returnChange();

                        //set currentbalance to zero
                        //reference return change method (can do all these functions in that method)
                        break;
                    }
                }
              } else if (choice.equals("exit")) {
                userOutput.displayGoodByeScreen();
                break;
            }
        }

    }
}
