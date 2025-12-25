import java.util.*;

public class StringReverse {
	static String reverse(String s) {
		StringBuilder rev= new StringBuilder();
		for(int i=s.length()-1;i>=0;i--) {
			rev.append(s.charAt(i));
		}
		return rev.toString();
	}
	public static void main(String args[]) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter a String: ");
		String s= sc.next();
		System.out.println("Reversed String : "+ reverse(s));
		
	}

}
