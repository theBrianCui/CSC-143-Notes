package test;

import org.junit.Test;
import scratch.DirectedGraphNode;

public class DirectedGraphNodeTest {

    /**
     * In this directed graph, all edges point downwards
     * except for the edge from 12 to 10.
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
    }
}
