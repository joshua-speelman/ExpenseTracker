import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

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
}
