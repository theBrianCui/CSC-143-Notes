package scratch;

public class Circle implements Shape2D {
    private int radius;

    public Circle(int radius) {
        if (radius < 0) {
            throw new RuntimeException("Invalid radius specified");
        }
        this.radius = radius;
    }

    public void setRadius(int radius) {
        if (radius < 0) {
            throw new RuntimeException("Invalid radius specified");
        }
        this.radius = radius;
    }

    public int getRadius() {
        return this.radius;
    }

    @Override
    public double area() {
        return Math.pow(radius, 2) * Math.PI;
    }

    public static void main(String args[]) {
        Circle c = new Circle(5);
        System.out.println(c.radius);
    }
}
