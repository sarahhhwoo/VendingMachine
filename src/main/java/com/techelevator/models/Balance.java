package com.techelevator.models;

import com.techelevator.application.Audit;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Balance {
    //******add balance object to vendingmachine class
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
            System.out.println("Not a valid bill value. Please put in a $1, $5, $10, or $20 bill.");
        } else {
            BigDecimal cashInBD = new BigDecimal(cashIn);
            currentBalance = currentBalance.add(cashInBD);
            auditInBalance.auditWriterForMoneyFed(cashInBD, currentBalance);

        }
    }
    //subtracts money from balance when item is selected. Increments number of items bought. Decrements available item amount.
    // added itemBought counter = 1 to top
    public void buyItem(Inventory inventory) {
        BigDecimal initialBalance = currentBalance;
        BigDecimal postPurchaseBalance;
        //also make sure that you don't allow purchase if the cost of the item is greater than the current balance. this is done in is it affordable

        //if item count is even, apply BOGODO deal
        if (itemBoughtCounter % 2 == 0) {
           postPurchaseBalance = currentBalance.subtract(inventory.getPrice().subtract(BigDecimal.ONE));
           int bogodoCounter = inventory.getSoldAtBOGODOPrice() + 1;
           inventory.setSoldAtBOGODOPrice(bogodoCounter);

            System.out.println("Dispensing: " + inventory.getItemName() + ", cost(special BOGODO Price!): $" + inventory.getPrice().subtract(BigDecimal.ONE) + " remaining money: $" + postPurchaseBalance);

            //if itemcount is odd, regular price
        } else {
            postPurchaseBalance = currentBalance.subtract(inventory.getPrice());
            int normalPriceCounter = inventory.getSoldAtNormalPrice() + 1;
            inventory.setSoldAtNormalPrice(normalPriceCounter);

            System.out.println("Dispensing: " + inventory.getItemName() + ", cost: $" + inventory.getPrice() + " remaining money: $" + postPurchaseBalance);
        }
        //increments # of items purchased count. Decrements inventory for slot purchased.
        itemBoughtCounter++;
        int currentQuantity = inventory.getQuantity() - 1;
        inventory.setQuantity(currentQuantity);
        //sends information to Audit.txt. resents currentBalance to new balance;
        auditInBalance.auditWriterForBuyItem(inventory, initialBalance, postPurchaseBalance);
        currentBalance = postPurchaseBalance;
    }
        //checks that user has enough money in balance to buy selected item
    public boolean isItAffordable(Inventory inventory) {
        if (itemBoughtCounter % 2 == 0){
            return currentBalance.doubleValue() >= (inventory.getPrice().doubleValue() - 1);
            } else {
            return currentBalance.doubleValue() >= inventory.getPrice().doubleValue();
            }
        }
    //runs at "Finish Transaction" provides change in fewest possible units & returns balance to zero.
    public void returnChange() {
        int dollarBills = currentBalance.intValue();
        final int QUARTER_VALUE = 25;
        final int DIME_VALUE = 10;
        final int NICKEL_VALUE = 5;
        int numOfQuarters = 0;
        int numOfDimes = 0;
        int numOfNickels = 0;
        BigDecimal totalChange = currentBalance;
        BigDecimal coinsToReturn = currentBalance.subtract(new BigDecimal(dollarBills)); // 3.60 - 3 = 0.60
        int remainingCents = (int) (coinsToReturn.doubleValue() * 100); // 60


        while (remainingCents >= QUARTER_VALUE) {
            remainingCents = remainingCents - QUARTER_VALUE;
            numOfQuarters++;
        }
        while (remainingCents >= DIME_VALUE) {
            remainingCents = remainingCents - DIME_VALUE;
            numOfDimes++;
        }
        while (remainingCents >= NICKEL_VALUE) {
            remainingCents = remainingCents - NICKEL_VALUE;
            numOfNickels++;
        }
        System.out.println("Change returned:\n" + dollarBills + " Dollar(s), " + numOfQuarters + " Quarter(s), " + numOfDimes + " Dime(s), " + numOfNickels + " Nickel(s)");
        System.out.println("Total change given: $" + totalChange.setScale(2, RoundingMode.HALF_UP));
        currentBalance = totalChange.subtract(totalChange);
        auditInBalance.auditWriterForReturnChange(totalChange, currentBalance);
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

}
