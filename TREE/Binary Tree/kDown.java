import java.util.*;
public class kDown {
      // k down in a binary tree =====================
      public void fill(Node root, List<Integer> ans, int k, int blocker) {
            if (root == null)
                  return;

            if (k == 0) {
                  ans.add(root.val);
                  return;
            }

            fill(root.left, ans, k - 1, blocker);
            fill(root.right, ans, k - 1, blocker);
      }
}
