import java.util.Scanner;

public class StringAnaly {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text;

        // Force at least one input read
        do {
            text = sc.nextLine();
        } while (text.trim().isEmpty());

        int wordCount = 0;
        int sentenceCount = 0;
        int letterCount = 0;

        String currentWord = "";
        String longestWord = "";

        // Manual scanning
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (Character.isLetter(ch)) {
                letterCount++;          // ONLY letters counted
                currentWord += ch;
            } else {
                // End of word
                if (!currentWord.isEmpty()) {
                    wordCount++;
                    if (currentWord.length() > longestWord.length()) {
                        longestWord = currentWord;
                    }
                    currentWord = "";
                }

                // Sentence detection
                if (ch == '.' || ch == '!' || ch == '?') {
                    sentenceCount++;
                }
            }
        }

        // Handle last word
        if (!currentWord.isEmpty()) {
            wordCount++;
            if (currentWord.length() > longestWord.length()) {
                longestWord = currentWord;
            }
        }

        int[] vowels = countVowels(text);

        // Output
        System.out.println("Words: " + wordCount);
        System.out.println("Sentences: " + sentenceCount);
        System.out.println("Letters: " + letterCount);
        System.out.println("Longest word: \"" + longestWord + "\"");
        System.out.println(
                "Vowel freq: a=" + vowels[0] +
                " e=" + vowels[1] +
                " i=" + vowels[2] +
                " o=" + vowels[3] +
                " u=" + vowels[4]
        );

        sc.close();
    }

    // Counts vowels (letters only)
    static int[] countVowels(String s) {
        int[] v = new int[5];

        for (int i = 0; i < s.length(); i++) {
            char ch = Character.toLowerCase(s.charAt(i));
            if (Character.isLetter(ch)) {
                switch (ch) {
                    case 'a': v[0]++; break;
                    case 'e': v[1]++; break;
                    case 'i': v[2]++; break;
                    case 'o': v[3]++; break;
                    case 'u': v[4]++; break;
                }
            }
        }
        return v;
    }
}
