public class Expense {

    private String choice;
    private final String description;
    private final int price;

    public Expense(String choice, String description, int price) {
        this.choice = choice;
        this.description = description;
        this.price = price;
    }
    // need to add some behaviours
    @Override
    public String toString() {
        return "Expense: " + description + " - ($" + price + ")";
    }

}
