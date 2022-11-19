package com.techelevator.application;

import com.techelevator.models.Inventory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Audit {
    LocalDateTime dateAndTime = LocalDateTime.now();
    DateTimeFormatter dateCorrectFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a ");
    String currentDateWFormat = dateAndTime.format(dateCorrectFormat);


    public Audit(){
    }

    public void auditWriterForMoneyFed(BigDecimal moneyPutIn, BigDecimal currentBalance) {
        try (PrintWriter auditWriter = new PrintWriter(new FileOutputStream("Audit.txt", true))) {
            LocalDateTime dateAndTime = LocalDateTime.now();
            DateTimeFormatter dateCorrectFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a ");
            String currentDateWFormat = dateAndTime.format(dateCorrectFormat);
            auditWriter.println(currentDateWFormat + "MONEY FED: " + "         $" + moneyPutIn.setScale(2) + " $" + currentBalance.setScale(2));
            //when it needs to happen:
            //feed money           money put in   and total
            //purchase item     slot balance before and after purchase
            //finish transaction         balance before change + zero
            auditWriter.flush();
            auditWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("Sorry no file found!");
        }
    }

    public void auditWriterForBuyItem(Inventory inventory, BigDecimal initialBalance, BigDecimal postPurchase) {
        int width = 17;
        char fill = ' ';
        String itemName = inventory.getItemName();
        String padding = new String(new char[width - itemName.length()]).replace('\0', fill);


        try (PrintWriter auditWriter = new PrintWriter(new FileOutputStream("Audit.txt", true))) {
            LocalDateTime dateAndTime = LocalDateTime.now();
            DateTimeFormatter dateCorrectFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a ");
            String currentDateWFormat = dateAndTime.format(dateCorrectFormat);

            auditWriter.println(currentDateWFormat + itemName + padding +  inventory.getSlot() + " $" + initialBalance.setScale(2) + " $" + postPurchase.setScale(2));

            auditWriter.flush();
            auditWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("Sorry no file found!");
        }
    }
        //AUDIT WRITER METHOD FOR "FINISH TRANSACTION"
    public void auditWriterForReturnChange(BigDecimal totalChange, BigDecimal zeroBalance) {
        try (PrintWriter auditWriter = new PrintWriter(new FileOutputStream("Audit.txt", true))) {
            LocalDateTime dateAndTime = LocalDateTime.now();
            DateTimeFormatter dateCorrectFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a ");
            String currentDateWFormat = dateAndTime.format(dateCorrectFormat);
            auditWriter.println(currentDateWFormat + "CHANGE GIVEN:" + "       " + "$" + totalChange + " $" + zeroBalance.setScale(2));
            auditWriter.flush();
            auditWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("Sorry no file found!");
        }
    }

}
