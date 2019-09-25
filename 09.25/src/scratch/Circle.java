package scratch;

public class Circle implements Shape2D {
    int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return this.radius;
    }

    @Override
    public double area() {
        return Math.pow(radius, 2) * Math.PI;
    }
}
