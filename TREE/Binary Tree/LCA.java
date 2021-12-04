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
      public boolean find(Node root, Node data) {
            if (root == null || data == null)
                  return false;
            if (root == data)
                  return true;
            return find(root.left, data) || find(root.right, data);
      }
      public static boolean nTrP(Node root,Node data,ArrayList<Node> nTr){
            if(root==null || data==null)
            return false;
            boolean ans=false;
            if(root==data)
            nTr.add(root); 
            
            
            return ans;
      }
      public Node lowestCommonAncestor(Node root, Node p, ArrayList<TreeNode)
}
