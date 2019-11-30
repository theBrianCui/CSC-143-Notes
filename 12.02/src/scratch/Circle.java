package scratch;

public class Circle implements Comparable<Circle> {
    public int radius;
    public String name;

    public Circle(int radius) {
        this.radius = radius;
        this.name = "";
    }

    public Circle(int radius, String name) {
        this.radius = radius;
        this.name = name;
    }

    // Specifies the natural order of Circle as by radius
    // Ascending based on radius
    @Override
    public int compareTo(Circle o) {
        if (radius == o.radius) {
            return 0;
        }

        if (radius < o.radius) {
            return -1;
        }

        return 1;

        // return Integer.compare(radius, o.radius);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (this.getClass() != o.getClass()) {
            return false;
        }

        Circle other = (Circle) o;
        return this.radius == other.radius && this.name.equals(other.name);
    }
}
