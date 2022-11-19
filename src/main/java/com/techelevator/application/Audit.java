package com.techelevator.application;

import com.techelevator.models.Inventory;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Audit {
//Prints and sends information to external Audit.txt file. Creates new file if one does not exist. Continually appends.

    public Audit(){
    }
            //Audit writer method for feedMoney event
    public void auditWriterForMoneyFed(BigDecimal moneyPutIn, BigDecimal currentBalance) {
        try (PrintWriter auditWriter = new PrintWriter(new FileOutputStream("Audit.txt", true))) {
            LocalDateTime dateAndTime = LocalDateTime.now();
            DateTimeFormatter dateCorrectFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a ");
            String currentDateWFormat = dateAndTime.format(dateCorrectFormat);

            auditWriter.println(currentDateWFormat + String.format("%-17s", "MONEY FED:") + String.format("%-3s", "") + String.format("%6s", "$" + moneyPutIn.setScale(2)) + String.format("%8s", "$" + currentBalance.setScale(2)));

            auditWriter.flush();
            auditWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("Sorry no file found!");
        }
    }

    //Audit writer method for buyItem event
    public void auditWriterForBuyItem(Inventory inventory, BigDecimal initialBalance, BigDecimal postPurchase) {

        try (PrintWriter auditWriter = new PrintWriter(new FileOutputStream("Audit.txt", true))) {
            LocalDateTime dateAndTime = LocalDateTime.now();
            DateTimeFormatter dateCorrectFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a ");
            String currentDateWFormat = dateAndTime.format(dateCorrectFormat);

            //auditWriter.println(currentDateWFormat + itemName + padding +  inventory.getSlot() + " $" + initialBalance.setScale(2) + " $" + postPurchase.setScale(2));
            auditWriter.println(currentDateWFormat + String.format("%-17s", inventory.getItemName()) + String.format("%-3s", inventory.getSlot()) + String.format("%6s", "$" + initialBalance.setScale(2)) +  String.format("%8s", "$" + postPurchase.setScale(2)));

            auditWriter.flush();
            auditWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("Sorry no file found!");
        }
    }
        //AUDIT WRITER METHOD FOR "FINISH TRANSACTION" event
    public void auditWriterForReturnChange(BigDecimal totalChange, BigDecimal zeroBalance) {
        try (PrintWriter auditWriter = new PrintWriter(new FileOutputStream("Audit.txt", true))) {
            LocalDateTime dateAndTime = LocalDateTime.now();
            DateTimeFormatter dateCorrectFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a ");
            String currentDateWFormat = dateAndTime.format(dateCorrectFormat);
            auditWriter.println(currentDateWFormat + String.format("%-17s", "CHANGE GIVEN:") + String.format("%-3s", "") + String.format("%6s", "$" + totalChange) +  String.format("%8s", "$" + zeroBalance.setScale(2)));

            auditWriter.flush();
            auditWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("Sorry no file found!");
        }
    }

}
