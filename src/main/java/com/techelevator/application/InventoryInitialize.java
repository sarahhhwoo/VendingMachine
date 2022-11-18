package com.techelevator.application;

import com.techelevator.models.Inventory;

import java.math.BigDecimal;
import java.util.*;

public class InventoryInitialize {
    private Map<String, Inventory> itemMap = new TreeMap<>();

    FileReader fileReaderObj = new FileReader();

    public Map<String, Inventory> getItemMap() {
        return itemMap;
    }
// made new file,
    // if quantity == 0, then print out "This item is not available"

    public void initializeInventory() {
        fileReaderObj.readFile();
        for(String eachLine : fileReaderObj.getItemStrings()) {
            String[] eachItemArray = eachLine.split(",");
            itemMap.put(eachItemArray[0], new Inventory(eachItemArray[0], eachItemArray[1], new BigDecimal(eachItemArray[2]), eachItemArray[3]));
        }
    }

}
