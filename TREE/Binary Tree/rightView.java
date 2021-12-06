import java.util.ArrayList;

public class rightView {
      public static void rightViewRec(ArrayList<Integer> ans, Node root, int level) {
            if (root == null)
                  return;

            if (level == ans.size()) {
                  ans.add(root.val);
            }

            rightViewRec(ans, root.right, level + 1);
            rightViewRec(ans, root.left, level + 1);
      }

      public static ArrayList<Integer> rightSideView(Node root) {
            ArrayList<Integer> ans = new ArrayList<>();
            rightViewRec(ans, root, 0);
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
            System.out.println(rightSideView(root));
      }
}
