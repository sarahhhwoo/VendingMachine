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
    public void testIsItAffordableHappyPathNormal() {
        Balance balanceTest = new Balance();
        balanceTest.setItemBoughtCounter(1);
        balanceTest.addMoney("5");
        Inventory inventoryTest = new Inventory("B1", "Stackers", new BigDecimal(0.99), "Munchy");
        Assert.assertTrue("This should be true", balanceTest.isItAffordable(inventoryTest));

    }

    @Test
    public void testIsItAffordableHappyPathBOGODO() {
        Balance balanceTest = new Balance();
        balanceTest.setItemBoughtCounter(2);
        balanceTest.addMoney("1");
        Inventory inventoryTest = new Inventory("A2", "Ginger Ayle", new BigDecimal(1.99), "Drink");
        Assert.assertTrue("This should be true", balanceTest.isItAffordable(inventoryTest));
    }

    @Test
    public void testNotAffordableNormal() {
        Balance balanceTest = new Balance();
        balanceTest.setItemBoughtCounter(3);
        balanceTest.addMoney("1");
        balanceTest.addMoney("1");
        Inventory inventoryTest = new Inventory("C3", "Moonpie", new BigDecimal(2.01), "Candy");
        Assert.assertFalse("This should be false", balanceTest.isItAffordable(inventoryTest));
    }

    @Test
    public void testIsItAffordableNotAffordableBOGODO() {
        Balance balanceTest = new Balance();
        balanceTest.setItemBoughtCounter(4);
        balanceTest.addMoney("1");
        Inventory inventoryTest = new Inventory("A2", "Ginger Ayle", new BigDecimal(2.01), "Drink");
        Assert.assertFalse("This should be false", balanceTest.isItAffordable(inventoryTest));
    }

    @Test
    public void testIsItAffordableEqualValuesNormal() {
        Balance balanceTest = new Balance();
        balanceTest.setItemBoughtCounter(3);
        balanceTest.addMoney("1");
        balanceTest.addMoney("1");
        Inventory inventoryTest = new Inventory("C3", "Moonpie", new BigDecimal(2.00), "Candy");
        Assert.assertTrue("This should be true", balanceTest.isItAffordable(inventoryTest));

    }

    @Test
    public void testIsItAffordableEqualValuesBOGODO() {
        Balance balanceTest = new Balance();
        balanceTest.setItemBoughtCounter(4);
        balanceTest.addMoney("1");
        Inventory inventoryTest = new Inventory("A2", "Ginger Ayle", new BigDecimal(2.00), "Drink");

        Assert.assertTrue("This should be true", balanceTest.isItAffordable(inventoryTest));

    }

    @Test
    public void testBuyItemQuantityDecrement() {
        //Arrange
        Balance balanceTest = new Balance();
        balanceTest.setItemBoughtCounter(1);
        int expectedQuantity = 4;
        balanceTest.addMoney("5");
        Inventory inventoryTest = new Inventory("A2", "Ginger Ayle", new BigDecimal(2.00), "Drink");

        //Act
        balanceTest.buyItem(inventoryTest);
        balanceTest.buyItem(inventoryTest);
        int actualQuantity = inventoryTest.getQuantity();

        //Assert
        Assert.assertEquals(expectedQuantity, actualQuantity);
    }

    @Test
    public void testBuyItemCounterIncrement() {
        //Arrange
        Balance balanceTest = new Balance();
        int expectedItemBoughtCounter = 3;
        balanceTest.addMoney("5");
        Inventory inventoryTest = new Inventory("A2", "Ginger Ayle", new BigDecimal(2.00), "Drink");

        //Act
        balanceTest.buyItem(inventoryTest);
        balanceTest.buyItem(inventoryTest);
        int actual = balanceTest.getItemBoughtCounter();

        //Assert
        Assert.assertEquals(expectedItemBoughtCounter, actual);
    }

    @Test
    public void testBuyNormalCounter() {
        //Arrange
        Balance balanceTest = new Balance();
        int expected = 2;
        balanceTest.addMoney("10");
        Inventory inventoryTest = new Inventory("A2", "Ginger Ayle", new BigDecimal(2.00), "Drink");

        //Act
        balanceTest.buyItem(inventoryTest);
        balanceTest.buyItem(inventoryTest);
        balanceTest.buyItem(inventoryTest);
        balanceTest.buyItem(inventoryTest);
        int actual = inventoryTest.getSoldAtNormalPrice();

        //Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testBuyBOGODOCounter() {
        //Arrange
        Balance balanceTest = new Balance();
        int expected = 1;
        balanceTest.addMoney("10");
        Inventory inventoryTest = new Inventory("A2", "Ginger Ayle", new BigDecimal(2.00), "Drink");

        //Act
        balanceTest.buyItem(inventoryTest);
        balanceTest.buyItem(inventoryTest);
        balanceTest.buyItem(inventoryTest);
        int actual = inventoryTest.getSoldAtBOGODOPrice();

        //Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testReturnChange() {
        //Arrange
        Balance balanceTest = new Balance();
        int expectedDollars = 7;
        int expectedQuarters = 2;
        int expectedDimes = 1;
        int expectedNickels = 1;
        balanceTest.addMoney("10");
        Inventory inventoryTest = new Inventory("A2", "Ginger Ayle", new BigDecimal(2.35), "Drink");
        balanceTest.buyItem(inventoryTest);
        balanceTest.returnChange();

        int actualDollars = balanceTest.getDollarBills() ;
        int actualQuarters = balanceTest.getNumOfQuarters() ;
        int actualDimes = balanceTest.getNumOfDimes() ;
        int actualNickels = balanceTest.getNumOfNickels() ;

        Assert.assertEquals("There should be 7 dollars", expectedDollars, actualDollars);
        Assert.assertEquals("There should be 2 Quarters", expectedQuarters, actualQuarters);
        Assert.assertEquals("There should be 1 Dime", expectedDimes, actualDimes);
        Assert.assertEquals("There should be 1 Nickel", expectedNickels, actualNickels);
    }

}