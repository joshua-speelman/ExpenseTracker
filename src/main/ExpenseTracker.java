package main;

import java.util.ArrayList;

public class ExpenseTracker {

    // addExpense(description, price)
    // showExpenses()
    // getTotal()
    // Remove an expense or export?

    private final ArrayList<Expense> listOfExpenses = new ArrayList<>();

    public void addExpense(String description, int price) {
        Expense expense = new Expense(description, price);
        listOfExpenses.add(expense);
    }

    public void showExpenses() {
        for (Expense e : listOfExpenses) {
            System.out.println(e);
        }
    }


}
