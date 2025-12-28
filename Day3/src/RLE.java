import java.util.Scanner;

public class RLE {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1) Compress");
            System.out.println("2) Decompress");
            System.out.println("3) Exit");
            System.out.print("Enter choice: ");

            if (!sc.hasNextInt()) {
                sc.next();          // discard invalid input
                continue;
            }

            int choice = sc.nextInt();
            sc.nextLine();          // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter string to compress: ");
                    String input = sc.nextLine();

                    if (!isLettersOnly(input)) {
                        System.out.println("Invalid input. Letters only allowed.");
                        continue;
                    }

                    System.out.println(compress(input));
                    break;

                case 2:
                    System.out.print("Enter string to decompress: ");
                    String encoded = sc.nextLine();

                    if (!isValidEncoded(encoded)) {
                        System.out.println("Invalid encoded format.");
                        continue;
                    }

                    System.out.println(decompress(encoded));
                    break;

                case 3:
                    System.out.println("Exiting...");
                    return;

                default:
                    continue;
            }
        }
    }

    /**
     * Compresses a string using Run-Length Encoding.
     * Example: aaabbc → a3b2c1
     */
    static String compress(String s) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            int count = 1;

            // Count consecutive characters
            while (i + 1 < s.length() && s.charAt(i + 1) == current) {
                count++;
                i++;
            }

            // Disallow counts > 9
            if (count > 9) {
                System.out.println("Count greater than 9 not allowed.");
                return "";
            }

            result.append(current).append(count);
        }
        return result.toString();
    }

    /**
     * Decompresses a Run-Length Encoded string.
     * Example: a3b2c1 → aaabbc
     */
    static String decompress(String s) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i += 2) {
            char ch = s.charAt(i);
            int count = Integer.parseInt(String.valueOf(s.charAt(i + 1)));

            // Repeat character count times
            for (int j = 0; j < count; j++) {
                result.append(ch);
            }
        }
        return result.toString();
    }

    /**
     * Validates encoded string format (letter followed by digit).
     */
    static boolean isValidEncoded(String s) {
        if (s.length() % 2 != 0) return false;

        for (int i = 0; i < s.length(); i += 2) {
            if (!Character.isLetter(s.charAt(i)) ||
                !Character.isDigit(s.charAt(i + 1))) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if input contains letters only.
     */
    static boolean isLettersOnly(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isLetter(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
