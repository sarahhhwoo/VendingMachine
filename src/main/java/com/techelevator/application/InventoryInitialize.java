package com.techelevator.application;

import com.techelevator.models.Inventory;

import java.math.BigDecimal;
import java.util.*;

public class InventoryInitialize {
    private Map<String, Inventory> itemMap = new TreeMap<>();

    Inventory inventoryObject = new Inventory();
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
            itemMap.put(eachItemArray[0], new Inventory(eachItemArray[1], new BigDecimal(eachItemArray[2]), eachItemArray[3]));
            // for(String eachLine : fileReader.obj.getItemString) {
//              String[] eachItemArray = eachLine.split(,);
            //      mapOfItems.put( eachItemArray[0], new Inventory(name, price, type, quantity));
        }
        //display entire inventory()
        // for(String eachKey : mapOfItems) {
        //     sout(eachKey.getName + " has " + eachKey)
        //}


    }






    // ============================GRAVEYARD!!!!==========================================
//    public String getItemName(String slot) {
//        String returnName = "";
//        for(Inventory eachObject : items){
//            if(eachObject.getSlot().equals(slot)) {
//                returnName = eachObject.getItemName();
//            }
//        }
//        return returnName;
//    }
//    public BigDecimal getPrice(String slot) {
//        BigDecimal returnPrice = BigDecimal.ZERO;
//        for(Inventory eachObject : items){
//            if(eachObject.getSlot().equals(slot)) {
//                returnPrice = eachObject.getPrice();
//            }
//        }
//        return returnPrice;
//    }
//
//    public String getType(String slot){
//        String returnType = "";
//        for(Inventory eachObject : items){
//            if(eachObject.getSlot().equals(slot)) {
//                returnType = eachObject.getType();
//            }
//        }
//        return returnType;
//    }

//    public int getQuantity(String slot){
//        int returnQuantity = 0;
//        for(Inventory eachObject : items){
//            if(eachObject.getSlot().equals(slot)) {
//                returnQuantity = eachObject.getQuantity();
//            }
//        }
//        return returnQuantity;
//    }
//
//    public List<Inventory> getItems() {
//        return items;
//    }



}
