package com.techelevator.models;

import java.math.BigDecimal;

public class Balance {
    //******add balance object to vendingmachine class
    private int itemBoughtCounter = 1;
    private BigDecimal currentBalance;


    public Balance() {
        this.currentBalance = BigDecimal.ZERO;
    }


    public BigDecimal getCurrentBalance() {
        return currentBalance;
    }


    public void addmoney(String cashIn) {


        if (!cashIn.equals("1") && !cashIn.equals("5") && !cashIn.equals("10") && !cashIn.equals("20")) {
            System.out.println("Not a valid bill value. Please put in a $1, $5, $10, or $20 bill.");
        } else {
            BigDecimal cashInBD = new BigDecimal(cashIn);
            currentBalance = currentBalance.add(cashInBD);
        }

    }

    // =======================================
    // added itemBought counter = 1 to top
    public void buyItem(Inventory inventory) {
        //also make sure that you don't allow purchase if the cost of the item is greater than the current balance. this is done in is it affordable
        if (itemBoughtCounter % 2 == 0) {
            currentBalance = currentBalance.subtract(inventory.getPrice().subtract(BigDecimal.ONE));
            System.out.println("Dispensing: " + inventory.getItemName() + ", cost: $" + inventory.getPrice().subtract(BigDecimal.ONE) + " remaining money: $" + currentBalance);
            // do something here to change the quantity
        } else {
            currentBalance = currentBalance.subtract(inventory.getPrice());
            System.out.println("Dispensing: " + inventory.getItemName() + ", cost: $" + inventory.getPrice() + " remaining money: $" + currentBalance);
            // do something here to change the quantity

        }
        itemBoughtCounter++;
    }

    public boolean isItAffordable(Inventory inventory) {
        if (itemBoughtCounter % 2 == 0){
            return currentBalance.doubleValue() >= (inventory.getPrice().doubleValue() - 1);
            } else {
            return currentBalance.doubleValue() >= inventory.getPrice().doubleValue();
            }
        }

    //returnchange
    /* for the returnChange method...
    first separate the whole number and the decimal number (for example 3.25 should be separated into 3 and 0.25)
    the whole number will indicate the number of dollar bills to give back
    for the cents portion. multiply the 0.25 by 100.
    first do remainingCents / 25 as long as the remainder is 0 as many times, keep track of how many times you can divide (probs in for loop is best)
    then do the same with remainingCents / 10
    then do it lastly with remaining cents / 5
    then display the total number of dollars, quarters, dimes, and nickels dispensed
    set currentBalance to zero
    set counterItem back to one
    */


    //buyitem - subtracts price of item from balance
    // bottom code did not really work in preventing

//    public void buyItem(Inventory inventory) {
//        if (itemBoughtCounter % 2 == 0) {
//        if(inventory.getPrice().subtract(BigDecimal.ONE).compareTo(currentBalance) < 0) {
//            currentBalance = currentBalance.subtract(inventory.getPrice().subtract(BigDecimal.ONE));
//            itemBoughtCounter++;
//        } else {
//            System.out.println("Not enough funds. Unable to purchase");
//        }
//    } else {
//        if(inventory.getPrice().compareTo(currentBalance) < 0) {
//            currentBalance = currentBalance.subtract(inventory.getPrice());
//            itemBoughtCounter++;
//        }
//    }
//}




    //Audit?





    //*****BOGODO if i % 2 == 0 , price = price - $1


}
