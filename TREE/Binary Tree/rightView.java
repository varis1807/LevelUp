import java.util.ArrayList;

public class rightView {
      public void rightViewRec(ArrayList ans, Node root, int level) {
            if (root == null)
                  return;

            if (level == ans.size()) {
                  ans.add(root.val);
            }

            rightViewRec(ans, root.right, level + 1);
            rightViewRec(ans, root.left, level + 1);
      }

      public ArrayList<Integer> rightSideView(Node root) {
            ArrayList<Integer> ans = new ArrayList<>();
            rightViewRec(ans, root, 0);
            return ans;
      }

      public static void main(String[] args) {

      }
}
