import java.util.Scanner;

public class ExpressionEval {

    /**
     * Evaluates a simple arithmetic expression containing +, -, *, /
     * using integer arithmetic with correct operator precedence.
     */
    public static int evaluate(String expr) {

        int[] numbers = new int[100];     // stack for numbers
        char[] operators = new char[100]; // stack for operators
        int numTop = -1, opTop = -1;

        int i = 0;

        /* ================= TOKENIZATION & PARSING ================= */
        while (i < expr.length()) {
            char ch = expr.charAt(i);

            // Skip spaces
            if (ch == ' ') {
                i++;
                continue;
            }

            // Parse multi-digit number
            if (Character.isDigit(ch)) {
                String numStr = "";

                while (i < expr.length() && Character.isDigit(expr.charAt(i))) {
                    numStr += expr.charAt(i);
                    i++;
                }

                numbers[++numTop] = Integer.parseInt(numStr);
                continue; // important to avoid extra increment
            }

            // Operator handling
            if (isOperator(ch)) {

                // Apply operators with higher or equal precedence
                while (opTop >= 0 && precedence(operators[opTop]) >= precedence(ch)) {
                    int b = numbers[numTop--];
                    int a = numbers[numTop--];
                    char op = operators[opTop--];
                    numbers[++numTop] = applyOperator(a, b, op);
                }

                operators[++opTop] = ch;
            } else {
                System.out.println("Invalid character found: " + ch);
                System.exit(0);
            }
            i++;
        }

        /* ================= FINAL EVALUATION ================= */
        while (opTop >= 0) {
            int b = numbers[numTop--];
            int a = numbers[numTop--];
            char op = operators[opTop--];
            numbers[++numTop] = applyOperator(a, b, op);
        }

        return numbers[numTop];
    }

    // Checks if character is a valid operator
    private static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    // Defines operator precedence
    private static int precedence(char op) {
        if (op == '*' || op == '/') return 2;
        return 1;
    }

    // Applies arithmetic operation
    private static int applyOperator(int a, int b, char op) {
        return switch (op) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            case '/' -> a / b; // integer division (truncates)
            default -> 0;
        };
    }

    /* ================= MAIN METHOD ================= */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter expression:");
        String expr = sc.nextLine();

        int result = evaluate(expr);
        System.out.println("Result: " + result);
    }
}
