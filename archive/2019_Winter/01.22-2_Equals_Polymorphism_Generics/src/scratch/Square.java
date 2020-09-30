package scratch;

public class Square extends Rectangle {
    public Square(int side, Point location) {
        super(side, side, location);
    }

    @Override
    public String toString() {
        return String.format("Square: %d x %d", this.getWidth(), this.getHeight());
    }
}
