package com.techelevator.application;

import com.techelevator.models.Inventory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
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
            auditWriter.println(currentDateWFormat + "MONEY FED: " + "           $" + moneyPutIn + "  $" + currentBalance);
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
    // can change parameters to overload

    // MAYBE WE SHOULD ADD SLOT AS PART OF INVENTORY
    public void auditWriterForBuyItem(Inventory inventory, BigDecimal initialBalance, BigDecimal postPurchase) {
        try (PrintWriter auditWriter = new PrintWriter(new FileOutputStream("Audit.txt", true))) {
            LocalDateTime dateAndTime = LocalDateTime.now();
            DateTimeFormatter dateCorrectFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a ");
            String currentDateWFormat = dateAndTime.format(dateCorrectFormat);
            auditWriter.println(currentDateWFormat + inventory.getItemName() + "        " + inventory.getSlot() + " $" + initialBalance + " $" + postPurchase);
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
            auditWriter.println(currentDateWFormat + "CHANGE GIVEN:" + "       " + "$" + totalChange + "  $" + zeroBalance.setScale(2));
            auditWriter.flush();
            auditWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("Sorry no file found!");
        }
    }

}
