public class BinaryTreeCameras {
    /*
    Given a binary tree, we install cameras on the nodes of the tree.
    Each camera at a node can monitor its parent, itself, and its immediate children.
    Calculate the minimum number of cameras needed to monitor all nodes of the tree.

    Example 1:
           []
           /
          
         /  \
       []     []
    Input: [0,0,null,0,0]
    Output: 1
    Explanation: One camera is enough to monitor all nodes if placed as shown.

    Example 2:
                []
                /
              
             /
           []
           /
         
           \
            []
    Input: [0,0,null,0,null,0,null,null,0]
    Output: 2
    Explanation: At least two cameras are needed to monitor all nodes of the tree. The above image shows one of the
    valid configurations of camera placement.

    Note:
        The number of nodes in the given tree will be in the range [1, 1000].
        Every node has value 0.
     */
    //TC: O(n) and O(h) space due to recursion stack
    int cams = 0; //number of cameras in used

    public int minCameraCover(TreeNode root) {
        if (root == null) {
            return 0;
        }

        /*
            if the search returns 0, no nodes are covered with cams hence we return cams + 1 since we use a camera,
            otherwise we return the number of cameras used
         */
        return dfs(root) == 0 ? cams + 1 : cams;
    }

    /*
        2 --> node has a camera
        1 --> Node is already covered with a camera
        0 --> No camera is covering this node
    */
    private int dfs(TreeNode root) {
        /*
            since ideally we start from the second to last level in the tree, we return 1 once we reach the last level since
            putting a cam on the second to last level covers more nodes than starting from the top and going down.
            Ex: given tree               []
                                       /    \
                                      []     []
                                    /    \
                                   []     []
                                  /  \   /   \
                                 []  []  []   []
            starting from the very top, we have to put cams on the second level, and then again on the last level totaling
            6 cameras used. If instead we start from level 3, we only need to use 3 cams 2 in level 3 and one at the root
            the last row of nodes, i.e. the leaves, they will be covered by the
            so when the very last level is reached, we return 1 sine these nodes will be covered
         */
        if (root == null) {
            return 1;
        }
        //check the left then right and then root
        int left = dfs(root.left);
        int right = dfs(root.right);

        /*
            check if we want to add a camera at the current node, i.e. the current node is not covered by a camera, if
            these nodes are not covered, we need to use a cam and return 2 since the node now has a camera
         */
        if (left == 0 || right == 0) {
            cams++;
            return 2;
        }
        //if the current nodes' left or right has a camera, return 1 since its already covered
        else if (left == 2 || right == 2) {
            return 1;
        }
        //no camera's are covering the current node
        else {
            return 0;
        }
    }
}
