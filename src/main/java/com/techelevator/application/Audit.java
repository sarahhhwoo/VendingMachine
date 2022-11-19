package com.techelevator.application;

import com.techelevator.models.Inventory;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//Prints and sends information to external Audit txt file. Creates new file if one does not exist. Continually appends.
public class Audit {
    // format made for date/time
    private DateTimeFormatter dateCorrectFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a ");

    public Audit() {
        // default constructor
    }

    // Audit writer method for feedMoney event
    public void auditWriterForMoneyFed(BigDecimal moneyPutIn, BigDecimal currentBalance) {
        try (PrintWriter auditWriter = new PrintWriter(new FileOutputStream("Audit.txt", true))) {
            // set up current date and time
            LocalDateTime dateAndTime = LocalDateTime.now();
            String currentDateWFormat = dateAndTime.format(dateCorrectFormat);

            // create variables for individual String component
            String moneyFedStr = String.format("%-17s", "MONEY FED:");
            String paddingForSlot = String.format("%-3s", "");
            String moneyGiven = String.format("%6s", "$" + moneyPutIn.setScale(2));
            String updatedBalance = String.format("%8s", "$" + currentBalance.setScale(2));

            // print to audit txt file
            auditWriter.println(currentDateWFormat + moneyFedStr + paddingForSlot + moneyGiven + updatedBalance);
            auditWriter.flush();
        } catch (FileNotFoundException e) {
            System.out.println("Sorry no file found!");
        }
    }

    //Audit writer method for buyItem event
    public void auditWriterForBuyItem(Inventory inventory, BigDecimal initialBalance, BigDecimal postPurchase) {

        try (PrintWriter auditWriter = new PrintWriter(new FileOutputStream("Audit.txt", true))) {
            // set up current date and time
            LocalDateTime dateAndTime = LocalDateTime.now();
            String currentDateWFormat = dateAndTime.format(dateCorrectFormat);

            // create variables for individual String component
            String itemName = String.format("%-17s", inventory.getItemName());
            String slot = String.format("%-3s", inventory.getSlot());
            String beforeBuyBalance = String.format("%6s", "$" + initialBalance.setScale(2, RoundingMode.HALF_UP));
            String afterBuyBalance = String.format("%8s", "$" + postPurchase.setScale(2, RoundingMode.HALF_UP));

            // print to audit txt file
            auditWriter.println(currentDateWFormat + itemName + slot + beforeBuyBalance + afterBuyBalance);
            auditWriter.flush();
        } catch (FileNotFoundException e) {
            System.out.println("Sorry no file found!");
        }
    }
        //AUDIT WRITER METHOD FOR "FINISH TRANSACTION" event
    public void auditWriterForReturnChange(BigDecimal totalChange, BigDecimal zeroBalance) {
        try (PrintWriter auditWriter = new PrintWriter(new FileOutputStream("Audit.txt", true))) {
            // set up current date and time
            LocalDateTime dateAndTime = LocalDateTime.now();
            String currentDateWFormat = dateAndTime.format(dateCorrectFormat);

            // create variables for individual String component
            String changeGivenStr = String.format("%-17s", "CHANGE GIVEN:");
            String slotPadding = String.format("%-3s", "");
            String changeToGive = String.format("%6s", "$" + totalChange);
            String newBalance = String.format("%8s", "$" + zeroBalance.setScale(2));

            // print to audit txt file
            auditWriter.println(currentDateWFormat + changeGivenStr + slotPadding + changeToGive + newBalance );
            auditWriter.flush();
        } catch (FileNotFoundException e) {
            System.out.println("Sorry no file found!");
        }
    }

}
