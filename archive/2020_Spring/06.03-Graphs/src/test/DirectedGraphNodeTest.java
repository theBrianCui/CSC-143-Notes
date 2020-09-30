package test;

import org.junit.Before;
import org.junit.Test;
import scratch.DirectedGraphNode;
import scratch.GraphNode;

import java.util.HashSet;

import static junit.framework.TestCase.assertEquals;

public class DirectedGraphNodeTest {

    /**
     * In this directed graph, all edges point downwards
     * except for the edge from 12 to 10. It's like a water slide and ladder.
     *
     *    10  <--.
     *   /  \    |
     *  5    9   |
     *   \  /    |
     *    12 ----'
     */

    DirectedGraphNode<Integer> ten = new DirectedGraphNode<>(1, 10);
    DirectedGraphNode<Integer> five = new DirectedGraphNode<>(2, 5);
    DirectedGraphNode<Integer> nine = new DirectedGraphNode<>(3, 9);
    DirectedGraphNode<Integer> twelve = new DirectedGraphNode<>(4, 12);

    @Before
    public void setUp() {
        ten.addNeighbor(five);
        ten.addNeighbor(nine);

        five.addNeighbor(twelve);
        nine.addNeighbor(twelve);

        twelve.addNeighbor(ten);
    }

    @Test
    public void DiamondTest() {
        // one-liner to retrieve a single element out of a Collection
        // this is okay since we "know" twelve only has a single neighbor
        // not general purpose
        assertEquals(ten, twelve.getNeighbors().iterator().next());
    }

    public Integer TreeSum(DirectedGraphNode<Integer> root) {
               if (root == null) {
            return 0;
        }

        if (root.getNeighbors().size() == 0) {
            return root.getValue();
        }

        Integer sum = root.getValue();
        for (GraphNode<Integer> neighbor : root.getNeighbors()) {
            sum += TreeSum((DirectedGraphNode<Integer>) neighbor);
        }

        return sum;
    }

    /*
     *    10  <--.
     *   /  \    |
     *  5    9   |
     *   \  /    |
     *    12 ----'
     */
    @Test
    public void DiamondSumTest() {
        twelve.removeNeighbor(ten);
        nine.removeNeighbor(twelve);

        assertEquals(Integer.valueOf(36), TreeSum(ten));

        twelve.addNeighbor(ten);
        nine.addNeighbor(twelve);
    }

    public Integer GraphSum(DirectedGraphNode<Integer> root) {
        // maintain a "visited" set to avoid duplicates
        // the visited set is scoped inside this stack frame,
        // and referenced by all recursive calls
        return GraphSumNoDuplicates(new HashSet<>(), root);
    }

    public Integer GraphSumNoDuplicates(HashSet<DirectedGraphNode<Integer>> visited, DirectedGraphNode<Integer> root) {
        if (root == null) {
            return 0;
        }

        if (visited.contains(root)) {
            return 0;
        }

        if (root.getNeighbors().size() == 0) {
            visited.add(root);
            return root.getValue();
        }

        visited.add(root);
        Integer sum = root.getValue();

        for (GraphNode<Integer> neighbor : root.getNeighbors()) {
            sum += GraphSumNoDuplicates(visited, (DirectedGraphNode<Integer>) neighbor);
        }

        return sum;
    }

    /*
     *    10  <--.
     *   /  \    |
     *  5    9   |
     *   \  /    |
     *    12 ----'
     */

    @Test
    public void DiamondGraphSumTest() {
        assertEquals(Integer.valueOf(36), GraphSum(ten));
    }
}
