public class MathUtilMain {
    public static void main(String[] args) {

        System.out.println(MathUtil4.max(7, 3));        // 7
        System.out.println(MathUtil4.clamp(15, 0, 10)); // 10
        System.out.println(MathUtil4.clamp(-3, -2, 5)); // -2
    }
}
