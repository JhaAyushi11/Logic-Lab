import java.util.Scanner;

/**
 * Command-Line Gradebook
 * Maintains student names and grades using arrays.
 */
public class GradeBook {

    static String[] names;
    static int[] grades;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        /* ---------- Read number of students ---------- */
        n = sc.nextInt();
        sc.nextLine(); // consume newline

        names = new String[n];
        grades = new int[n];

        /* ---------- Read names and grades ---------- */
        for (int i = 0; i < n; i++) {
            String name;
            do {
                name = sc.nextLine().trim();
            } while (name.isEmpty()); // handle empty names

            int grade;
            do {
                grade = sc.nextInt();
            } while (grade < 0 || grade > 100); // validate bounds

            sc.nextLine(); // consume newline

            names[i] = name;
            grades[i] = grade;
        }

        /* ---------- Menu Loop ---------- */
        while (true) {
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    printAll();
                    break;

                case 2:
                    printTopper();
                    break;

                case 3:
                    printAverage();
                    break;

                case 4:
                    String searchName = sc.nextLine();
                    searchByName(searchName);
                    break;

                case 5:
                    curveGrades();
                    break;

                case 6:
                    System.out.println("Exiting...");
                    break;

                default:
                    continue; // invalid menu choice
            }

            if (choice == 6) {
                break;
            }
        }
        sc.close();
    }

    /**
     * Prints all students with their grades.
     */
    static void printAll() {
        System.out.print("All: ");
        for (int i = 0; i < n; i++) {
            System.out.print(names[i] + "(" + grades[i] + ")");
            if (i < n - 1) System.out.print(", ");
        }
        System.out.println();
    }

    /**
     * Prints the topper (highest grade).
     */
    static void printTopper() {
        int max = grades[0];
        int index = 0;

        for (int i = 1; i < n; i++) {
            if (grades[i] > max) {
                max = grades[i];
                index = i;
            }
        }
        System.out.println("Topper: " + names[index] + "(" + max + ")");
    }

    /**
     * Calculates and prints class average.
     */
    static void printAverage() {
        int sum = 0;
        for (int g : grades) {
            sum += g;
        }
        double avg = (double) sum / n;
        System.out.printf("Average: %.2f%n", avg);
    }

    /**
     * Searches a student by name (case-insensitive).
     */
    static void searchByName(String name) {
        for (int i = 0; i < n; i++) {
            if (names[i].equalsIgnoreCase(name)) {
                System.out.println("Found: " + names[i] + "(" + grades[i] + ")");
                return;
            }
        }
        System.out.println("Not found");
    }

    /**
     * Curves grades by +5, capped at 100.
     */
    static void curveGrades() {
        for (int i = 0; i < n; i++) {
            grades[i] = Math.min(100, grades[i] + 5);
        }
    }
}
