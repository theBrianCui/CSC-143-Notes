package scratch;

public class Rectangle extends Shape {
    private int width;
    private int height;

    public Rectangle(String name, int width, int height, Point location) {
        this.name = name;
        this.width = width;
        this.height = height;
        this.location = location;
    }

    public void rotate90() {
        int temp = this.width;
        this.width = height;
        this.height = temp;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    @Override
    public double area() {
        return width * height;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Rectangle)) {
            return false;
        }

        // This is so much work!
        // Next time call super.equals() instead and re-use
        // common code across Shapes
        Rectangle r = (Rectangle) o;
        return this.width == r.width
                && this.height == r.height
                && this.name.equals(r.getName())
                && this.location.equals(r.getLocation());
    }

    @Override
    public String toString() {
        return String.format("%s (Rectangle: %d x %d)", this.name, width, height);
    }
}
