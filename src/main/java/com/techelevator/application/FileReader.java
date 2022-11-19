package com.techelevator.application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {

    private List<String> itemStrings = new ArrayList<>();
    File inventoryFile = new File("catering1.csv");

    //scans file that contains vending machine information.
    public void readFile() {
        try (
                Scanner inventoryScanner = new Scanner(inventoryFile)) {
            while (inventoryScanner.hasNextLine()) {
                String itemLine = inventoryScanner.nextLine();
                itemStrings.add(itemLine);
            }
        } catch (
                FileNotFoundException e) {
            System.out.println("File Not Found");
        }
    }

    public List<String> getItemStrings() {
        return itemStrings;
    }

}
