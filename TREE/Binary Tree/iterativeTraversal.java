import java.util.*;

public class iterativeTraversal {
      // pre-order
      public static List<Integer> preOrder(Node root) {
            List<Integer> ans = new ArrayList<>();
            if (root == null)
                  return ans;
            LinkedList<Node> st = new LinkedList<>();
            st.addFirst(root);
            while (!st.isEmpty()) {
                  root = st.removeFirst();
                  ans.add(root.val);
                  if (root.right != null)
                        st.addFirst(root.right);
                  if (root.left != null)
                        st.addFirst(root.left);
            }
            return ans;
      }

      // in-order
      public static List<Integer> inOrder(Node root) {
            List<Integer> ans = new ArrayList<>();
            LinkedList<Node> st = new LinkedList<>();
            Node node = root;
            while (true) {
                  if (node != null) {
                        st.addFirst(node);
                        node = node.left;
                  } else {
                        if (st.isEmpty())
                              break;
                        node = st.pop();
                        ans.add(node.val);
                        node = node.right;
                  }
            }
            return ans;
      }

      // post-order
      public static List<Integer> postOrder(Node root) {
            List<Integer> ans = new ArrayList<>();
            LinkedList<Node> st1 = new LinkedList<>();
            LinkedList<Node> st2 = new LinkedList<>();
            if (root == null)
                  return ans;
            st1.addFirst(root);
            while (!st1.isEmpty()) {
                  root = st1.removeFirst();
                  st2.addFirst(root);
                  if (root.left != null)
                        st1.addFirst(root.left);
                  if (root.right != null)
                        st1.addFirst(root.right);
            }
            while (!st2.isEmpty())
                  ans.add(st2.removeFirst().val);

            return ans;
      }

      public static void main(String[] args) {
            // -----------------------------------------------------
            // Node root = new Node(1);
            // root.left = new Node(2);
            // root.right = new Node(7);
            // root.left.left = new Node(3);
            // root.left.right = new Node(4);
            // root.left.right.left = new Node(5);
            // root.left.right.right = new Node(6);
            // System.out.println(preOrder(root));
            // -----------------------------------------------------
            // Node root=new Node(1);
            // root.left=new Node(2);
            // root.right=new Node(3);
            // root.left.left=new Node(4);
            // root.left.right=new Node(5);
            // root.left.right.left=new Node(6);
            // root.left.right.right=new Node(7);
            // System.out.println(inOrder(root));
            // -----------------------------------------------------
            Node root = new Node(1);
            root.left = new Node(2);
            root.right = new Node(3);
            root.left.left = new Node(4);
            root.left.right = new Node(5);
            root.right.left = new Node(6);
            root.right.left.right = new Node(7);
            root.right.left.right.right = new Node(8);
            System.out.println(postOrder(root));
      }
}
