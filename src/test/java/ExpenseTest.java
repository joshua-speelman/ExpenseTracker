import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ExpenseTest {

    @Test
    void getPriceGetsPrice() {
        Expense expense = new Expense("Coffee", 8);
        int price = expense.getPrice();
        assertEquals(8, price);
    }

    @Test
    void getDescriptionGetsDescription() {
        Expense expense = new Expense("Coffee", 8);
        String description = expense.getDescription();
        assertEquals("Coffee", description);
    }

    @Test
    void toStringFunctionTrimsCorrectly() {
        Expense expense = new Expense("Coffee", 8);
        String trimmedString = expense.toString();

        assertEquals("Expense: Coffee - ($8)", trimmedString);
    }
}
