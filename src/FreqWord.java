
public class FreqWord {
	public static void main(String[] args) {
        String str = "Java is fun and Java is powerful";
        String[] words = str.split(" ");
        boolean[] visited = new boolean[words.length];

        for (int i = 0; i < words.length; i++) {
            if (visited[i]) continue;

            int count = 1;
            for (int j = i + 1; j < words.length; j++) {
                if (words[i].equals(words[j])) {
                    visited[j] = true;
                    count++;
                }
            }
            System.out.println(words[i] + ": " + count);
        }
    }
}
