package com.techelevator.models;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Balance {
    //******add balance object to vendingmachine class
    private int itemBoughtCounter = 1;
    private BigDecimal currentBalance;


    public Balance() {
        this.currentBalance = BigDecimal.ZERO;
    }

    public BigDecimal getCurrentBalance() {
        return currentBalance.setScale(2, RoundingMode.HALF_UP);
    }

<<<<<<< Updated upstream

    public void addmoney(String cashIn) {


        if (!cashIn.equals("1") && !cashIn.equals("5") && !cashIn.equals("10") && !cashIn.equals("20")) {
            System.out.println("Not a valid bill value. Please put in a $1, $5, $10, or $20 bill.");
        } else {
            BigDecimal cashInBD = new BigDecimal(cashIn);
            currentBalance = currentBalance.add(cashInBD);
        }
<<<<<<< HEAD
=======
        else{BigDecimal cashInBD = new BigDecimal(cashIn);
        currentBalance = currentBalance.add(cashInBD);
        }

=======
    public void addmoney(String cashIn) {
        if (!cashIn.equals("1") && !cashIn.equals("5") && !cashIn.equals("10") && !cashIn.equals("20")) {
            System.out.println("Not a valid bill value. Please put in a $1, $5, $10, or $20 bill.");
        } else {
            BigDecimal cashInBD = new BigDecimal(cashIn);
            currentBalance = currentBalance.add(cashInBD).setScale(2, RoundingMode.HALF_UP);
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
>>>>>>> Stashed changes
>>>>>>> jeff

    }

<<<<<<< HEAD
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
=======
<<<<<<< Updated upstream

>>>>>>> jeff

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
<<<<<<< HEAD
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
=======
=======
    public boolean isItAffordable(Inventory inventory) {
        if (itemBoughtCounter % 2 == 0) {
            return currentBalance.doubleValue() >= (inventory.getPrice().doubleValue() - 1);
        } else {
            return currentBalance.doubleValue() >= inventory.getPrice().doubleValue();
        }
    }
>>>>>>> jeff

    //if 3.60 remains
    public void returnChange() {
        BigDecimal totalChange = currentBalance;
        int dollarBills = currentBalance.intValue();  // 3
        BigDecimal coinsToReturn = currentBalance.subtract(new BigDecimal(dollarBills)); // 3.60 - 3 = 0.60
>>>>>>> Stashed changes

<<<<<<< HEAD
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
=======
        //the whole number will indicate the number of dollar bills to give back

        int remainingCents = (int) (coinsToReturn.doubleValue() * 100); // 60
>>>>>>> jeff

        final int QUARTER_VALUE = 25;
        final int DIME_VALUE = 10;
        final int NICKEL_VALUE = 5;
        int numOfQuarters = 0;
        int numOfDimes = 0;
        int numOfNickels = 0;

<<<<<<< Updated upstream

<<<<<<< HEAD
=======
    //*****BOGODO if i % 2 == 0 , price = price - $1
=======
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
>>>>>>> Stashed changes

        System.out.println("Change returned:\n " + dollarBills + " Dollar(s), " + numOfQuarters + " Quarter(s), " + numOfDimes + " Dime(s), " + numOfNickels + " Nickel(s)");
        System.out.println("total change: $" + totalChange.doubleValue());
>>>>>>> jeff

        currentBalance = BigDecimal.ZERO;
        itemBoughtCounter = 1;
    }

    //Audit?

    //Audit?




    //*****BOGODO if i % 2 == 0 , price = price - $1


}
