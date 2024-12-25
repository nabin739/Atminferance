import java.util.Scanner;

public class ATM{
    private double balance;
    private final Scanner scanner;

    // Constructor to initialize the ATM
    public ATM(double initialBalance) {
        this.balance = initialBalance;
        this.scanner = new Scanner(System.in);
    }

    // Display the menu options
    private void displayMenu() {
        System.out.println("\n==== ATM Menu ====");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    // Check the current balance
    private void checkBalance() {
        System.out.printf("Your current balance is: $%.2f%n", balance);
    }

    // Deposit money into the account
    private void depositMoney() {
        System.out.print("Enter the amount to deposit: $");
        double amount = scanner.nextDouble();

        if (amount > 0) {
            balance += amount;
            System.out.printf("$%.2f has been deposited into your account.%n", amount);
        } else {
            System.out.println("Invalid deposit amount. Please try again.");
        }
    }

    // Withdraw money from the account
    private void withdrawMoney() {
        System.out.print("Enter the amount to withdraw: $");
        double amount = scanner.nextDouble();

        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.printf("$%.2f has been withdrawn from your account.%n", amount);
        } else if (amount > balance) {
            System.out.println("Insufficient balance. Please try a smaller amount.");
        } else {
            System.out.println("Invalid withdrawal amount. Please try again.");
        }
    }

    // Run the ATM simulation
    public void run() {
        boolean running = true;

        while (running) {
            displayMenu();

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    depositMoney();
                    break;
                case 3:
                    withdrawMoney();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }

        scanner.close();
    }

    // Main method to start the application
    public static void main(String[] args) {
        ATM atm = new ATM(500.0); // Initialize ATM with $500 balance
        atm.run();
    }
}
