# Applications Ledger Application

This is a Java ClI  application built for Capstone Project 1. 

# The application is made up of four main screens:

1)Home Screen: Gives the user the choice to add a deposit, make a payment, open the Ledger, or exit the application.

2)Ledger Screen: Lists all entries from newest to oldest and lets the user filter the view by All, Deposits, Payments, or Reports.
public class Ledger {
    public static java.util.Scanner scanner = Main.scanner;

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
}