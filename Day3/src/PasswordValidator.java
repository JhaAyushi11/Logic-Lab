import java.util.Scanner;

public class PasswordValidator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("username: ");
        String username = sc.nextLine();

        System.out.print("password: ");
        String password = sc.nextLine();

        if (isValid(password, username)) {
            System.out.println("Password is valid.");
        } else {
            System.out.println("Invalid: " + feedback(password, username));
        }

        sc.close();
    }

    /**
     * Validates password based on given rules.
     */
    static boolean isValid(String pwd, String user) {

        // Length rule
        if (pwd.length() < 8 || pwd.length() > 20) {
            return false;
        }

        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        // Scan characters
        for (int i = 0; i < pwd.length(); i++) {
            char ch = pwd.charAt(i);

            // No spaces allowed
            if (ch == ' ') {
                return false;
            }

            if (Character.isUpperCase(ch)) {
                hasUpper = true;
            } else if (Character.isLowerCase(ch)) {
                hasLower = true;
            } else if (Character.isDigit(ch)) {
                hasDigit = true;
            } else if (isSpecial(ch)) {
                hasSpecial = true;
            } else {
                continue; // non-contributing character
            }
        }

        // Username check (case-insensitive)
        if (pwd.toLowerCase().contains(user.toLowerCase())) {
            return false;
        }

        return hasUpper && hasLower && hasDigit && hasSpecial;
    }

    /**
     * Provides feedback for invalid password.
     */
    static String feedback(String pwd, String user) {
        StringBuilder fb = new StringBuilder();

        if (pwd.length() < 8 || pwd.length() > 20) {
            fb.append("\n- Password length must be between 8 and 20.");
        }

        if (pwd.contains(" ")) {
            fb.append("\n- Password must not contain spaces.");
        }

        if (pwd.toLowerCase().contains(user.toLowerCase())) {
            fb.append("\n- Avoid using parts of your name.");
        }

        boolean u = false, l = false, d = false, s = false;

        for (int i = 0; i < pwd.length(); i++) {
            char ch = pwd.charAt(i);

            if (Character.isUpperCase(ch)) u = true;
            else if (Character.isLowerCase(ch)) l = true;
            else if (Character.isDigit(ch)) d = true;
            else if (isSpecial(ch)) s = true;
        }

        if (!u) fb.append("\n- Add at least one uppercase letter.");
        if (!l) fb.append("\n- Add at least one lowercase letter.");
        if (!d) fb.append("\n- Add at least one digit.");
        if (!s) fb.append("\n- Add more special characters.");

        return fb.toString();
    }

    /**
     * Checks if character is a valid special symbol.
     */
    static boolean isSpecial(char ch) {
        return "!@#$%^&*".indexOf(ch) != -1;
    }
}
