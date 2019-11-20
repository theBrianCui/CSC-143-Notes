package test;

import org.junit.Test;
import scratch.DirectedGraphNode;

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

    @Test
    public void DiamondTest() {
        DirectedGraphNode<Integer> ten = new DirectedGraphNode<>(1, 10);
        DirectedGraphNode<Integer> five = new DirectedGraphNode<>(2, 5);
        DirectedGraphNode<Integer> nine = new DirectedGraphNode<>(3, 9);
        DirectedGraphNode<Integer> twelve = new DirectedGraphNode<>(4, 12);

        ten.addNeighbor(five);
        ten.addNeighbor(nine);

        five.addNeighbor(twelve);
        nine.addNeighbor(twelve);

        twelve.addNeighbor(ten);

        // one-liner to retrieve a single element out of a Collection
        // this is okay since we "know" twelve only has a single neighbor
        // not general purpose
        assertEquals(ten, twelve.getNeighbors().iterator().next());
    }
}
