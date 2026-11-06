# Applications Ledger Application

This is a Java ClI  application built for Capstone Project 1. 

# The application is made up of three main screens:

1)Home Screen: Gives the user the choice to add a deposit, make a payment, open the Ledger, or exit the application.

2)Ledger Screen: Lists all entries from newest to oldest and lets the user filter the view by All, Deposits, Payments, or Reports.
public class Ledger {
    public static java.util.Scanner scanner = Main.scanner;

3)The Reports screen offers pre-defined reports, including Month to Date, Previous Month, Year to Date, Previous Year, and Search by Vendor. If the user enters a value for a search field, the application filters on that field.




    public static void ledgerMenu() {
        boolean done = false;
        while (!done) {
            System.out.println("""
                    Ledger Menu:
                    [A] - All Entries
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
    public static void ledgerMenu() { // This method displays the ledger menu options for user to choose from and calls other methods based on selection
        boolean display = true;
        while (display) {
            System.out.println("""
                    Ledger Menu:
                    [A] - All Entries
                    [D] - Deposits
                    [P] - Payments
                    [R] - Reports
                    [H] - Home""");
            String input = scanner.nextLine();
            switch (input.toUpperCase()) {
                case "A" -> showEntries("Entries"); // Display all transactions
                case "D" -> showEntries("Deposits"); // Display only deposits
                case "P" -> showEntries("Payments"); // Display only payments
                case "R" -> reportsMenu(); // Go to the Reports menu
                case "H" -> display = false; // Exit to Main menu
                default -> System.out.println("Please enter a valid option");
            } public static void reportsMenu() { // This method displays menu of queries for different reports
        boolean done = false;
        while (!done) {
            System.out.println("""
                    Reports Menu:
                    [1] - Month To Date
                    [2] - Previous Month
                    [3] - Year To Date
                    [4] - Previous Year
                    [5] - Search By Vendor
                    [6] - Custom Search
                    [0] - Back""");
}
# Difficult piece of code 



















}