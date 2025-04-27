package org.example;

import java.io.*;
import java.util.Scanner;

public class MainLedger {
    static Scanner user_input = new Scanner(System.in);
    static double userCheckingBalance = 2563.04;
    static double userSavingsBalance = 16304.67;
    static FileWriter fr;

    public static void main(String[] args) {
        mainMenu();
    }

    public static void mainMenu() {
        System.out.println(
                "Hello, what would you like to do? \n1. Make Deposit \n2. Make Payment \n3. View Ledger \n4. Exit"); // consider adding a way for the greeting to say good morning based on time of day
        int userMainMenuChoice = user_input.nextInt();
        if (userMainMenuChoice == 1) {
            addDeposit();
        } else if (userMainMenuChoice == 2) {
            makePayment();
        } else if (userMainMenuChoice == 3) {
            viewLedger();
        } else if (userMainMenuChoice == 4) {
            System.out.println("Goodbye, have a wonderful day!");
        } else {
            System.out.println("Error");
        }
    }

    // Methods
    // Add deposit
    // Make payment, pay bills
    // Ledger
    // Exit

    //create the ledger file to view, add transactions and deposits
    // create a way to exit to main menu

    public static void addDeposit() {
        System.out.println("Which account would you like to deposit to? \n1. Checking \n2. Savings \n3. Exit to main menu");
        int userAccountChoice = user_input.nextInt();
        if (userAccountChoice == 1) {
            addDepositToChecking();// depositing to checking
        } else if (userAccountChoice == 2) { // Savings Account
            addDepositToSavings();
        } else if (userAccountChoice == 3) {
            mainMenu();
        }
    }


    public static void addDepositToSavings() {
        System.out.println("Please enter the amount you would like to deposit: ");
        double userSavingsDeposit = user_input.nextDouble();
        System.out.println(
                "Confirm the amount you are depositing: "
                        + userSavingsDeposit
                        + "\nIs this correct? \n1. Yes \n2. No"); // deposit confirmation
        int userConfirmationChoice = user_input.nextInt();
        if (userConfirmationChoice == 1) {
            System.out.println(
                    "Deposit success. Would you like to view your current balance? \n1. Yes \n2. Exit");
            int userEndDepositChoice = user_input.nextInt();
            if (userEndDepositChoice == 1) {
                System.out.println("Your savings account balance is: $" + userSavingsBalance);
                mainMenu();
            } else if (userEndDepositChoice == 2) {
                mainMenu();
            }
        } else if (userConfirmationChoice == 2) { // if deposit was incorrect, go back to line 73
            addDepositToSavings();
        }
    }

    public static void addDepositToChecking() {
        System.out.println("Please enter the amount you would like to deposit:");
        double userCheckingDeposit = user_input.nextDouble();
        System.out.println(
                "Confirm the amount you are depositing: "
                        + userCheckingDeposit
                        + "\nIs this correct?\n1. Yes \n2. No"); // deposit confirmation
        int userConfirmationChoice = user_input.nextInt();
        if (userConfirmationChoice == 1) {
            System.out.println(
                    "Deposit success. Would you like to view your current balance? \n1. Yes \n2. Exit");
            int userEndDepositChoice = user_input.nextInt();
            if (userEndDepositChoice == 1) {
                System.out.println("Your checking account balance is: $" + userCheckingBalance);
                mainMenu();
            } else {
                mainMenu();
            }
        } else if (userConfirmationChoice == 2) {
            addDepositToChecking();
        }
    }

    public static void makePayment() {
        System.out.println(
                "Please select the account in which to make a payment: \n1. Credit Card \n2. Car Payment \n3. Exit");
        int user_acc_select = user_input.nextInt();

        if (user_acc_select == 1) { // CC payment
            makeCCBillPayment();
        } else if (user_acc_select == 2) { // Car Payment
            makeCarPayment();
        } else if (user_acc_select == 3) { // Main Menu
            mainMenu();
        }
    }

    public static void makeCCBillPayment() {
        double creditCardBill = 206.74;
        System.out.println("Please enter the payment amount: ");
        double user_payment_CC = user_input.nextDouble();
        System.out.println(
                "Confirm the amount you are depositing: "
                        + user_payment_CC
                        + "\nIs this correct?\n1. Yes \n2. No"); // deposit confirmation
        int user_payment_confirmation = user_input.nextInt();
        if (user_payment_confirmation == 1) {
            System.out.println("Remaining Balance: $" + (creditCardBill - user_payment_CC));
            mainMenu(); // add way to round to the nearest 100th decimal
        } else if (user_payment_confirmation == 2) {
            makeCCBillPayment();
        } else {
            mainMenu();
        }
    }

    public static void makeCarPayment() {
        double carPayment = 8035.43;
        System.out.println("Please enter the payment amount: ");
        double user_payment_CP = user_input.nextDouble();
        System.out.println(
                "Confirm the amount you are depositing: "
                        + user_payment_CP
                        + "\nIs this correct?\n1. Yes \n2. No"); // deposit confirmation
        int user_payment_confirmation = user_input.nextInt();
        if (user_payment_confirmation == 1) {
            System.out.println("Remaining Balance: $" + (carPayment - user_payment_CP));
            mainMenu();
        } else if (user_payment_confirmation == 2) {
            makeCarPayment();
        } else {
            mainMenu();
        }

    }

    public static void viewLedger() {
        System.out.println("Which account ledger would you like to view? \n1. Checking \n2. Savings \n3. Exit to Main Menu");
        int viewLedgerChoice = user_input.nextInt();
        if (viewLedgerChoice == 1) {
            //input file reader for checking ledger
            System.out.println(
                    "Your balance is: $"
                            + userCheckingBalance
                            + "\nWhat would you like to do? \n1. View Another Ledger \n2. Exit");
        } else if (viewLedgerChoice == 2) {
            //input file reader for savings ledger
            System.out.println(
                    "Your balance is: $"
                            + userSavingsBalance
                            + "\nWhat would you like to do? \n1. View Another Ledger \n2. Exit");
        } else if (viewLedgerChoice == 3) {
            mainMenu();
        }
    }
}



