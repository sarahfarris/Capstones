package org.example;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class File_Writing_Reading {
    static Scanner user_input = new Scanner(System.in);
    public static final String inventory_file = "inventory.csv";
    public static final DateTimeFormatter dt_formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");


    public static void writeTo (Transaction transaction) {

        try (FileWriter fw = new FileWriter(inventory_file, true)) {
            fw.write(transaction.toFileString(user_input.nextLine()));
        } catch (IOException e) {
            e.getMessage();
        }
    }

    public static List<Transaction> readTransactionsFromFile() {
        List<Transaction> transactions = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader((inventory_file)))) {
            // loop over the lines in the file with br and add each transaction to the list
        } catch (IOException e) {
            // proper error handling
        }
        return transactions;
    }



}
