import java.util.Scanner;

public class MiniATM {

    // Account balance (shared for the session)
    static double balance = 0.0;

    // Default PIN
    static int pin = 1234;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Menu loop keeps ATM running until user exits
        while (true) {
            System.out.println("\n1) Deposit");
            System.out.println("2) Withdraw");
            System.out.println("3) Check Balance");
            System.out.println("4) Change PIN");
            System.out.println("5) Exit");
            System.out.print("Enter option: ");

            // Validate menu input
            if (!sc.hasNextInt()) {
                sc.next();      // discard invalid input
                continue;       // retry menu
            }

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    deposit(sc);
                    break;

                case 2:
                    withdraw(sc);
                    break;

                case 3:
                    printBalance();
                    break;

                case 4:
                    changePin(sc);
                    break;

                case 5:
                    System.out.println("Thank you for using the ATM.");
                    break;

                default:
                    // Invalid menu choice
                    continue;
            }

            // Exit condition
            if (choice == 5) {
                break;
            }
        }

        sc.close();
    }

    /**
     * Deposits money into the account.
     * Negative or zero amounts are not allowed.
     */
    static void deposit(Scanner sc) {
        System.out.print("Amount: ");
        double amount = sc.nextDouble();

        // Business rule: deposit must be positive
        if (amount <= 0) {
            System.out.println("Invalid amount.");
            return;
        }

        balance += amount; // assignment operator
        System.out.printf("Deposited. Balance: %.2f%n", balance);
    }

    /**
     * Withdraws money after PIN verification.
     */
    static void withdraw(Scanner sc) {
        System.out.print("Enter PIN: ");
        int enteredPin = sc.nextInt();

        // Security rule: PIN must match
        if (enteredPin != pin) {
            System.out.println("Incorrect PIN.");
            return;
        }

        System.out.print("Amount: ");
        double amount = sc.nextDouble();

        // Business rules: positive amount and sufficient balance
        if (amount <= 0) {
            System.out.println("Invalid amount.");
            return;
        }

        if (amount > balance) {
            System.out.println("Insufficient balance.");
            return;
        }

        balance -= amount;
        System.out.printf("Withdrawn. Balance: %.2f%n", balance);
    }

    /**
     * Prints the current account balance.
     */
    static void printBalance() {
        System.out.printf("Current Balance: %.2f%n", balance);
    }

    /**
     * Changes the PIN after verifying the old PIN.
     */
    static void changePin(Scanner sc) {
        System.out.print("Enter current PIN: ");
        int oldPin = sc.nextInt();

        // Security rule: old PIN must match
        if (oldPin != pin) {
            System.out.println("Incorrect PIN.");
            return;
        }

        System.out.print("Enter new PIN: ");
        int newPin = sc.nextInt();

        // Business rule: PIN should be positive
        if (newPin <= 0) {
            System.out.println("Invalid PIN.");
            return;
        }

        pin = newPin;
        System.out.println("PIN changed successfully.");
    }
}
