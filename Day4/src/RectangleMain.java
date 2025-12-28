public class RectangleMain {
    public static void main(String[] args) {

        Rectangle2 r = new Rectangle2();

        r.setWidth(10);
        r.setHeight(5);

        System.out.println(r.area());      // 50.0
        System.out.println(r.perimeter()); // 30.0

        r.setWidth(0);  // silently rejected
        System.out.println(r.getWidth()); // still 10.0
    }
}
