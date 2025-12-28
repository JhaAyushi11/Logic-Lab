import java.util.Scanner;

public class CLIPhonebook {

    // Parallel arrays to store contacts
    static String[] names = new String[100];
    static String[] phones = new String[100];
    static int size = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            String line = sc.nextLine();

            // Skip empty lines
            if (line.trim().isEmpty()) {
                continue;
            }

            // Parse command (supports quoted names)
            String[] parts = splitCommand(line);

            String cmd = parts[0].toUpperCase();

            switch (cmd) {
                case "ADD":
                    if (parts.length < 3) {
                        System.out.println("Usage: ADD name phone");
                        continue;
                    }
                    add(parts[1], parts[2]);
                    break;

                case "DEL":
                    if (parts.length < 2) {
                        System.out.println("Usage: DEL name");
                        continue;
                    }
                    delete(parts[1]);
                    break;

                case "FIND":
                    if (parts.length < 2) {
                        System.out.println("Usage: FIND substring");
                        continue;
                    }
                    find(parts[1]);
                    break;

                case "LIST":
                    list();
                    break;

                case "EXIT":
                    System.out.println("Goodbye.");
                    return;

                default:
                    // Unknown command
                    continue;
            }
        }
    }

    /**
     * Adds a new contact after validating phone number.
     */
    static void add(String name, String phone) {
        if (size >= 100) {
            System.out.println("Phonebook full.");
            return;
        }

        if (!isValidPhone(phone)) {
            System.out.println("Invalid phone number.");
            return;
        }

        names[size] = name;
        phones[size] = phone;
        size++;
    }

    /**
     * Deletes a contact by exact name match (case-insensitive).
     */
    static void delete(String name) {
        for (int i = 0; i < size; i++) {
            if (names[i].equalsIgnoreCase(name)) {
                // Shift left to fill the gap
                for (int j = i; j < size - 1; j++) {
                    names[j] = names[j + 1];
                    phones[j] = phones[j + 1];
                }
                size--;
                return;
            }
        }
        System.out.println("Contact not found.");
    }

    /**
     * Finds contacts by partial name match (case-insensitive).
     */
    static void find(String sub) {
        boolean found = false;
        for (int i = 0; i < size; i++) {
            if (names[i].toLowerCase().contains(sub.toLowerCase())) {
                System.out.println("Found: " + names[i] + "(" + phones[i] + ")");
                found = true;
            }
        }
        if (!found) {
            System.out.println("No match found.");
        }
    }

    /**
     * Lists all contacts.
     */
    static void list() {
        if (size == 0) {
            System.out.println("No contacts.");
            return;
        }
        for (int i = 0; i < size; i++) {
            System.out.print(names[i] + "(" + phones[i] + ")");
            if (i < size - 1) System.out.print(", ");
        }
        System.out.println();
    }

    /**
     * Validates phone number: exactly 10 digits.
     */
    static boolean isValidPhone(String phone) {
        if (phone.length() != 10) return false;
        for (int i = 0; i < phone.length(); i++) {
            if (!Character.isDigit(phone.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * Splits a command line.
     * Supports quoted names like: ADD "Alice Smith" 9876543210
     *
     * Parsing logic:
     * - If quotes exist, text inside quotes is treated as one token.
     * - Remaining parts are split by spaces.
     */
    static String[] splitCommand(String line) {
        line = line.trim();

        if (line.contains("\"")) {
            int firstQuote = line.indexOf('"');
            int secondQuote = line.indexOf('"', firstQuote + 1);

            if (secondQuote > firstQuote) {
                String before = line.substring(0, firstQuote).trim();
                String name = line.substring(firstQuote + 1, secondQuote);
                String after = line.substring(secondQuote + 1).trim();

                if (after.isEmpty()) {
                    return new String[]{before, name};
                } else {
                    String[] rest = after.split(" ");
                    String[] result = new String[2 + rest.length];
                    result[0] = before;
                    result[1] = name;
                    System.arraycopy(rest, 0, result, 2, rest.length);
                    return result;
                }
            }
        }

        // Default simple split
        return line.split(" ");
    }
}
