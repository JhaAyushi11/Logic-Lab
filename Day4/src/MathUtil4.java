class MathUtil4 {

    // Returns the maximum of two integers
    public static int max(int a, int b) {
        return (a > b) ? a : b;
    }

    // Clamps value v between min and max
    public static int clamp(int v, int min, int max) {
        if (v < min) {
            return min;
        } else if (v > max) {
            return max;
        }
        return v;
    }
}
