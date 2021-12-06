import java.util.*;

public class iterativeTraversal {
      // pre-order
      public static List<Integer> preOrder(Node root) {
            List<Integer> ans = new ArrayList<>();
            if (root == null)
                  return ans;
            LinkedList<Node> st = new LinkedList<>();
            st.addLast(root);
            while (st.isEmpty()) {
                  root = st.removeFirst();
                  ans.add(root.val);
                  if (root.right != null)
                        st.addFirst(root.right);
                  if (root.left != null)
                        st.addFirst(root.left);
            }
            return ans;
      }

      public static void main(String[] args) {
            Node root = new Node(1);
            root.left = new Node(2);
            root.right = new Node(7);
            root.left.left = new Node(3);
            root.left.right = new Node(4);
            root.left.right.left = new Node(5);
            root.left.right.right = new Node(6);
      }
}
