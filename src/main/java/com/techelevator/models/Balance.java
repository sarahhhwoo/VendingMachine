package com.techelevator.models;

import com.techelevator.application.Audit;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Balance {
    private final int QUARTER_VALUE = 25;
    private final int DIME_VALUE = 10;
    private final int NICKEL_VALUE = 5;
    private int numOfQuarters = 0;
    private int numOfDimes = 0;
    private int numOfNickels = 0;
    private int dollarBills;
    private int itemBoughtCounter = 1;
    private BigDecimal currentBalance;
    private Audit auditInBalance = new Audit();


    public Balance() {
        this.currentBalance = BigDecimal.ZERO;
    }

    public BigDecimal getCurrentBalance() {
        return currentBalance.setScale(2, RoundingMode.HALF_UP);
    }

    //adds money to balance when user Feeds Money
    public void addMoney(String cashIn) {
        if (!cashIn.equals("1") && !cashIn.equals("5") && !cashIn.equals("10") && !cashIn.equals("20")) {
            // informs user if incorrect dollar bill inserted
            System.out.println("Not a valid bill value. Please put in a $1, $5, $10, or $20 bill.");
        } else {
            // Adds money to current balance
            BigDecimal cashInBD = new BigDecimal(cashIn);
            currentBalance = currentBalance.add(cashInBD);

            // writes to audit txt
            auditInBalance.auditWriterForMoneyFed(cashInBD, currentBalance);
        }
    }

    //subtracts money from balance when item is selected. Increments number of items bought. Decrements available item amount.
    // added itemBought counter = 1 to top
    public void buyItem(Inventory inventory) {
        BigDecimal initialBalance = currentBalance;
        BigDecimal postPurchaseBalance;
        String itemName = inventory.getItemName();
        BigDecimal bogodoPrice = inventory.getPrice().subtract(BigDecimal.ONE);
        BigDecimal normalPrice = inventory.getPrice();

        //if item count is even, apply BOGODO deal
        if (itemBoughtCounter % 2 == 0) {
            //calculate post-purchase balance
           postPurchaseBalance = currentBalance.subtract(bogodoPrice).setScale(2, RoundingMode.HALF_UP);

           //update inventory count for sold at BOGODO price
           int bogodoCounter = inventory.getSoldAtBOGODOPrice() + 1;
           inventory.setSoldAtBOGODOPrice(bogodoCounter);

            //print to user: name, cost, and remaining money
            System.out.println("Dispensing: " + itemName + ", cost(special BOGODO Price!): $" + bogodoPrice + " remaining money: $" + postPurchaseBalance);

        } else {   //if itemcount is odd, regular price
            //calculate post-purchase balance
            postPurchaseBalance = currentBalance.subtract(normalPrice). setScale(2, RoundingMode.HALF_UP);

            //update inventory count for sold at normal price
            int normalPriceCounter = inventory.getSoldAtNormalPrice() + 1;
            inventory.setSoldAtNormalPrice(normalPriceCounter);

            //print to user: name, cost, and remaining money
            System.out.println("Dispensing: " + itemName + ", cost: $" + normalPrice + " remaining money: $" + postPurchaseBalance);
        }
        //increments # of items purchased count. Decrements inventory for slot purchased.
        itemBoughtCounter++;
        int currentQuantity = inventory.getQuantity() - 1;
        inventory.setQuantity(currentQuantity);

        //sends information to Audit txt. resets currentBalance to new balance;
        auditInBalance.auditWriterForBuyItem(inventory, initialBalance, postPurchaseBalance);
        currentBalance = postPurchaseBalance;
    }

    // checks that user has enough money in balance to buy selected item
    public boolean isItAffordable(Inventory inventory) {
        BigDecimal priceOfItem = inventory.getPrice();
        if (itemBoughtCounter % 2 == 0){
            return currentBalance.compareTo(priceOfItem.subtract(BigDecimal.ONE)) >= 0;
            } else {
            return currentBalance.compareTo(priceOfItem) >= 0;
            }
        }

    //runs at "Finish Transaction": provides change in least amount of coins & returns balance to zero.
    public void returnChange() {
        dollarBills = currentBalance.intValue();
        BigDecimal totalChange = currentBalance;
        BigDecimal coinsToReturn = currentBalance.subtract(new BigDecimal(dollarBills));

        //change coinsToReturn to whole numbers
        int remainingCents = (int) (coinsToReturn.doubleValue() * 100);

        //calculate amount of quarters to give back
        while (remainingCents >= QUARTER_VALUE) {
            remainingCents = remainingCents - QUARTER_VALUE;
            numOfQuarters++;
        }
        //calculate amount of dimes to give back
        while (remainingCents >= DIME_VALUE) {
            remainingCents = remainingCents - DIME_VALUE;
            numOfDimes++;
        }
        //calculate amount of nickels to give back
        while (remainingCents >= NICKEL_VALUE) {
            remainingCents = remainingCents - NICKEL_VALUE;
            numOfNickels += 1;
        }

        // print to user the change given
        System.out.println("Change returned:\n" + dollarBills + " Dollar(s), " + numOfQuarters + " Quarter(s), " + numOfDimes + " Dime(s), " + numOfNickels + " Nickel(s)");
        System.out.println("Total change given: $" + totalChange.setScale(2, RoundingMode.HALF_UP));

        // update current balance
        currentBalance = totalChange.subtract(totalChange);

        // write to audit with total change given and new current balance
        auditInBalance.auditWriterForReturnChange(totalChange, currentBalance);

        // reset counter
        itemBoughtCounter = 1;
    }


 //====================================================================================
    //BELOW HERE IS FOR UNIT TESTING PURPOSES ONLY *skull+crossbones emoji*

    public void setItemBoughtCounter(int integer){
        this.itemBoughtCounter = integer;
    }

    public int getItemBoughtCounter() {
        return itemBoughtCounter;
    }

    public int getNumOfQuarters() {
        return numOfQuarters;
    }

    public int getNumOfDimes() {
        return numOfDimes;
    }

    public int getNumOfNickels() {
        return numOfNickels;
    }

    public int getDollarBills() {
        return dollarBills;
    }
}
