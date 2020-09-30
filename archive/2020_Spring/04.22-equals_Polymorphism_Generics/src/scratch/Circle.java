package scratch;

public class Circle implements Shape {
    private int radius;
    private Point location;

    public Circle(int radius, Point location) {
        this.radius = radius;
        this.location = location;
    }

    @Override
    public Point getLocation() {
        return this.location;
    }

    @Override
    public double area() {
        return Math.PI * Math.pow((double) radius, 2);
    }

    @Override
    public final boolean equals(Object o) {
        if (o == null) {
            return false;
        }

        if (this == o) {
            return true;
        }

        if (!(o instanceof Circle)) {
            return false;
        }

        Circle r = (Circle) o;
        return this.radius == r.radius && this.location.equals(r.getLocation());
    }

    @Override
    public String toString() {
        return String.format("Circle: Radius %d", this.radius);
    }
}
