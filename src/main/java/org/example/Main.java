package org.example;
import java.io.*;
import java.util.Scanner;

public class Main {
    static Scanner user_input = new Scanner(System.in);
    static double userCheckingBalance = 2563.04;
    static double userSavingsBalance = 16304.67;
    static FileWriter fr;

    static {
        try {
            fr = new FileWriter("ledger.txt");
        } catch (IOException e) {
            throw new RuntimeException(e); // this process was automatic from intelliJ
        }
    }

    public static void main(String[] args) {
        System.out.println(
                "Hello, what would you like to do? \n1. Make Deposit \n2. Make Payment \n3. View Ledger \n.4 Exit"); // consider adding a way for the greeting to say good morning based on time of day
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
        System.out.println("Which account would you like to deposit to? \n1. Checking \n2. Savings");
        // have an option for checking and savings

        int userAccountChoice = user_input.nextInt();
        if (userAccountChoice == 1) { // depositing to checking
            System.out.println("Please enter the amount you would like to deposit:");
            double userDeposit = user_input.nextDouble();
            System.out.println(
                    "Confirm the amount you are depositing: "
                            + userDeposit
                            + "\nIs this correct?\n1. Yes \n2. No"); // deposit confirmation
            int userConfirmationChoice = user_input.nextInt();
            if (userConfirmationChoice == 1) {
                System.out.println(
                        "Deposit success. Would you like to view your current balance? \n1. Yes \n2. Exit");
                int userEndDepositChoice = user_input.nextInt();
                if (userEndDepositChoice == 1) {
                    System.out.println(
                            "Your balance is: $"
                                    + userCheckingBalance
                                    + "\nWhat would you like to do? \n1. Make another deposit \n2. Exit");
                } else if (userEndDepositChoice == 2) {
                    break;      // exit to main menu
                }
            } else if (userConfirmationChoice == 2) { // if deposit was incorrect
                break;        //go back to depositing to checking on line 48
            }

        } else if (userAccountChoice == 2) { // Savings Account
            System.out.println("Please enter the amount you would like to deposit:");
            double userDeposit = user_input.nextDouble();
            System.out.println(
                    "Confirm the amount you are depositing: "
                            + userDeposit
                            + "\nIs this correct? \n1. Yes \n2. No"); // deposit confirmation
            int userConfirmationChoice = user_input.nextInt();
            if (userConfirmationChoice == 1) {
                System.out.println(
                        "Deposit success. Would you like to view your current balance? \n1. Yes \n2. Exit");
                int userEndDepositChoice = user_input.nextInt();
                if (userEndDepositChoice == 1) {
                    System.out.println(
                            "Your balance is: $"
                                    + userSavingsBalance
                                    + "\nWhat would you like to do? \n1. Make another deposit \n2. Exit");
                } else if (userEndDepositChoice == 2) {
                    break; // exit to main menu
                }
            } else if (userConfirmationChoice == 2) { // if deposit was incorrect, go back to line 73
                break;
            }
        }
    }

    public static void makePayment() {
        System.out.println(
                "Please select the account in which to make a payment: \n1. Credit Card \n2. Car Payment \n3. Exit");
        int user_acc_select = user_input.nextInt();
        if (user_acc_select == 1) { // Credit Card option
            double creditCardBill = 206.74;
            System.out.println(
                    "What would you like to do? \n1. Make a Payment \n2. View Balance \n3. View Transaction History \n4. Exit"); // Credit Card Menu
            int user_op_select = user_input.nextInt();
            if (user_op_select == 1) { // CC payment
                System.out.println("Please enter the payment amount: ");
                double user_payment_CC = user_input.nextDouble();
                System.out.println("Remaining Balance: $" + (creditCardBill - user_payment_CC));
            }
            if (user_op_select == 2) { // CC View Balance
                System.out.println("The balance is currently: $" + creditCardBill);
            }
            if (user_op_select == 3) { // view transaction history
            }
            if (user_op_select == 4) { // exit to main menu
                break;
            }
        }
        // make if loop for car payment
        if (user_acc_select == 2) { // Car Payment Option
            double carPayment = 8035.43;
            System.out.println(
                    "What would you like to do? \n1. Make a Payment \n2. View Balance \n3. View Transaction History \n4. Exit");
            int user_op_select2 = user_input.nextInt();
            if (user_op_select2 == 1) { // CP payment
                System.out.println("Please enter the payment amount: ");
                double user_payment_CP = user_input.nextDouble();
                System.out.println("Remaining Balance: $" + (carPayment - user_payment_CP));
            }
            if (user_op_select2 == 2) { // CP View Balance
                System.out.println("The balance is currently: $" + carPayment);
            }
            if (user_op_select2 == 3) {
                // view transaction history
            }
            if (user_op_select2 == 4) { // exit to main menu
                break;
            }
        }
    }

    public static void viewLedger() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("ledger.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println(fr);
    }
}