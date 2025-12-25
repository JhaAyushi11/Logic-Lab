import java.util.Scanner;

public class ATMSimulation {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int balance = 1000;

        while (true) {
            System.out.println("1.Check Balance\n2.Deposit\n3.Withdraw\n4.Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Balance = " + balance);
                    break;

                case 2:
                    System.out.print("Enter amount: ");
                    balance += sc.nextInt();
                    System.out.println("New Balance = " + balance);
                    break;

                case 3:
                    System.out.print("Enter amount: ");
                    int amt = sc.nextInt();
                    if (amt <= balance) {
                        balance -= amt;
                        System.out.println("New Balance = " + balance);
                    } else {
                        System.out.println("Insufficient Balance");
                    }
                    break;

                case 4:
                    System.out.println("Thank You!");
                    return;

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}
