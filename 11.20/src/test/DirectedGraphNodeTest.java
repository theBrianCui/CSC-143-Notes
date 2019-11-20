package test;

import org.junit.Before;
import org.junit.Test;
import scratch.DirectedGraphNode;
import scratch.GraphNode;

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

        Integer total = 0;
        for (GraphNode<Integer> neighbor : root.getNeighbors()) {

            // Unsafe cast, but OK for demonstration since "we know" it's a DGN
            total += TreeSum((DirectedGraphNode<Integer>) neighbor);
        }

        return total;
    }

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
    @Test
    public void DiamondSumTest() {

    }
}
