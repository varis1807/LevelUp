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

      // leet 236 =============================================
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

      public Node lowestCommonAncestor(Node root, Node p, Node q) {
            ArrayList<Node> ntr1 = new ArrayList<>();
            nodeToRootPath(root, p, ntr1);

            ArrayList<Node> ntr2 = new ArrayList<>();
            nodeToRootPath(root, q, ntr2);

            int i = ntr1.size() - 1;
            int j = ntr2.size() - 1;

            while (i >= 0 && j >= 0 && ntr1.get(i) == ntr2.get(j)) {
                  i--;
                  j--;
            }

            i++;
            return ntr1.get(i);
      }

      // lca optimized (no extra space)
      Node lca = null;

      public boolean find(Node root, Node p, Node q) {
            if (root == null)
                  return false;

            boolean left = find(root.left, p, q);
            boolean right = find(root.right, p, q);

            // getting true from left and right
            if (left && right) {
                  lca = root;
            }

            // one data is root, another is on the left side or right side
            if (root == p || root == q) {
                  if (left || right) {
                        lca = root;
                  }
                  return true;
            }

            // if(root==q){
            // if(left || right){
            // lca=root;
            // }
            // return true;
            // }

            return left || right;
      }

  public Node lowestCommonAncestor1(Node root, Node p, Node q) {
      find(root,p,q);
      return lca;
  }

  

}
