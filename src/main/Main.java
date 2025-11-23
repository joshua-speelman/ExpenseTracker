package main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("main.Expense Tracker is booting, please hold ...\n");
        System.out.print("===============================================\n\n");

        boolean appIsRunning = true;

        while (appIsRunning) {
            // menu design
            System.out.println("== Expense Tracker ==");
            System.out.println("1. Add new expense");
            System.out.println("2. Show all expenses");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            // kicking off the expensetracker object (which contains expenses)
            ExpenseTracker tracker = new ExpenseTracker();

            // waiting for user input
            Scanner scanner = new Scanner(System.in);

            // reading an integer for the menu choice
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    // add new expense
                    System.out.print("Enter description: ");
                    String description = scanner.nextLine();

                    int price = 0;
                    boolean validAmount = false;

                    while (!validAmount) {
                        System.out.print("Enter amount: ");
                        String input = scanner.nextLine().replace("$", "").trim();

                        try {
                            price = Integer.parseInt(input);
                            validAmount = true;
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid number! Please enter a number (e.g., 5 or $5)!");
                        }
                    }
                    tracker.addExpense(description, price);
                    break;
                case 2:
                    // show all expenses
                    tracker.showExpenses();
                    break;
                case 0:
                    // exit
                    appIsRunning = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}