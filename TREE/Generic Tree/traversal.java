import java.util.*;

class Node {
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
};

public class traversal {
      // post order
      List<Integer> ans = new ArrayList<>();

      public List<Integer> postorder(Node root) {
            if (root == null)
                  return ans;
            for (Node child : root.children)
                  postorder(child);
            ans.add(root.val);
            return ans;
      }
      public static void main(String[] args){

      }
}