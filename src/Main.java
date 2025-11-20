import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Expense Tracker is booting, please hold ...\n");
        System.out.print("===============================================\n\n");

        Scanner scanner = new Scanner(System.in);

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

        Expense expense = new Expense("General", description, price);
        System.out.print("You entered: " + expense);
    }
}