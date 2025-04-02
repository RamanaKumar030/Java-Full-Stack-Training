package DAY3;

import java.util.Scanner;

class ATM {
    private double balance;

    public ATM(double balance) {
        this.balance = balance;
    }

    public void withdraw(double amount) {
        try {
            if (amount <= 0) {
                throw new IllegalArgumentException("Invalid withdrawal amount!");
            }
            if (amount > balance) {
                throw new Exception("Insufficient funds!");
            }

            balance -= amount;
            System.out.println("Withdrawal successful. Remaining balance: $" + balance);
        } catch (IllegalArgumentException e) {
            System.out.println("Input Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Transaction Error: " + e.getMessage());
        }
    }
}

public class ATMSimulator {
    public static void main(String[] args) {
        ATM atm = new ATM(1000);
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter amount to withdraw: ");
            double amount = scanner.nextDouble();

            try {
                atm.withdraw(amount);
            } catch (Exception e) {
                System.out.println("Nested Catch: " + e.getMessage());
            }

        } catch (Exception e) {
            System.out.println("Input Error: Please enter a valid amount.");
        } finally {
            scanner.close();
            System.out.println("Thank you for using the ATM!");
        }
    }
}
