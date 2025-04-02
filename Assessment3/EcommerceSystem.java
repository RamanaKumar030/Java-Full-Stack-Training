package DAY3;

import java.util.*;

public class EcommerceSystem {
    public static void main(String[] args) {
        String[] products = {"Laptop", "Phone", "Tablet"};
        int[] prices = {1000, 800, 500};

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter product index (0-2): ");
            int index = scanner.nextInt(); // May throw InputMismatchException or ArrayIndexOutOfBoundsException

            System.out.print("Enter quantity: ");
            int quantity = scanner.nextInt();

            int totalCost = prices[index] * quantity;
            System.out.println("Order placed: " + products[index] + " x" + quantity + " for $" + totalCost);

        } catch (InputMismatchException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid input! " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("Calculation error! " + e.getMessage());
        } finally {
            scanner.close();
            System.out.println("Thank you for shopping with us!");
        }
    }
}

