package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Ledger {
    static Scanner scanner = new Scanner(System.in);

    // TODO(Sarah): Copy this and make other functions for makePayments with their corresponding messages.
    public static void makeDeposit(String filename) throws IOException {
        File inventoryLedger = new File(filename); //pathway to file
        FileWriter fw;
        try {
            // if file exits, add to it, if not, create new
            if (inventoryLedger.exists()) {
                fw = new FileWriter(inventoryLedger, true);
            } else {
                fw = new FileWriter(inventoryLedger);
            }
        } catch (IOException e) {
            System.out.print("Error loading Ledger!");
            throw new RuntimeException(e);
        }

        boolean addToLedger = true;
        while (addToLedger) {
            addDepositTransactionToLedger(fw);
            System.out.println("Press 1 to make another deposit. Press any other key to exit.");
            String user_choice = scanner.nextLine();
            scanner.next();
            if (!user_choice.equals("1")) {
                addToLedger = false;
                System.out.println("Returning to main menu.");
            }
        }
        fw.close();
    }

    public static void addDepositTransactionToLedger(FileWriter fw) {
        System.out.println("Enter the amount you wish to deposit: ");
        double deposit = scanner.nextDouble();
        scanner.nextLine(); //added consume line as advised

        System.out.println("Press 1 to confirm the deposit of $" + deposit + ", press any other key to cancel.");
        String userConfirmation = scanner.nextLine();

        if (userConfirmation.equals("1")) {
            System.out.println("Add a description for the deposit: ");
            String deposit_desc = scanner.nextLine();
            System.out.println("Please enter the vendor/person name: ");
            String user_account = scanner.nextLine();
            try {
                Transaction depositTransaction = new Transaction(deposit_desc, user_account, deposit);
                fw.append(depositTransaction.toString());
                System.out.println(depositTransaction);
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } else  {
            System.out.println("Deposit cancelled");
        }
    }

    // TODO(Sarah): copy the above code but just make it for debiting, and the amount needs to be negative.
    public static void makePayment(String fileName) {
    }

    // TODO(Sarah): In main menu, option Ledger needs to have another menu as described by the assignment
    // A - readFullLedger
    // D - readDepositsInLedger
    // P - readPaymentsInLedger (you will have to implement this, it will be very similar to readDepositsInLedger but just negative)
    // R - createReports (just create a new function with all the menu options and we can work on it tomorrow) -- Do this at last
    // H - just leaving the while loop (how we did in Main Menu)
    public static void viewLedger() {

    }

    // TODO(Sarah) - Initiate buffered reader in viewLedger
    public static void readFullLedger(String fileName) {
        ArrayList<Transaction> transactions = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = br.readLine()) != null) {
                Transaction transaction = new Transaction(line);
                transactions.addFirst(transaction);
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error!");
            throw new RuntimeException(e);
        }

        printTransactions(transactions);
    }

    public static void readDepositsInLedger(String fileName) {
        ArrayList<Transaction> transactions = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = br.readLine()) != null) {
                Transaction transaction = new Transaction(line);
                // For readPaymentsInLedger, you will check if the amount is negative (i.e. < 0)
                if (transaction.getAmount() >= 0) {
                    transactions.addFirst(transaction);
                }
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error!");
            throw new RuntimeException(e);
        }

        printTransactions(transactions);
    }

    public static void printTransactions(ArrayList<Transaction> transactions) {
        System.out.println("date|time|description|vendor|amount");
        for (int i = 0 ; i < transactions.size(); i ++) {
            System.out.println(transactions.get(i));
        }
    }

}
