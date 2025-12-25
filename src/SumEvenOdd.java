import java.util.Scanner;

public class SumEvenOdd {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int evenSum = 0, oddSum = 0;

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        System.out.println("Enter numbers:");
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            if (num % 2 == 0)
                evenSum += num;
            else
                oddSum += num;
        }

        System.out.println("Sum of Even = " + evenSum);
        System.out.println("Sum of Odd = " + oddSum);
    }

}
