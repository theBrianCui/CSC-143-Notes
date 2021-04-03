package scratch;

public interface Positionable<T extends Point> {
    public void setLocation(T location);
    public T getLocation();
}
