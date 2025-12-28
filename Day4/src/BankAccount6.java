class BankAccount6 {

    // Private fields
    private String owner;
    private double balance;

    // Constructor
    public BankAccount6(String owner, double balance) {
        this.owner = owner;
        if (balance >= 0) {
            this.balance = balance;
        }
    }

    // Deposit: only positive amounts
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
        // silently reject invalid amount
    }

    // Withdraw: must not exceed balance
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        }
        // silently reject invalid withdrawal
    }

    // Getter for owner
    public String getOwner() {
        return owner;
    }

    // Getter for balance
    public double getBalance() {
        return balance;
    }

    // Bonus: protected method for internal fee handling
    protected void applyFee(double fee) {
        if (fee > 0 && fee <= balance) {
            balance -= fee;
        }
    }
}
