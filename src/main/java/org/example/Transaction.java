package org.example;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

import static org.example.MainLedger.scanner;

public class Transaction {
    // give it all the properties of a transaction (like in the file)
    static LocalDate ld;
    static LocalTime lt;
    static String item = scanner.nextLine();
    static double item_price = scanner.nextDouble();
    private LocalDate date;
    private LocalTime time;
    private double price;
    private BufferedOutputStream inventoryFilePath;


    // give it a special method that returns a string
    // that string should match the format (with the pipes) in the assignment
    public String toFileString(String item) {
        this.date = ld;
        this.time = lt;
        Transaction.item = scanner.nextLine();
        this.price = item_price;
        try {
            inventoryFilePath.write(Integer.parseInt(ld + "|" + lt + "|" + scanner.next() + "|" + scanner.nextDouble()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return ld + " | " + lt + " | " + item + " | " + item_price; // not sure if we need to input inventory.csv
    }
}
