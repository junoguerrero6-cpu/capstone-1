package com.pluralsight;



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
                case "B" -> System.out.println("Deposits coming soon");
                case "P" -> System.out.println("Payments coming soon");
                case "R" -> System.out.println("Reports coming soon");
                case "H" -> done = true;
                default -> System.out.println("Please enter a valid option");





            }
        }
    }
}
