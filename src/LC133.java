import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Leetcode 133. Clone Graph
 * https://leetcode.com/problems/clone-graph/description/
 */

public class LC133 {
    /** Definition for Node class */
    private class Node {
        public int val; // value of a Node
        public List<Node> neighbors; // a list of neighbor Nodes of a Node

        /** Constructor without params */
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        /** Constructor with value
         * @param _val value of a Node
         */
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        /** Constructor with value
         * @param _val value of a Node
         * @param _neighbors a list of neighbor Nodes of a Node
         */
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    Map<Node, Node> visited = new HashMap<>(); // records of copied nodes

    /**
     * Graph, Depth-first Search solution
     * Let V be the number of vertices in the graph, E be the number of edges
     * Time: O(V + E); Space: O(V)
     * @param node input graph
     * @return a deep copy of the input graph
     */
    public Node cloneGraph(Node node) {
        // base case 1: Node is null
        if (node == null) {
            return null;
        }
        // base case 2: the node has already been copied, return its reference
        // avoid create the same node again and run into an infinite loop
        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        // recursive cases
        Node copyNode;
        ArrayList copyNeighbors = new ArrayList<Node>();
        copyNode = new Node(node.val, copyNeighbors);
        visited.put(node, copyNode); // record the copied Node
        for (Node neighbor: node.neighbors) {
            copyNeighbors.add(cloneGraph(neighbor)); // dfs
        }
        return copyNode;
    }

}
