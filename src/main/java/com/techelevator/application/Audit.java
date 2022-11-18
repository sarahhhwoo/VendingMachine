package com.techelevator.application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Audit {

    public Audit(){
    }

    public void auditWriterForMoneyFed(BigDecimal moneyPutIn, BigDecimal currentBalance) {
        try (PrintWriter auditWriter = new PrintWriter(new FileOutputStream("Audit.txt", true))) {
            LocalDateTime dateAndTime = LocalDateTime.now();
            DateTimeFormatter dateCorrectFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a" );
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
    public void startTheAuditWriter() {
        try (PrintWriter auditWriter = new PrintWriter(new FileOutputStream("Audit.txt", true))) {
            auditWriter.println();
            auditWriter.flush();
            auditWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("Sorry no file found!");
        }
    }

}
