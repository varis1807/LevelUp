import java.util.*;

class Node {
      int val;
      Node left;
      Node right;

      Node() {
      }

      Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
      }

      Node(int val) {
            this(val, null, null);
      }
}

public class LCA {
      public boolean find(Node root, int data) {
            if (root == null)
                  return false;
            if (root.val == data)
                  return true;
            return find(root.left, data) || find(root.right, data);
      }
}
