package main;

import java.util.ArrayList;

public class ExpenseTracker {

    // addExpense(description, price) - done
    // showExpenses() - done
    // getTotal()
    // Remove an expense or export?

    private final ArrayList<Expense> listOfExpenses = new ArrayList<>();

    public boolean isEmpty() {
        return listOfExpenses.isEmpty();
    }

    // can i add duplicate expenses? if it's the same name, should it just add to the total, or a counter next to the name?
    public void addExpense(String description, int price) {
        Expense expense = new Expense(description, price);
        listOfExpenses.add(expense);
    }

    // what happens if there's no expenses?
    public void showExpenses() {
        if (listOfExpenses.isEmpty()) {
            System.out.println("No expenses recorded yet.");
        } else {
            System.out.println("Expenses:");
            for (Expense e : listOfExpenses) {
                System.out.println(e);
            }
        }
    }

//    goal: Implement getTotal()
//    what it does: gets the total price of all the expenses
//    conceptually:
//            - i want to go through all the Expense objects stored in listOfExpenses.
//            - for each one, take its price and cumulatively add it to a variable called total
//            - after looping through all of them, return or print that total.
//
//    it's just aggregating numeric data from the collection really
//    think SQL (SELECT SUM(price))

    public int getTotal() {
        int total = 0;
        for (Expense e : listOfExpenses) {
            total += e.getPrice();
        }
        return total;
    }
}
