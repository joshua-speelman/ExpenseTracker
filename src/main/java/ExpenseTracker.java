import java.util.ArrayList;
import java.util.List;

public class ExpenseTracker {

    private final ArrayList<Expense> listOfExpenses = new ArrayList<>();

    public boolean isEmpty() {
        return listOfExpenses.isEmpty();
    }

    public void addExpense(String description, int price) {
        Expense expense = new Expense(description, price);
        listOfExpenses.add(expense);
    }

    public boolean removeExpense(int index) {
        if (listOfExpenses.isEmpty()) {
            return false;
        }
        if (index < 1 || index > listOfExpenses.size()) {
            return false;
        }
        listOfExpenses.remove(index - 1);
        return true;
    }

    public List<Expense> getAllExpenses() {
        return new ArrayList<>(listOfExpenses);
    }

    public int getTotal() {
        int total = 0;
        for (Expense e : listOfExpenses) {
            total += e.getPrice();
        }
        return total;
    }
}