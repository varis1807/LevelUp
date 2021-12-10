import java.util.*;

public class kLevelDistance {
      public boolean nodeToRootPath(Node root, Node p, ArrayList<Node> ntr) {
            if (root == null || p == null)
                  return false;

            if (root == p) {
                  ntr.add(root);
                  return true;
            }

            boolean ans = nodeToRootPath(root.left, p, ntr) || nodeToRootPath(root.right, p, ntr);

            if (ans) {
                  ntr.add(root);
            }

            return ans;
      }

      public static void kdown_fill(Node root, int k, List<Integer> ans, Node blocker) {
            if (root == null || k < 0 || root == blocker)
                  return;

            if (k == 0) {
                  ans.add(root.val);
                  return;
            }

            kdown_fill(root.left, k - 1, ans, blocker);
            kdown_fill(root.right, k - 1, ans, blocker);
      }

   
      public List<Integer> distanceK(Node root, Node target, int k) {
            ArrayList<Node> ntr = new ArrayList<>();
            nodeToRootPath(root, target, ntr);
            Node blocker = null;
            List<Integer> ans = new ArrayList<>();
            for (int i = 0; i < ntr.size(); i++) {
                  kdown_fill(ntr.get(i), k - i, ans, blocker);
                  blocker = ntr.get(i);
            }
            return ans;
      }
      // O(1)

      public static int k_far_find(Node root, Node target, int k, List<Integer> ans) {
            if (root == null)
                  return 1;

            if (root == target) {
                  kdown_fill(root, k, ans, null);
                  return 1;
            }

            int left_dis = k_far_find(root.left, target, k, ans);
            int right_dis = k_far_find(root.right, target, k, ans);

            if (left_dis >= 0) {
                  kdown_fill(root, k - left_dis, ans, root.left);
                  return left_dis + 1;
            }

            if (right_dis >= 0) {
                  kdown_fill(root, k - right_dis, ans, root.right);
                  return right_dis + 1;
            }

            return -1;
      }

      public List<Integer> distanceK1(Node root, Node target, int k) {
            List<Integer> ans = new ArrayList<>();
            k_far_find(root, target, k, ans);
            return ans;
      }

}
