package com.pluralsight;

import java.util.Comparator;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;



public class Ledger {
    public static Scanner scanner = Main.scanner;

    public static void ledgerMenu() {
        boolean done = false;
        while (!done) {
            System.out.println("""
                    Ledger Menu:
                    [A] - All Entires
                    [D] - Deposits 
                    [P] - Payments
                    [R] - Reports
                    [H] - Home """);
            String input = scanner.nextLine();
            switch (input.toUpperCase()) {
                case "A" -> System.out.println("All coming soon");
                case "D" -> System.out.println("Deposits coming soon");
                case "P" -> System.out.println("Payments coming soon");
                case "R" -> System.out.println("Reports coming soon");
                case "H" -> done = true;
                default -> System.out.println("Please enter a valid option");

            }

            }

        }
    }
public static ArrayList<Transactions> transactions = new ArrayList<>();

// Reads transactions.csv and returns a list of Transactions objects
public static ArrayList<Transactions> getTransactions() {
    ArrayList<Transactions> list = new ArrayList<>();

    try (BufferedReader bufReader = new BufferedReader(new FileReader("transactions.csv"))) {
        String input;
        while ((input = bufReader.readLine()) != null) { // for every line until there are no more lines
            if (input.isBlank() || input.startsWith("date")) {
                continue; // skip empty lines and the header row
            }
            try {
                String[] details = input.split("\\|"); // cut the line into its 5 pieces
                LocalDate date = LocalDate.parse(details[0]);
                LocalTime time = LocalTime.parse(details[1]);
                String description = details[2];
                String vendor = details[3];
                double amount = Double.parseDouble(details[4]);

                list.add(new Transactions(date, time, description, vendor, amount));
            } catch (Exception e) {
                System.out.println("Skipping a bad line in the file: " + input);
            }
        }
    } catch (IOException e) {
        System.out.println("File Not Found!");
    }
    // Newest first: sort by date, then by time, and flip the order
    list.sort(Comparator.comparing(Transactions::getDate)
            .thenComparing(Transactions::getTime)
            .reversed());
    return list;





















}



