package com.techelevator.application;

import com.techelevator.models.Inventory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.TreeMap;

public class SalesReport {


    String salesReportLocation = "C:\\Users\\Student\\workspace\\java-orange-minicapstonemodule1-team8\\";
    LocalDateTime dateAndTime = LocalDateTime.now();
    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MMMMddyy_hhmma");
    String formattedDateTime = dateAndTime.format(dateFormat);
    File salesReport = new File(salesReportLocation + formattedDateTime + "_SalesReport.txt");

    public void makeSalesReport(Map<String, Inventory> itemMap) {
        try (PrintWriter salesReportWriter = new PrintWriter(new FileOutputStream(salesReport, true))) {

            salesReportWriter.println("Taste Elevator Sales Report");
            BigDecimal sumBD = BigDecimal.ZERO;

            for (Map.Entry<String, Inventory> entry : itemMap.entrySet()) {
                salesReportWriter.println(entry.getValue().getItemName() + "|" + entry.getValue().getSoldAtNormalPrice() + "|" + entry.getValue().getSoldAtBOGODOPrice());
                BigDecimal normalTotal = entry.getValue().getPrice().multiply(new BigDecimal(entry.getValue().getSoldAtNormalPrice()));
                BigDecimal bogodoTotal = (entry.getValue().getPrice().subtract(BigDecimal.ONE)).multiply(new BigDecimal(entry.getValue().getSoldAtBOGODOPrice()));

                sumBD = sumBD.add((normalTotal.add(bogodoTotal)));
            }
            salesReportWriter.println("TOTAL SALES " + sumBD.setScale(2));
            salesReportWriter.flush();
            salesReportWriter.close();

        } catch (Exception e) {
            System.out.println("Audit File not able to be written");
        }


    }


}
