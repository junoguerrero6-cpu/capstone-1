package com.pluralsight;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Ledger {
    public static Scanner scanner = new Scanner(System.in); // Initialize a global scanner to avoid redundant Scanner declarations
    public static ArrayList<Transaction> transactions = getTransactions(); // Initialize global array and inherit transactions from getTransactions method

    public static ArrayList<Transaction> getTransactions() { // This method reads transactions from a CSV file and stores them in an ArrayList of Transaction objects
        ArrayList<Transaction> transactions = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader("transactions.csv");
            BufferedReader bufReader = new BufferedReader(fileReader);

            String input;
            while ((input = bufReader.readLine()) != null) { // For every line in the csv file until no more lines:
                String[] details = input.split("\\|"); // split the line into pieces to extract and store info from each piece
                LocalDate date = LocalDate.parse(details[0]);
                LocalTime time = LocalTime.parse(details[1]);
                String description = details[2];
                String vendor = details[3];
                double amount = Double.parseDouble(details[4]);

                // Create a transaction object using the pieces we extracted and populate our ArrayList of transactions
                Transaction transaction = new Transaction(date, time, description, vendor, amount);
                transactions.add(transaction);
            }
        } catch (IOException e) {
            System.out.println("File Not Found!");
            System.exit(0);
        }


        return transactions;
    }
    public static void ledgerMenu() { // This method displays the ledger menu options for user to choose from and calls other methods based on selection
        boolean display = true;
        while (display) {
            System.out.println("""
                    Ledger Menu:
                    [A] - All Entries
                    [D] - Deposits
                    [P] - Payments
                    [H] - Home""");
            String input = scanner.nextLine();
            switch (input.toUpperCase()) {
                case "A" -> showEntries("Entries"); // Display all transactions
                case "D" -> showEntries("Deposits"); // Display only deposits
                case "P" -> showEntries("Payments"); // Display only payments
                case "H" -> display = false; // Exit to Main menu
                default -> System.out.println("Please enter a valid option");
            }
        }
    }

    public static void showEntries(String filter) { // This method loops through transactions ArrayList and displays transactions based on filter from above menu
        boolean filterType = true; // Show all transactions by default
        System.out.printf("%50s %s\n\n", "All ", filter); printTitles();
        for (Transaction item : transactions) {
            if (filter.equals("Deposits")) {
                filterType = item.getAmount() > 0;
            } else if (filter.equals("Payments")) {
                filterType = item.getAmount() < 0;
            }

            if (filterType) { // print out corresponding transactions based on filterType
                printTransaction(item);
            }
        }
        System.out.println();
    }
    public static void printTitles() {
        System.out.printf("%-15s %-15s %-30s %-25s %15s\n\n",
                "Date:",
                "Time:",
                "Description:",
                "Vendor:",
                "Amount:"
        );
    }

    private static void printTransaction(Transaction item) { // print method to avoid redundant print calls
        System.out.printf("%-15s %-15s %-30s %-25s %15.2f\n",
                item.getDate(),
                item.getTime().format(DateTimeFormatter.ofPattern("HH:mm:ss")),
                item.getDescription(),
                item.getVendor(),
                item.getAmount()
        );
    }

    private static LocalDate getDateFromCLI() { // if no date inputted set LocalDate variable to null, else: store date
        String input = scanner.nextLine();
        return input.equals("") ? null : LocalDate.parse(input);
    }
}