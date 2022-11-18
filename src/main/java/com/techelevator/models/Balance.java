package com.techelevator.models;

import java.math.BigDecimal;

public class Balance {

    //******add balance object to vendingmachine class

    private BigDecimal currentBalance = BigDecimal.ZERO;

    public Balance(BigDecimal currentBalance) {
        this.currentBalance = currentBalance;
    }
    public Balance() {
    }


    public BigDecimal getCurrentBalance() {
        return currentBalance;
    }


    public void addmoney(String cashIn){


        if(!cashIn.equals("1") && !cashIn.equals("5") && !cashIn.equals("10") && !cashIn.equals("20")){
            System.out.println("Not a valid bill value. Please put in a $1, $5, $10, or $20 bill.");
        }
        else{BigDecimal cashInBD = new BigDecimal(cashIn);
        currentBalance = currentBalance.add(cashInBD);
        }





    }

    //buyitem - subtracts price of item from balance

    //returnchange





    //*****BOGODO if i % 2 == 0 , price = price - $1







}
