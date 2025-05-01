package org.example;

import java.io.*;
import java.util.Scanner;


public class MainMenu {
    static Scanner scanner = new Scanner(System.in);
    static String fileName = "practice.csv";

    public static void main(String[] args) throws IOException {
        homeScreen();
    }

    public static void homeScreen() throws IOException {
        boolean continueApp = true;
        while (continueApp) {
            System.out.println("Hello, please select from the following options:\n----------------\nD) Add Deposit\nP) Make Payment(Debit)\nL) Ledger\nX) Exit\n");
            String user_choice = scanner.next().toLowerCase();
            switch (user_choice) {
                case "d":
                    Ledger.makeDeposit(fileName);
                    break;
                case "p":
                    Ledger.makePayment(fileName);
                    break;
                case "l":
                    ledgerMenuScreen();
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

    public static void ledgerMenuScreen() {
        // TODO(Sarah): In main menu, option Ledger needs to have another menu as described by the assignment
// A - readFullLedger
// D - readDepositsInLedger
// P - readPaymentsInLedger
// R - createReports (just create a new function with all the menu options and we can work on it tomorrow) -- Do this at last
// H - just leaving the while loop (how we did in Main Menu)

        boolean continueApp = true;
        while (continueApp) {
            System.out.println("Ledger Screen\n-----------\nPlease select from the following options:\nA) Read full ledger\nD) Read deposits in ledger\nP) Read payments in ledger\nR) Generate reports\nH) Back to home\n");
            String user_choice = scanner.next().toLowerCase();
            switch (user_choice) {
                case "a":
                    Ledger.readFullLedger(fileName);
                    break;
                case "d":
                    Ledger.readDepositsInLedger(fileName);
                    break;
                case "p":
                    Ledger.readPaymentsInLedger(fileName);
                    break;
                case "r":
                    Ledger.createReports(fileName);
                    break;
                case "h":
                    continueApp = false;
                    break;
            }
        }
    }
}




