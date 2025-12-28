import java.util.Scanner;

public class DayOfWeek {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read date
        int day = sc.nextInt();
        int month = sc.nextInt();
        int year = sc.nextInt();

        // Input validation
        if (!isValidDate(day, month, year)) {
            System.out.println("Invalid date");
            return;
        }

        // Compute and print day of week
        System.out.println(dayOfWeek(day, month, year));

        sc.close();
    }

    /**
     * Returns the day of week for a given date using Zeller’s Congruence.
     */
    static String dayOfWeek(int d, int m, int y) {

        /*
         * Zeller’s rule:
         * January and February are treated as months 13 and 14
         * of the previous year.
         */
        if (m == 1 || m == 2) {
            m += 12;
            y -= 1;
        }

        int q = d;          // day of month
        int K = y % 100;    // year of the century
        int J = y / 100;    // zero-based century

        /*
         * Zeller’s Congruence formula
         * h = (q + (13(m+1))/5 + K + K/4 + J/4 + 5J) % 7
         */
        int h = (q + (13 * (m + 1)) / 5 + K + (K / 4) + (J / 4) + (5 * J)) % 7;

        // Mapping Zeller output to day names
        String[] days = {
                "Saturday", "Sunday", "Monday",
                "Tuesday", "Wednesday", "Thursday", "Friday"
        };

        return days[h];
    }

    /**
     * Validates the date including leap year rules.
     */
    static boolean isValidDate(int d, int m, int y) {

        if (y <= 0 || m < 1 || m > 12 || d < 1) {
            return false;
        }

        int[] daysInMonth = {
                31, 28, 31, 30, 31, 30,
                31, 31, 30, 31, 30, 31
        };

        // Leap year adjustment for February
        if (isLeapYear(y)) {
            daysInMonth[1] = 29;
        }

        return d <= daysInMonth[m - 1];
    }

    /**
     * Checks whether a year is a leap year.
     */
    static boolean isLeapYear(int y) {
        return (y % 400 == 0) || (y % 4 == 0 && y % 100 != 0);
    }
}
