package leetCode.trees;

import java.util.*;

public class allNodesDistanceKInBinaryTree {
    /*
    We are given a binary tree (with root node root), a target node, and an integer value K.
    Return a list of the values of all nodes that have a distance K from the target node.  The answer can be returned in any order.

    Example 1:
    Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2

    Output: [7,4,1]

    Explanation:
    The nodes that are a distance 2 from the target node (with value 5)
    have values 7, 4, and 1.

            3
         /     \
        5       1 ←
      /   \    /  \
     6     2  0    8
          / \
         7←  4 ←



    Note that the inputs "root" and "target" are actually TreeNodes.
    The descriptions of the inputs above are just serializations of these objects.

    Note:
        The given tree is non-empty.
        Each node in the tree has unique values 0 <= node.val <= 500.
        The target node is a node in the tree.
        0 <= K <= 1000.
     */
    //TC/S: O(n)
    private List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> kdist = new ArrayList<>();    //list to hold nodes k distance from target

        if (root == null) {
            return kdist;
        }

        Map<TreeNode, TreeNode> parents = new HashMap<>();   //map to hold the parent of each node in tree
        buildAdjacencyList(root, root, parents);    //build the map of parent nodes

        Set<TreeNode> seen = new HashSet<>();   //keeps track of visited nodes
        Queue<TreeNode> queue = new LinkedList<>();
        //start from the target node
        queue.add(target);
        seen.add(target);
        int level = 0;  //when level == k, we will have all nodes k distance from the target

        while (!queue.isEmpty()) {
            int size = queue.size();
            //when we reach the k distance level, add all the nodes in the queue to the result list and return list
            if (level == k) {
                while (!queue.isEmpty()) {
                    kdist.add(queue.remove().val);
                }
                return kdist;
            }

            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.remove();

                //add the nodes left and right to current node if they haven't yet been seen
                if (curr.left != null && !seen.contains(curr.left)) {
                    queue.add(curr.left);
                    seen.add(curr.left);
                }

                if (curr.right != null && !seen.contains(curr.right)) {
                    queue.add(curr.right);
                    seen.add(curr.right);
                }
                /*
                    if the parent of the current node has not yet been seen, add it to queue and mark it as seen. We do
                    this since the target node can be deep into the tree so we need to check above us
                */
                TreeNode curr_parent = parents.get(curr);
                if (!seen.contains(curr_parent)) {
                    queue.add(curr_parent);
                    seen.add(curr_parent);
                }
            }
            level++;
        }
        return kdist;
    }

    /*
        Do a pre-order traversal on the tree and set the parents of each node by passing the current node as the parent
        and either the left or right as the child
     */
    private void buildAdjacencyList(TreeNode root, TreeNode parent, Map<TreeNode, TreeNode> parents) {
        if (root == null) {
            return;
        }
        parents.put(root, parent);
        buildAdjacencyList(root.left, root, parents);
        buildAdjacencyList(root.right, root, parents);
    }
}
