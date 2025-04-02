package DAY3;

// Custom Checked Exception for insufficient funds
class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

// Bank Account class
class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    // Deposit method (throws Unchecked Exception)
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive.");
        }
        balance += amount;
        System.out.println("Deposited: $" + amount);
    }

    // Withdraw method (throws Checked Exception)
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds! Balance: $" + balance);
        }
        balance -= amount;
        System.out.println("Withdrawn: $" + amount);
    }

    public double getBalance() {
        return balance;
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(500);

        try {
            account.deposit(200);
            account.withdraw(800); // Should throw InsufficientFundsException
        } catch (InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Handling Unchecked Exception
        try {
            account.deposit(-50); // Should throw IllegalArgumentException
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("Final Balance: $" + account.getBalance());
    }
}

