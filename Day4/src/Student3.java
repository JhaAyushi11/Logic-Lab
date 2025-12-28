class Student3 {

    // Fields
    private final int id;   // immutable field
    private String name;

    // Constructor sets id
    public Student3(int id) {
        this.id = id;
    }

    // Getter for id (read-only)
    public int getId() {
        return id;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }
}
