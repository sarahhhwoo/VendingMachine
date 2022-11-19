package com.techelevator.application;

import com.techelevator.models.Inventory;

import java.math.BigDecimal;
import java.util.*;

public class InventoryInitialize {
    private Map<String, Inventory> itemMap = new TreeMap<>();
    private FileReader fileReaderObj = new FileReader();

    public Map<String, Inventory> getItemMap() {
        return itemMap;
    }

    //takes in information from FileReader, splits information into String[]. Then stores each item in TreeMap, with slot number as key and Inventory object as value.
    public void initializeInventory() {
        fileReaderObj.readFile();
        for(String eachLine : fileReaderObj.getItemStrings()) {
            String[] eachItemArray = eachLine.split(",");
            Inventory putInMap = new Inventory(eachItemArray[0], eachItemArray[1], new BigDecimal(eachItemArray[2]), eachItemArray[3]);
            itemMap.put(eachItemArray[0], putInMap);
        }
    }
}
