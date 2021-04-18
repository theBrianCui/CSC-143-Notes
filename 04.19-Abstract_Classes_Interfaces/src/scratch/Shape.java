package scratch;

public abstract class Shape implements Positionable<Point> {
    String name;
    Point location;

    public Shape() {

    }
    // Abstract classes might have no constructor:
    // They cannot be constructed!

    // Just like an interface, methods declared abstract
    // must be implemented by a concrete child class.
    abstract double area();

    // However, unlike interfaces, abstract classes
    // can contain implementation that children classes can reuse!
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    // Abstract classes are not obligated to contain implementation
    // however, even for interfaces.
//    public abstract void setLocation(Point location);
//
//    public abstract Point getLocation();
    @Override
    public void setLocation(Point location) {
        this.location = location;
    }

    @Override
    public Point getLocation() {
        return this.location;
    }

    // Abstract classes still inherit from Object like all other classes
    // Non-abstract methods are useful for sharing code across
    // all non-abstract children, like this .equals() method below
    // See Shape::equals() vs Rectangle::equals() in this project
    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }

        if (this == o) {
            return true;
        }

        if (!(o instanceof Shape)) {
            return false;
        }

        Shape s = (Shape) o;

        /* Don't drop the ball!
           Calling .equals() has no effect
           if you don't use the return value */

//        this.name.equals(s.name);
//        this.location.equals(s.location);

        return this.name.equals(s.name) && this.location.equals(s.location);
    }

}
