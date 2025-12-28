import java.util.Scanner;

public class MatrixOps {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        /* ---------- Read dimensions ---------- */
        int r = sc.nextInt();
        int c = sc.nextInt();

        // Validate dimensions (2–10)
        if (r < 2 || r > 10 || c < 2 || c > 10) {
            System.out.println("Invalid matrix dimensions.");
            return;
        }

        int[][] A = new int[r][c];
        int[][] B = new int[r][c];

        /* ---------- Read first matrix ---------- */
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                A[i][j] = sc.nextInt();
            }
        }

        /* ---------- Read second matrix ---------- */
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                B[i][j] = sc.nextInt();
            }
        }

        /* ---------- Menu ---------- */
        while (true) {
            System.out.println("\n1) Add");
            System.out.println("2) Subtract");
            System.out.println("3) Multiply");
            System.out.println("4) Transpose (First Matrix)");
            System.out.println("5) Row/Column Sums");
            System.out.println("6) Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    printMatrix(add(A, B));
                    break;

                case 2:
                    printMatrix(subtract(A, B));
                    break;

                case 3:
                    multiplyMenu(sc, A);
                    break;

                case 4:
                    printMatrix(transpose(A));
                    break;

                case 5:
                    rowColumnSums(A);
                    break;

                case 6:
                    System.out.println("Exiting...");
                    return;

                default:
                    continue;
            }
        }
    }

    /* ---------- Matrix Addition ---------- */
    static int[][] add(int[][] A, int[][] B) {
        int[][] C = new int[A.length][A[0].length];

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                C[i][j] = A[i][j] + B[i][j];
            }
        }
        return C;
    }

    /* ---------- Matrix Subtraction ---------- */
    static int[][] subtract(int[][] A, int[][] B) {
        int[][] C = new int[A.length][A[0].length];

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                C[i][j] = A[i][j] - B[i][j];
            }
        }
        return C;
    }

    /* ---------- Multiplication Menu ---------- */
    static void multiplyMenu(Scanner sc, int[][] A) {
        int r2 = sc.nextInt();
        int c2 = sc.nextInt();

        int[][] B = new int[r2][c2];

        for (int i = 0; i < r2; i++) {
            for (int j = 0; j < c2; j++) {
                B[i][j] = sc.nextInt();
            }
        }

        // Validate multiplication condition
        if (A[0].length != r2) {
            System.out.println("Matrix multiplication not possible.");
            return;
        }

        printMatrix(multiply(A, B));
    }

    /* ---------- Matrix Multiplication ---------- */
    static int[][] multiply(int[][] A, int[][] B) {
        int[][] C = new int[A.length][B[0].length];

        /*
         * Triple-loop order:
         * i → rows of first matrix
         * j → columns of second matrix
         * k → column of A & row of B (dot product)
         */
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B[0].length; j++) {
                for (int k = 0; k < A[0].length; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return C;
    }

    /* ---------- Transpose ---------- */
    static int[][] transpose(int[][] A) {
        int[][] T = new int[A[0].length][A.length];

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                T[j][i] = A[i][j];
            }
        }
        return T;
    }

    /* ---------- Row & Column Sums ---------- */
    static void rowColumnSums(int[][] A) {

        System.out.println("Row sums:");
        for (int i = 0; i < A.length; i++) {
            int sum = 0;
            for (int j = 0; j < A[0].length; j++) {
                sum += A[i][j];
            }
            System.out.println(sum);
        }

        System.out.println("Column sums:");
        for (int j = 0; j < A[0].length; j++) {
            int sum = 0;
            for (int i = 0; i < A.length; i++) {
                sum += A[i][j];
            }
            System.out.println(sum);
        }
    }

    /* ---------- Print Matrix ---------- */
    static void printMatrix(int[][] M) {
        for (int[] row : M) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
