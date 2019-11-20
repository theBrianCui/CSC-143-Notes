package scratch;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;

public class DirectedGraphNode<T> implements GraphNode<T> {
    private int id;
    private T value;
    private HashSet<GraphNode<T>> neighbors = new HashSet<>();

    public DirectedGraphNode(int id, T value) {
        this.id = id;
        this.value = value;
    }

    @Override
    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public T getValue() {
        return value;
    }

    @Override
    public void addNeighbor(GraphNode<T> neighbor) {
        if (this.neighbors.contains(neighbor)) {
            return;
        }

        neighbors.add(neighbor);
    }

    @Override
    public void removeNeighbor(GraphNode<T> neighbor) {
        if (!this.neighbors.contains(neighbor)) {
            return;
        }

        neighbors.remove(neighbor);
    }

    @Override
    public Collection<GraphNode<T>> getNeighbors() {
        return neighbors;
    }

    // Rule of thumb: when overriding .equals, override .hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof DirectedGraphNode)) {
            return false;
        }

        DirectedGraphNode other = (DirectedGraphNode) o;
        return this.id == other.id && this.value.equals(other.value);
    }

    // Implementing hashCode is complicated and out of scope for this class,
    // but you should know how it is used
    @Override
    public int hashCode() {
        return Long.valueOf(31 * this.id).hashCode() ^ this.value.hashCode();
    }
}
