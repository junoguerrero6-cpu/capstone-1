package com.pluralsight;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Greetings , Welcome To Your Finance Account ");
        homescreen();

    }

    public static void homescreen() { // print the homescreen
        boolean done = false;
        while(!done){
            System.out.println("""
                    Main Menu:
                    [D] - Add Deposit
                    [P] - Make Payment
                    [L] - Ledger
                    [X] - Exit""");

            String input = scanner.nextLine();
            switch (input.toUpperCase()) {
                case "D" -> addEntry("Deposit");
                case "P" -> addEntry("Payment");
                case "L" -> Ledger.ledgerMenu();
                case "X" -> {System.out.println("Logging Off..."); done = true;}
                default -> System.out.println("Please enter a valid option");
            }
        }
                 
    }


}