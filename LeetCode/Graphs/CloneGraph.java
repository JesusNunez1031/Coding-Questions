import java.util.*;

public class CloneGraph {
    // Definition for a Node.
    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    //TC: O(E + N) where E is the number of edges and n is the number of nodes
    private Node cloneGraphBFS(Node node) {    //BFS solution
        if (node == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        Map<Node, Node> visited = new HashMap<>();
        visited.put(node, new Node(node.val));

        while (!queue.isEmpty()) {
            Node current_node = queue.remove();

            for (Node neighbor : current_node.neighbors) {
                //if a neighbor of the current_node has not been visited, then add it to the map and queue to be processed
                if (!visited.containsKey(neighbor)) {
                    visited.put(neighbor, new Node(neighbor.val));
                    queue.add(neighbor);
                }
                /*
                    Once the neighbor node has been visited, update the adjacency list, the list will include the
                    current_nodes neighbor
                */
                visited.get(current_node).neighbors.add(visited.get(neighbor));
            }
        }
        //return the new node "node" from visited
        return visited.get(node);
    }

    private HashMap<Node, Node> visited = new HashMap<>();
    private Node cloneGraphDFS(Node node) {     //DFS traversal
        if(node == null) {
            return null;
        }
        //if the node has been visited, we return the clone of the node
        if(visited.containsKey(node)) {
            return visited.get(node);
        }
        //make a clone of the "node" and put it into the map of visited nodes
        Node clone = new Node(node.val);
        visited.put(node, clone);

        //Iterate through the list of neighbors of "node" and add them to the clone
        for(Node neighbor : node.neighbors) {
            clone.neighbors.add(cloneGraphDFS(neighbor));
        }
        //once the recursive stack clears, the initial cloned node of "node" will be left so we return it
        return clone;
    }
}
