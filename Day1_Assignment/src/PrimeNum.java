import java.util.Scanner;

public class PrimeNum {
	static boolean checkPrime(int n) {
		if(n==1) {
			return false;
		}
		for(int i=2;i*i<=n;i++) {
			if(n%i==0) {
				return false;
			}
		}
		return true;
	}
public static void main(String args[]) {
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter number: ");
	int a= sc.nextInt();
	if(checkPrime(a)==true) {
		System.out.println(a+" is a Prime number.");
	}else {
		System.out.println(a+" is not a Prime number.");
	}
	
}
}
