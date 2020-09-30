package scratch;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class TreeNode<T> {
    public ArrayList<TreeNode<T>> children;
    public T payload;

    public TreeNode(T payload) {
        this.payload = payload;
        this.children = new ArrayList<>();
    }

    public TreeNode(T payload, ArrayList<TreeNode<T>> children) {
        this.payload = payload;
        this.children = children;
    }

    public int addChild(TreeNode<T> child) {
        if (children == null) {
            children = new ArrayList<TreeNode<T>>();
        }

        children.add(child);
        return children.size() - 1;
    }

    public TreeNode<T> getChild(int index) {
        if (children == null) {
            throw new NoSuchElementException();
        }

        return children.get(index);
    }
}
