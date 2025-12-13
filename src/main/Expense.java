package main;

public class Expense {

    private final String description;
    private final int price;

    public int getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public Expense(String description, int price) {
        this.description = description;
        this.price = price;
    }
    // need to add some behaviours
    @Override
    public String toString() {
        return "Expense: " + description + " - ($" + price + ")";
    }

}
