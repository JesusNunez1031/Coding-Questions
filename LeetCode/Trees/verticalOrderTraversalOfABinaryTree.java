import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class verticalOrderTraversalOfABinaryTree {
    /*
    Given the root of a binary tree, calculate the vertical order traversal of the binary tree.

    For each node at position (x, y), its left and right children will be at positions (x - 1, y - 1) and (x + 1, y - 1)
    respectively.

    The vertical order traversal of a binary tree is a list of non-empty reports for each unique x-coordinate from left
    to right. Each report is a list of all nodes at a given x-coordinate. The report should be primarily sorted by
    y-coordinate from highest y-coordinate to lowest. If any two nodes have the same y-coordinate in the report, the node
    with the smaller value should appear earlier.

    Return the vertical order traversal of the binary tree.

    Example 1:
                3
              /   \
             9     20
                  /  \
                 15   7
    Input: root = [3,9,20,null,null,15,7]
    Output: [[9],[3,15],[20],[7]]
    Explanation: Without loss of generality, we can assume the root node is at position (0, 0):
    The node with value 9 occurs at position (-1, -1).
    The nodes with values 3 and 15 occur at positions (0, 0) and (0, -2).
    The node with value 20 occurs at position (1, -1).
    The node with value 7 occurs at position (2, -2).

    Example 2:
                  1
               /     \
              2       3
             /  \   /   \
            4    5 6     7
    Input: root = [1,2,3,4,5,6,7]
    Output: [[4],[2],[1,5,6],[3],[7]]
    Explanation: The node with value 5 and the node with value 6 have the same position according to the given scheme.
    However, in the report [1,5,6], the node with value 5 comes first since 5 is smaller than 6.

    Constraints:
        The number of nodes in the tree is in the range [1, 1000].
        0 <= Node.val <= 1000
     */

    /*
        Location class, this assigns a coordinate x, y and takes the value of a node in the tree. x is viewed a the
        column and y is the row, therefore, all values with the same x coordinate are in the same vertical position.
     */
    static class Location implements Comparable<Location> {
        int x;
        int y;
        int val;

        public Location(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

        //Overrides the default compareTo in Arraylists so node positions are sorted from left most nodes to rightmost nodes
        @Override
        public int compareTo(Location l) {
        /*
            when comparing a point in the tree, we compare columns, rows, and values if the coordinates are equal
        */
            if (this.x != l.x) {
                return Integer.compare(this.x, l.x);
            }
            if (this.y != l.y) {
                return Integer.compare(l.y, this.y);
            } else {
                //if the coordinates match, the node with the smallest value comes first
                return Integer.compare(this.val, l.val);
            }
        }
    }

    List<Location> locations = null;

    //TC: O(n log n) and O(n) space
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        locations = new ArrayList<>();

        /*
            perform a dfs traversal to add nodes into a list with the coordinates they belong to
            starting from x = 0 and y = 0
        */
        dfs(root, 0, 0);
        Collections.sort(locations);    //sort locations so the left most nodes are first

        //start from the left most node in the tree x < 0
        int x = locations.get(0).x;
        result.add(new ArrayList<>());  //make a new arraylist for the first node

        /*
            search through all the node locations in the list and if the current list of "x" nodes does not match the
            current locations l.x, make a new list since this will hold all nodes of l.x, once the list is made, add the
            node to the last recent list.
         */
        for (Location l : locations) {
            if (x != l.x) {
                x = l.x;
                result.add(new ArrayList<>());
            }
            result.get(result.size() - 1).add(l.val);
        }
        return result;
    }

    //DFS traversal of tree to create TreeNodes with x and y coordinates
    private void dfs(TreeNode root, int x, int y) {
        if (root != null) {
            locations.add(new Location(x, y, root.val));
            /*
                For each node at position (x, y), its left and right children will be at positions
                (x - 1, y - 1) and (x + 1, y - 1) respectively.
            */
            dfs(root.left, x - 1, y - 1);
            dfs(root.right, x + 1, y - 1);
        }
    }
}
