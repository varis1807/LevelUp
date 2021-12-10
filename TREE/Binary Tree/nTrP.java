import java.util.*;

public class nTrP {

      public static boolean ntrp(Node root, int data) {
            ArrayList<Integer> ans = new ArrayList<>();
            if (root == null)
                  return false;
            ;
            if (root.val == data) {
                  ans.add(root.val);
                  return true;
            }
            boolean res = ntrp(root.left, data) || ntrp(root.right, data);
            if (res)
                  ans.add(root.val);

            System.out.println(ans);
            return res;

      }

      public static void main(String[] args) {
            Node root = new Node(1);
            root.left = new Node(2);
            root.right = new Node(3);
            root.right.left = new Node(4);
            root.right.right = new Node(5);
            root.right.left.left = new Node(6);
            root.right.left.right = new Node(7);
            root.right.left.right.left = new Node(8);
            root.right.left.right.left = new Node(9);
            System.out.println(ntrp(root, 9));
      }
}
