package com.techelevator.application;

import com.techelevator.models.Inventory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class SalesReport {
    private String salesReportLocation = "C:\\Users\\Student\\workspace\\java-orange-minicapstonemodule1-team8\\";
    private DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MMMMddyy_hhmma");

    public void makeSalesReport(Map<String, Inventory> itemMap) {
        // takes current date/time and uses format from above to create unique files names whenever this method is called.
        LocalDateTime dateAndTime = LocalDateTime.now();
        String formattedDateTime = dateAndTime.format(dateFormat);
        File salesReport = new File(salesReportLocation + formattedDateTime + "_SalesReport.txt");

        try (PrintWriter salesReportWriter = new PrintWriter(new FileOutputStream(salesReport, true))) {
            salesReportWriter.println("Taste Elevator Sales Report");
            BigDecimal sumBD = BigDecimal.ZERO;

            // iterate through Map to access each Value(Inventory) of the map
            for (Map.Entry<String, Inventory> entry : itemMap.entrySet()) {
                // create variables for cleaner aesthetic
                String eachValueName = entry.getValue().getItemName();
                BigDecimal eachValuePrice = entry.getValue().getPrice();
                int eachValueSoldAtNormalPrice = entry.getValue().getSoldAtNormalPrice();
                int eachValueSoldAtBogodoPrice = entry.getValue().getSoldAtBOGODOPrice();

                // print a line with name of Inventory object and items sold and normal vs sale price
                salesReportWriter.println(eachValueName + "|" + eachValueSoldAtNormalPrice + "|" + eachValueSoldAtBogodoPrice);
                //calculate total money made from items sold from this Inventory object and add to sum
                BigDecimal normalTotal = eachValuePrice.multiply(new BigDecimal(eachValueSoldAtNormalPrice));
                BigDecimal bogodoTotal = (eachValuePrice.subtract(BigDecimal.ONE)).multiply(new BigDecimal(eachValueSoldAtBogodoPrice));
                sumBD = sumBD.add((normalTotal.add(bogodoTotal)));
            }
            //print total sales, after foreach loop finishes, to complete sales report
            salesReportWriter.println("TOTAL SALES " + sumBD.setScale(2, RoundingMode.HALF_UP));
            salesReportWriter.flush();
        } catch (Exception e) {
            System.out.println("Audit File not able to be written");
        }
    }
}
