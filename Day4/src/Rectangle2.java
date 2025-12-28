class Rectangle2{

    // Private fields
    private double width;
    private double height;

    // Getter for width
    public double getWidth() {
        return width;
    }

    // Getter for height
    public double getHeight() {
        return height;
    }

    // Setter for width (accept only positive values)
    public void setWidth(double w) {
        if (w > 0) {
            width = w;
        }
        // silently reject if w <= 0
    }

    // Setter for height (accept only positive values)
    public void setHeight(double h) {
        if (h > 0) {
            height = h;
        }
        // silently reject if h <= 0
    }

    // Calculate area
    public double area() {
        return width * height;
    }

    // Calculate perimeter
    public double perimeter() {
        return 2 * (width + height);
    }
}
