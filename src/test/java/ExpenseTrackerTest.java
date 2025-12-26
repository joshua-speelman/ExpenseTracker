import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class ExpenseTrackerTest {
    @Test
    void newTrackerShouldBeEmpty() {
        // Arrange
        ExpenseTracker tracker = new ExpenseTracker();

        // Act
        boolean result = tracker.isEmpty();

        // Assert
        assertTrue(result, "A new tracker should start empty");
    }

    @Test
    void trackerShouldNotBeEmptyAfterAddingExpense() {
        // Arrange
        ExpenseTracker tracker = new ExpenseTracker();

        // Act
        tracker.addExpense("coffee", 5);

        // Assert
        assertFalse(tracker.isEmpty(), "Tracker should not be empty after adding an expense");
    }

    @Test
    void trackerShouldBeEmptyAfterRemovingExpense() {
        ExpenseTracker tracker = new ExpenseTracker();

        tracker.addExpense("coffee", 5);

        tracker.removeExpense(1);

        assertTrue(tracker.isEmpty(), "Tracker should be empty after removing an expense");
    }

    @Test
    void trackerShouldNotBeEmptyAfterRemovingNonExistingExpense() {
        ExpenseTracker tracker = new ExpenseTracker();

        tracker.addExpense("coffee", 5);

        tracker.removeExpense(1);

        assertFalse(tracker.isEmpty(), "Tracker should be empty after removing an expense");
    }

    @Test
    void trackerShouldGetAllExpenses() {
        ExpenseTracker tracker = new ExpenseTracker();

        tracker.addExpense("coffee", 5);
        tracker.addExpense("coffee2", 10);

        List<Expense> expenses = tracker.getAllExpenses();

        assertEquals(2, expenses.size(), "Tracker should have two expenses");
        assertEquals("coffee", expenses.get(0).getDescription());
        assertEquals(5, expenses.get(0).getPrice());
        assertEquals("coffee2", expenses.get(1).getDescription());
        assertEquals(10, expenses.get(1).getPrice());
    }
}
