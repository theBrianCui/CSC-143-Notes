package scratch;

public class Rectangle implements Shape2D {
    private int width;
    private int height;

    // Constructor
    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    // Methods
    public void setWidth(int width) {
        this.width = width;
    }

    public int getWidth() {
        return this.width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return this.height;
    }

    public void doubleDimensions() {
        this.width = this.width * 2;
        this.height = this.height * 2;
    }

    @Override
    public double area() {
        return (double) this.width * (double) this.height;
    }
}
