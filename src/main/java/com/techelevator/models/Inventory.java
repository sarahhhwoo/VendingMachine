package com.techelevator.models;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Inventory {
    private int quantity = 6;
    private BigDecimal price;
    private String itemName;
    private String type;



  public Inventory(String itemName, BigDecimal price, String type) {
      this.itemName = itemName;
      this.price = price;
      this.type = type;
      this.quantity = quantity;
  }
    public Inventory(){

    }
    public int getQuantity() {
        return quantity;
    }

    public BigDecimal getPrice() {
      return price;
    }

    public String getItemName() {
        return itemName;
    }

    public String getType() {
        return type;
    }


    //    public Inventory() throws FileNotFoundException {
//    }
//

//    }
//
//    public double getPrice(int index) {
//        return Double.parseDouble(inventoryList.get(index)[2]);
//    }
//
//    public String getSlotLocation(int index) {
//        return inventoryList.get(index)[0];
//    }
//
//    public String getItemName(int index) {
//        return inventoryList.get(index)[1];
//    }
//
//    public String getItemType(int index) {
//        return inventoryList.get(index)[3];
//    }
//
//    public String listAllInventory() {
//        for(String[] eachArray: inventoryList){
//            System.out.println(eachArray[1] + " has " + eachArray[4] + "snacks left over.");
//        }
//        return;
//    }
}
