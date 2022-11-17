package com.techelevator.application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {
    private List<String> itemStrings = new ArrayList<>();
    File inventoryFile = new File("catering.csv");


    public void readFile() {
        try (
                Scanner inventoryScanner = new Scanner(inventoryFile)) {
            while (inventoryScanner.hasNextLine()) {
                // create Inventory Objects
                // new Inventory (slot, name, price, type, stock)
                // List<Inventory> items;
                String itemLine = inventoryScanner.nextLine();
                //String fullItemLine = itemLine; // possibly review
                //String[] eachItemArray = fullItemLine.split(",");
                //Inventory newInventory = new Inventory(eachItemArray[0], eachItemArray[1], new BigDecimal(eachItemArray[2]), eachItemArray[3], Integer.parseInt(eachItemArray[4]));
                itemStrings.add(itemLine);
//                inventoryList.add(eachItemArray);
            }
        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<String> getItemStrings() {
        return itemStrings;
    }

}
