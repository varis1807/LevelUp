import java.util.*;

public class leftViewOfBT {
      public static List<Integer> leftview(Node root) {
            LinkedList<Node> que = new LinkedList<>();
            List<Integer> ans = new ArrayList<>();
            que.addLast(root);
            while (!que.isEmpty()) {
                  int size = que.size();
                  boolean first = true;
                  while (size-- > 0) {
                        Node top = que.getFirst();
                        que.removeFirst();
                        if (first) {
                              ans.add(top.val);
                              first = false;
                        }
                        if (top.left != null)
                              que.addLast(top.left);
                        if (top.right != null)
                              que.addLast(top.right);
                  }
            }
            return ans;
      }

      // recursion
      public static void leftViewRec(ArrayList<Integer> ans, Node root, int level) {
            if (root == null)
                  return;

            if (level == ans.size()) {
                  ans.add(root.val);
            }

            leftViewRec(ans, root.left, level + 1);
            leftViewRec(ans, root.right, level + 1);
      }

      public static ArrayList<Integer> leftView(Node root) {
            ArrayList<Integer> ans = new ArrayList<>();
            leftViewRec(ans, root, 0);

            return ans;
      }

      public static void main(String[] args) {
            Node root = new Node(4);
            root.left = new Node(5);
            root.right = new Node(2);
            root.right.left = new Node(3);
            root.right.right = new Node(1);
            root.right.left.left = new Node(6);
            root.right.left.right = new Node(7);
            System.out.println(leftview(root));
      }
}
