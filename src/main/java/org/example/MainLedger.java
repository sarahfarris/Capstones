package org.example;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;


public class MainLedger {
    static FileWriter fr;
    static BufferedReader br;
    static Scanner scanner = new Scanner(System.in);
    static LocalDate ld = LocalDate.now();
    static LocalTime lt = LocalTime.now();
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH-mm");
    static String formattedTime = lt.format(formatter);
    static File inventoryLedger = new File("practice.csv"); //pathway to file

    public static void main(String[] args) throws IOException {
        homeScreen();
    }


    public static void homeScreen() throws IOException {
        boolean continueApp = true;
        while (continueApp) {
            System.out.println("Hello, please select from the following options:\n----------------\nD) Add Deposit\nP) Make Payment\nL) Ledger\nX) Exit");
            String user_choice = scanner.next().toLowerCase();
            switch (user_choice) {
                case "d":
                    makeDeposit();
                    break;
                case "p":
                    makePayment();
                    break;
                case "l":
                    readLedger();
                    break;
                case "x":
                    continueApp = false;
                    break;
                default:
                    System.out.println("Invalid input. Please try again.");
                    break;
            }
        }
    }

    public static void readLedger() throws IOException {
        try {
            br = new BufferedReader(new FileReader(inventoryLedger));
        } catch (FileNotFoundException e) {
            System.out.println("Error loading Reader!");
            throw new RuntimeException(e);
        }
        try {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        br.close();
    }


    // TODO(Sarah): Copy this and make other functions for makePayments with their corresponding messages.
    public static void makeDeposit() throws IOException {

        try {
            // if file exits, add to it, if not, create new
            if (inventoryLedger.exists()) {
                fr = new FileWriter(inventoryLedger, true);
            } else {
                fr = new FileWriter(inventoryLedger);
            }
        } catch (IOException e) {
            System.out.print("Error loading Ledger!");
            throw new RuntimeException(e);
        }

        boolean addToLedger = true;
        while (addToLedger) {
            addDepositToLedger();
            System.out.println("Would you like to make another deposit?\n1. Yes\nAny other key: Exit to main menu");
            int user_choice = scanner.nextInt();
            scanner.nextLine();
            if (user_choice != 1) {
                addToLedger = false;
                System.out.println("Returning to main menu.");
            }
        }
        if (fr != null) {
            fr.close();
        }
    }

    public static void addDepositToLedger() {
        double deposit = 0; //placeholder variable so it can be within scope
        int user_confirmation = 0;
        String user_account = scanner.nextLine();
        System.out.println("Enter the amount you wish to deposit: ");
        deposit = scanner.nextDouble();
        scanner.nextLine(); //added consume line as advised

        System.out.println("Press 1 to confirm the deposit of $" + deposit + ", press any other key to cancel.");
        user_confirmation = scanner.nextInt();
        scanner.nextLine(); //added this block of text as advised

        if (user_confirmation == 1) {
            System.out.println("Add a description for the deposit: ");
            String deposit_desc = scanner.nextLine();
            System.out.println("Please enter the vendor/person name: ");
            user_account = scanner.nextLine();
            try {
                String formattedTime = lt.format(formatter);
                // TODO(Sarah): Use a StringBuilder here
                fr.append(ld + "|" + formattedTime + "|" + deposit_desc + "|" + user_account + "|" + deposit + "\n");
                System.out.println("Deposit Information: " + ld + "|" + formattedTime + "|" + deposit_desc + "|" + user_account + "|" + deposit);
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } else if (user_confirmation == 2) {
            System.out.println("Deposit cancelled");
        }
    }

    public static void makePayment() {
    }
}




