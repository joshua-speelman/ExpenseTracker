package main;

import java.util.List;
import java.util.Scanner;
import static java.lang.System.out;

public class Main {
    public static void main(String[] args) {
        out.print("Expense Tracker is booting, please hold ...\n");
        out.print("===============================================\n\n");

        boolean appIsRunning = true;
        ExpenseTracker tracker = new ExpenseTracker();
        Scanner scanner = new Scanner(System.in);

        while (appIsRunning) {
            System.out.println("\n== Expense Tracker ==");
            System.out.println("1. Add new expense");
            System.out.println("2. Show all expenses");
            System.out.println("3. Remove expense");
            System.out.println("4. Show total");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> {
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
                    System.out.println("Expense added.");
                }

                case 2 -> {
                    List<Expense> expenses = tracker.getAllExpenses();
                    if (expenses.isEmpty()) {
                        System.out.println("No expenses recorded yet.");
                    } else {
                        System.out.println("Expenses:");
                        int i = 1;
                        for (Expense e : expenses) {
                            System.out.println(i + ". " + e);
                            i++;
                        }
                    }
                }

                case 3 -> {
                    List<Expense> expenses = tracker.getAllExpenses();
                    if (expenses.isEmpty()) {
                        System.out.println("There are no expenses to remove!");
                    } else {
                        System.out.println("Expenses:");
                        int i = 1;
                        for (Expense e : expenses) {
                            System.out.println(i + ". " + e);
                            i++;
                        }
                        System.out.print("Enter the number of the expense to remove: ");
                        int index = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println("Are you sure you want to delete this expense?");
                        System.out.println("1 - Yes");
                        System.out.println("2 - No");
                        int confirm = scanner.nextInt();
                        scanner.nextLine();

                        if (confirm == 1) {
                            boolean success = tracker.removeExpense(index);
                            if (success) System.out.println("Expense removed.");
                            else System.out.println("Invalid selection. No expense removed.");
                        } else {
                            System.out.println("Cancelled deletion.");
                        }
                    }
                }

                case 4 -> {
                    if (tracker.isEmpty()) {
                        System.out.println("No expenses recorded yet!");
                    } else {
                        int total = tracker.getTotal();
                        System.out.println("Total: $" + total);
                    }
                }

                case 5 -> {
                    appIsRunning = false;
                    System.out.println("Exiting...");
                }

                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }
}