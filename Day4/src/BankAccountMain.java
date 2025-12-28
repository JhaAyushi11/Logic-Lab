public class BankAccountMain {
    public static void main(String[] args) {

        BankAccount6 acc = new BankAccount6("Sarthak", 1000.0);

        acc.deposit(500);
        acc.withdraw(300);

        System.out.println(acc.getBalance()); // 1200.0
    }
}
