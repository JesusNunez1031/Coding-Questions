import java.util.ArrayList;
import java.util.List;

public class postOrder {
    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<Integer> postorder(Node root) {
        return postOrderHelper(root, new ArrayList<Integer>());
    }

    public List<Integer> postOrderHelper(Node root, List<Integer> list) {
        if(root == null) {
            return list;
        }
        for(Node child : root.children) {
            postOrderHelper(child, list);
        }
        list.add(root.val);
        return list;
    }
}
