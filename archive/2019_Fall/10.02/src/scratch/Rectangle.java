package scratch;

public class Rectangle implements Shape {
    private int width;
    private int height;
    Point location;

    public Rectangle(int width, int height, Point location) {
        this.width = width;
        this.height = height;
        this.location = location;
    }

    public void rotate90() {
        int temp = this.width;
        this.width = height;
        this.height = width;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    @Override
    public Point getLocation() {
        return this.location;
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

        Rectangle r = (Rectangle) o;
        return this.width == r.width && this.height == r.height && this.location.equals(r.getLocation());
    }

    @Override
    public String toString() {
        return String.format("Rectangle: %d x %d", width, height);
    }
}
