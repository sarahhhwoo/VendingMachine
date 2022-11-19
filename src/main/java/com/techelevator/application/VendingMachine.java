package com.techelevator.application;

import com.techelevator.models.Balance;
import com.techelevator.models.Inventory;
import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;
import java.math.RoundingMode;
import java.util.Map;

public class VendingMachine {
    public void run() {
        UserOutput userOutput = new UserOutput();
        UserInput userInput = new UserInput();
        InventoryInitialize iIObject = new InventoryInitialize();
        iIObject.initializeInventory();
        Map<String, Inventory> itemMap = iIObject.getItemMap();
        Balance balanceObject = new Balance();
        SalesReport salesReportObject = new SalesReport();

        while (true) {
            //HOME SCREEN
            userOutput.displayHomeScreen();
            String choice = userInput.getHomeScreenOption();

            //DISPLAY ITEMS SCREEN
            if (choice.equals("display")) {
                while (true) {
                    userOutput.displayDisplayVIScreen();
                    // displays the vending machine slots
                    for (Map.Entry<String, Inventory> entry : itemMap.entrySet()) {
                        String key = entry.getKey();
                        Inventory value = entry.getValue();
                        if (value.getQuantity() < 1) {
                            System.out.println(key + " " + value.getItemName() + " NO LONGER AVAILABLE");
                        } else {
                            System.out.println(key + " " + value.getItemName() + " " + value.getPrice());
                        }
                    }
                    userInput.displayReturnHomeOption();
                    break; // returns to Home Screen
                }
                //Purchase Screen Main
            } else if (choice.equals("purchase")) {
                while (true) {
                    userOutput.displayPurchaseScreen();
                    String purchaseMenu = userInput.getPurchaseScreenOption(balanceObject.getCurrentBalance().setScale(2, RoundingMode.HALF_UP));
                    //Feed Money Screen
                    if (purchaseMenu.equals("feed money")) {
                        balanceObject.addMoney(userInput.feedMoneyOption());
                        userOutput.displayMessage("New Balance: $" + balanceObject.getCurrentBalance().setScale(2, RoundingMode.HALF_UP)); //returns to Purchase Screen Main

                        //Select Item Screen
                    } else if (purchaseMenu.equals("select item")) {
                        for (Map.Entry<String, Inventory> entry : itemMap.entrySet()) {
                            String key = entry.getKey();
                            Inventory value = entry.getValue();
                            if (value.getQuantity() >= 1) {
                                System.out.println(key + " " + value.getItemName() + " $" + value.getPrice());
                            }
                        }
                        String itemCode = userInput.selectItemOption();
                        if (userInput.isItAvailable(itemMap, itemCode)) {
                            Inventory inventory = itemMap.get(itemCode);
                            if (balanceObject.isItAffordable(inventory)) {
                                balanceObject.buyItem(inventory);
                                userOutput.displayItemTypeMessage(inventory);
                            } else {
                                userOutput.displayMessage("Need to input more money!");
                            } //Returns to Purchase Screen Main after each selection
                        }
                    } else if (purchaseMenu.equals("finish transaction")) {
                        balanceObject.returnChange();
                        break; // returns to Purchase Screen Main
                    }
                }
                //Secret option to create sales report
            } else if (choice.equals("sales report")) {
                // run sales report here
                userOutput.salesReportMessage();
                salesReportObject.makeSalesReport(itemMap);

            } else if (choice.equals("exit")) {
                userOutput.displayGoodByeScreen();
                break;
            }
        }
    }
}
