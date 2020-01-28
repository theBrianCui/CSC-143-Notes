package scratch;

public class Circle extends Shape {
    private int radius;

    public Circle(String name, int radius, Point location) {
        this.name = name;
        this.radius = radius;
        this.location = location;
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

        if (!super.equals(o)) {
            return false;
        }

        Circle r = (Circle) o;
        return this.radius == r.radius;
    }

    @Override
    public String toString() {
        return String.format("%s (Circle: Radius %d)", this.name, this.radius);
    }
}
