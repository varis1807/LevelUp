import java.util.*;

public class verticalOrder {
      // vertical order =======================================================

      static class pair {
            Node node;
            int vl;

            public pair(Node node, int vl) {
                  this.node = node;
                  this.vl = vl;
            }
      }

      public static void findWidth(Node root, int[] minMax, int vl) {
            if (root == null)
                  return;

            minMax[0] = Math.min(minMax[0], vl);
            minMax[1] = Math.max(minMax[1], vl);

            findWidth(root.left, minMax, vl - 1);
            findWidth(root.right, minMax, vl + 1);
      }

      public static ArrayList<ArrayList<Integer>> verticalOrder(Node root) {
            int[] minMax = new int[2];

            findWidth(root, minMax, 0);

            int width = minMax[1] - minMax[0] + 1;

            ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

            for (int i = 0; i < width; i++) {
                  ans.add(new ArrayList<>());
            }

            // recursively vertical order ================

            // vertical_rec(root,0,ans,Math.abs(minMax[0]));

            // without recursion (using level order)
            // insert those elements in vertcial order first which are coming first in level
            // order
            int shift = -minMax[0];
            Queue<pair> q = new LinkedList<>();

            q.add(new pair(root, 0));

            while (q.size() > 0) {
                  int size = q.size();

                  while (size-- > 0) {
                        pair top = q.remove();

                        ans.get(top.vl + shift).add(top.node.val);

                        if (top.node.left != null) {
                              q.add(new pair(top.node.left, top.vl - 1));
                        }

                        if (top.node.right != null) {
                              q.add(new pair(top.node.right, top.vl + 1));
                        }
                  }
            }
            return ans;
      }           
}
