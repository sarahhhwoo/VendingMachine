package com.techelevator.models;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class BalanceTest extends TestCase {
    private int itemCounter = 1;


    @Test
    public void testAddMoneyZero() {
        Balance balanceTest = new Balance();
        String cashIn = "0";
        BigDecimal expectedBalance = BigDecimal.ZERO.setScale(2);
        balanceTest.addMoney(cashIn);
        Assert.assertEquals(expectedBalance, balanceTest.getCurrentBalance());
    }

    @Test
    public void testAddMoneyNormal() {
        Balance balanceTest = new Balance();
        String cashIn = "20";
        BigDecimal expectedBalance = new BigDecimal("20").setScale(2);
        balanceTest.addMoney(cashIn);
        Assert.assertEquals(expectedBalance, balanceTest.getCurrentBalance());
    }

    @Test
    public void testAddMoneyNegative() {
        Balance balanceTest = new Balance();
        String testInput = "-1";
        BigDecimal expectedBalance = BigDecimal.ZERO.setScale(2);
        balanceTest.addMoney(testInput);
        Assert.assertEquals(expectedBalance, balanceTest.getCurrentBalance());
    }

    @Test
    public void testAddmoneyLetter() {
        Balance balanceTest = new Balance();
        String testInput = "a1";
        BigDecimal expectedBalance = BigDecimal.ZERO.setScale(2);
        balanceTest.addMoney(testInput);
        Assert.assertEquals(expectedBalance, balanceTest.getCurrentBalance());
    }

    @Test
    public void testIsItAffordableHappyPathCounter1() {
        Balance balanceTest = new Balance();
        balanceTest.setItemBoughtCounter(1);
        balanceTest.addMoney("5");
        Inventory inventoryTest = new Inventory("B1", "Stackers", new BigDecimal(2.65), "Munchy");
        Assert.assertTrue("This should be true", balanceTest.isItAffordable(inventoryTest));

    }

    @Test
    public void testIsItAffordableHappyPathCounter2() {
        Balance balanceTest = new Balance();
        balanceTest.setItemBoughtCounter(2);
        balanceTest.addMoney("1");
        Inventory inventoryTest = new Inventory("A2", "Ginger Ayle", new BigDecimal(1.85), "Drink");
        Assert.assertTrue("This should be true", balanceTest.isItAffordable(inventoryTest));
    }

    @Test
    public void testNotAffordableCounter3() {
        Balance balanceTest = new Balance();
        balanceTest.setItemBoughtCounter(3);
        balanceTest.addMoney("1");
        balanceTest.addMoney("1");
        Inventory inventoryTest = new Inventory("C3", "Moonpie", new BigDecimal(2.01), "Candy");
        Assert.assertFalse("This should be false", balanceTest.isItAffordable(inventoryTest));
    }

    @Test
    public void testIsItAffordableNotAffordableCounter4() {
        Balance balanceTest = new Balance();
        balanceTest.setItemBoughtCounter(4);
        balanceTest.addMoney("1");
        Inventory inventoryTest = new Inventory("A2", "Ginger Ayle", new BigDecimal(2.01), "Drink");
        Assert.assertFalse("This should be false", balanceTest.isItAffordable(inventoryTest));
    }

    @Test
    public void testIsItAffordableEqualValuesCounter5() {

    }

    @Test
    public void testIsItAffordableEqualValuesCounter6() {

    }


    public void testBuyItem() {
    }



    public void testReturnChange() {
    }
}