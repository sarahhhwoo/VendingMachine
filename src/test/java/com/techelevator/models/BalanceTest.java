package com.techelevator.models;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class BalanceTest extends TestCase {

//    @Test
//    public void testAddMoneyZero() {
//        String testInput = "0";
//        String expected = "Not a valid bill value. Please put in a $1, $5, $10, or $20 bill.";
//        Balance bObject = new Balance();
//        BigDecimal testBalance = new BigDecimal(2);
//
//        //Act
//        BigDecimal actual = testBalance.add(new BigDecimal(bObject.addMoney(testInput)));
//
//        //Assert
//        Assert.assertEquals("expected", "");
//
//
//    }

    @Test
    public void testAddMoneyNormal() {
        String testInput = "20";


    }

    @Test
    public void testAddMoneyNull() {
        String testInput = "";


    }

    @Test
    public void testAddMoneyNegative() {
        String testInput = "-1";


    }

    @Test
    public void testAddmoneyLetter() {
        String testInput = "a1";


    }

    public void testBuyItem() {
    }

    public void testIsItAffordable() {
    }

    public void testReturnChange() {
    }
}