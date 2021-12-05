import java.util.*;

public class kDown {
      // k down in a binary tree =====================
      public static void fill(Node root, List<Integer> ans, int k) {
            if (root == null)
                  return;

            if (k == 0) {
                  ans.add(root.val);
                  return;
            }

            fill(root.left, ans, k - 1);
            fill(root.right, ans, k - 1);
      }

      public static void main(String[] args) {
            Node root = new Node(1);
            root.left = new Node(2);
            root.right = new Node(3);
            root.left.left = new Node(4);
            root.left.right = new Node(5);
            root.right.left = new Node(6);
            root.right.right = new Node(7);
            List<Integer> ans = new ArrayList<>();
            fill(root, ans, 2);
            System.out.println(ans);
      }
}
