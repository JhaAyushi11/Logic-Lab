
public class RevWords {
	public static void main(String[] args) {
        String str = "Java is fun";
        String[] words = str.split(" ");

        for (String word : words) {
            StringBuilder sb = new StringBuilder(word);
            System.out.print(sb.reverse() + " ");
        }
    }

}
