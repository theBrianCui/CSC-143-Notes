package scratch;

import java.util.Collection;

public interface GraphNode<T> {
    public void setValue(T value);
    public T getValue();

    public void addNeighbor(GraphNode<T> neighbor);
    public void removeNeighbor(GraphNode<T> neighbor);

    public Collection<GraphNode<T>> getNeighbors();
}
