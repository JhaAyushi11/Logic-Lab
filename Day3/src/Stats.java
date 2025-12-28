import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Stats {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();

        /* ---------- Read numbers until sentinel -999 ---------- */
        while (true) {
            if (!sc.hasNextInt()) {
                sc.next();      // discard non-integer
                continue;       // skip invalid input
            }

            int x = sc.nextInt();
            if (x == -999) {
                break;          // sentinel found
            }
            list.add(x);
        }

        if (list.isEmpty()) {
            System.out.println("No data provided.");
            return;
        }

        // Convert ArrayList to array for method requirements
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }

        int count = arr.length;
        int sum = 0;
        for (int v : arr) sum += v;

        int min = min(arr);
        int max = max(arr);
        double avg = average(arr);
        double med = median(arr);
        int mode = mode(arr);

        /* ---------- Output ---------- */
        System.out.printf(
                "Count=%d, Sum=%d, Min=%d, Max=%d, Avg=%.2f, Median=%.2f, Mode=%d%n",
                count, sum, min, max, avg, med, mode
        );

        sc.close();
    }

    /* ---------- Minimum ---------- */
    static int min(int[] a) {
        int m = a[0];
        for (int i = 1; i < a.length; i++) {
            if (Integer.compare(a[i], m) < 0) {
                m = a[i];
            }
        }
        return m;
    }

    /* ---------- Maximum ---------- */
    static int max(int[] a) {
        int m = a[0];
        for (int i = 1; i < a.length; i++) {
            if (Integer.compare(a[i], m) > 0) {
                m = a[i];
            }
        }
        return m;
    }

    /* ---------- Average ---------- */
    static double average(int[] a) {
        int sum = 0;
        for (int v : a) sum += v;
        return (double) sum / a.length;
    }

    /* ---------- Median ---------- */
    static double median(int[] a) {
        ArrayList<Integer> temp = new ArrayList<>();
        for (int v : a) temp.add(v);
        Collections.sort(temp);

        int n = temp.size();
        if (n % 2 == 1) {
            return temp.get(n / 2);
        } else {
            return (temp.get(n / 2 - 1) + temp.get(n / 2)) / 2.0;
        }
    }

    /* ---------- Mode ---------- */
    static int mode(int[] a) {
        ArrayList<Integer> temp = new ArrayList<>();
        for (int v : a) temp.add(v);
        Collections.sort(temp);

        int mode = temp.get(0);
        int maxCount = 1;

        int current = temp.get(0);
        int count = 1;

        for (int i = 1; i < temp.size(); i++) {
            if (temp.get(i).equals(current)) {
                count++;
            } else {
                if (count > maxCount) {
                    maxCount = count;
                    mode = current;
                }
                current = temp.get(i);
                count = 1;
            }
        }

        // Final check
        if (count > maxCount) {
            mode = current;
        }

        return mode;
    }
}
