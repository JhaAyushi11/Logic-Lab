import java.util.Scanner;

public class CountFrequency {
	
	public static void main(String args[]) {
		Scanner sc= new Scanner(System.in);
		String str = "bab!!";
		int [] freq= new int[26];
		for(char ch: str.toCharArray()) {
			if(ch>='a' && ch<='z') {
				freq[ch-'a']++;
			}
		}
		for(int i=0;i<26;i++) {
			if(freq[i]>0) {
				System.out.println((char)(i+'a')+":"+freq[i]+ " ");
			}
		}
	}

}
