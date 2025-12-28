public class StudentMain {
    public static void main(String[] args) {

        Student3 s = new Student3(101);
        s.setName("Alice");

        System.out.println(s.getId());   // 101
        System.out.println(s.getName()); // Alice

        // s.id = 202; // ❌ Compile-time error (id is final)
    }
}
