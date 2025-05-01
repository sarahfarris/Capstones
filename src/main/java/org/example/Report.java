package org.example;

import java.time.LocalDate;
import java.util.ArrayList;

public class Report {

    public static void byMonthToDate(ArrayList<Transaction> transactions) {
        ArrayList<Transaction> monthToDateTransactions = new ArrayList<>();
        LocalDate today = LocalDate.now();
        LocalDate startOfMonth = today.withDayOfMonth(1);

        for (int i = 0; i < transactions.size(); i++) {
            LocalDate transactionDate = transactions.get(i).getDate();
            if (!transactionDate.isBefore(startOfMonth) && !transactionDate.isAfter(today)) {
                monthToDateTransactions.add(transactions.get(i));
            }
        }

        printTransactions(monthToDateTransactions);
    }

    public static void byPreviousMonth(ArrayList<Transaction> transactions) {
        ArrayList<Transaction> previousMonthTransactions = new ArrayList<>();
        LocalDate today = LocalDate.now();
        LocalDate startOfPreviousMonth = today.minusMonths(1).withDayOfMonth(1);
        LocalDate endOfPreviousMonth = today.minusMonths(1).withDayOfMonth(today.minusMonths(1).lengthOfMonth());

        for (int i = 0; i < transactions.size(); i++) {
            LocalDate transactionDate = transactions.get(i).getDate();
            if (!transactionDate.isBefore(startOfPreviousMonth) && !transactionDate.isAfter(endOfPreviousMonth)) {
                previousMonthTransactions.add(transactions.get(i));
            }
        }

        printTransactions(previousMonthTransactions);
    }

    public static void byYearToDate(ArrayList<Transaction> transactions) {
        ArrayList<Transaction> yearToDateTransactions = new ArrayList<>();
        LocalDate today = LocalDate.now();
        LocalDate startOfYear = today.withDayOfYear(1);

        for (int i = 0; i < transactions.size(); i++) {
            LocalDate transactionDate = transactions.get(i).getDate();
            if (!transactionDate.isBefore(startOfYear) && !transactionDate.isAfter(today)) {
                yearToDateTransactions.add(transactions.get(i));
            }
        }

        printTransactions(yearToDateTransactions);
    }

    public static void byPreviousYear(ArrayList<Transaction> transactions) {
        ArrayList<Transaction> previousYearTransactions = new ArrayList<>();
        LocalDate today = LocalDate.now();
        LocalDate startOfPreviousYear = today.minusYears(1).withDayOfYear(1);
        LocalDate endOfPreviousYear = today.minusYears(1).withDayOfYear(today.minusYears(1).lengthOfYear());

        for (int i = 0; i < transactions.size(); i++) {
            LocalDate transactionDate = transactions.get(i).getDate();
            if (!transactionDate.isBefore(startOfPreviousYear) && !transactionDate.isAfter(endOfPreviousYear)) {
                previousYearTransactions.add(transactions.get(i));
            }
        }

        printTransactions(previousYearTransactions);
    }

    public static void byVendor(ArrayList<Transaction> transactions, String vendor) {
        ArrayList<Transaction> transactionsByVendors = new ArrayList<>();

        for (int i = 0; i < transactions.size(); i++) {
            if (transactions.get(i).getVendor().equals(vendor)) {
                transactionsByVendors.add(transactions.get(i));
            }
        }

        printTransactions(transactionsByVendors);
    }

    private static void printTransactions(ArrayList<Transaction> transactions) {
        if (transactions.isEmpty()) {
            System.out.println("No transactions found!");
            return;
        }
        System.out.println("date|time|description|vendor|amount");
        for (int i = 0; i < transactions.size(); i++) {
            System.out.println(transactions.get(i));
        }
    }
}
