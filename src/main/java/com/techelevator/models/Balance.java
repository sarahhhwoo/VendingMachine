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


    public void addmoney(String cashIn) {
        if (!cashIn.equals("1") && !cashIn.equals("5") && !cashIn.equals("10") && !cashIn.equals("20")) {
            System.out.println("Not a valid bill value. Please put in a $1, $5, $10, or $20 bill.");
        } else {
            BigDecimal cashInBD = new BigDecimal(cashIn);
            currentBalance = currentBalance.add(cashInBD);

        }
    }

    // added itemBought counter = 1 to top
    public void buyItem(Inventory inventory) {
        //also make sure that you don't allow purchase if the cost of the item is greater than the current balance. this is done in is it affordable
        if (itemBoughtCounter % 2 == 0) {
            currentBalance = currentBalance.subtract(inventory.getPrice().subtract(BigDecimal.ONE));
            System.out.println("Dispensing: " + inventory.getItemName() + ", cost: $" + inventory.getPrice().subtract(BigDecimal.ONE) + " remaining money: $" + currentBalance);
        } else {
            currentBalance = currentBalance.subtract(inventory.getPrice());
            System.out.println("Dispensing: " + inventory.getItemName() + ", cost: $" + inventory.getPrice() + " remaining money: $" + currentBalance);
        }
        itemBoughtCounter++;
        int currentQuantity = inventory.getQuantity() - 1;
        inventory.setQuantity(currentQuantity);
    }

    public boolean isItAffordable(Inventory inventory) {
        if (itemBoughtCounter % 2 == 0){
            return currentBalance.doubleValue() >= (inventory.getPrice().doubleValue() - 1);
            } else {
            return currentBalance.doubleValue() >= inventory.getPrice().doubleValue();
            }
        }

    public void returnChange() {
        BigDecimal totalChange = currentBalance;
        int dollarBills = currentBalance.intValue();  // 3
        BigDecimal coinsToReturn = currentBalance.subtract(new BigDecimal(dollarBills)); // 3.60 - 3 = 0.60

        int remainingCents = (int) (coinsToReturn.doubleValue() * 100); // 60
        final int QUARTER_VALUE = 25;
        final int DIME_VALUE = 10;
        final int NICKEL_VALUE = 5;
        int numOfQuarters = 0;
        int numOfDimes = 0;
        int numOfNickels = 0;


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
        System.out.println("Change returned:\n " + dollarBills + " Dollar(s), " + numOfQuarters + " Quarter(s), " + numOfDimes + " Dime(s), " + numOfNickels + " Nickel(s)");
        System.out.println("total change: $" + totalChange.doubleValue());
        currentBalance = BigDecimal.ZERO;
        itemBoughtCounter = 1;
    }

    //Audit?


}
