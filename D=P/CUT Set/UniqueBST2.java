import java.util.*;

public class UniqueBST2 {
      // 95
      public static class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;

            TreeNode() {
            }

            TreeNode(int val) {
                  this.val = val;
            }

            TreeNode(int val, TreeNode left, TreeNode right) {
                  this.val = val;
                  this.left = left;
                  this.right = right;
            }
      }

      // Recursion
      public List<TreeNode> generateTrees(int si, int ei) {
            List<TreeNode> list = new ArrayList<TreeNode>();

            if (si > ei) {
                  list.add(null);
                  return list;
            }
            if (si == ei) {
                  list.add(new TreeNode(si));
                  return list;
            }
            List<TreeNode> left, right;
            for (int cut = si; cut <= ei; cut++) {
                  left = generateTrees(si, cut - 1);
                  right = generateTrees(cut + 1, ei);
                  for (TreeNode Lnode : left) {
                        for (TreeNode Rnode : right) {
                              TreeNode root = new TreeNode(cut);
                              root.left = Lnode;
                              root.right = Rnode;
                              list.add(root);
                        }
                  }
            }
            return list;

      }

      // tabulation
      public static void generateAlllBST(List<TreeNode> leftList, List<TreeNode> rightList, List<TreeNode> ans,
                  int num) {
            for (TreeNode ln : leftList) {
                  for (TreeNode rn : rightList) {
                        TreeNode root = new TreeNode(num);
                        root.left = ln;
                        root.right = rn;
                        ans.add(root);
                  }
            }
      }

      public static List<TreeNode> generateTrees(int si, int ei, List<TreeNode>[][] dp) {
            List<TreeNode> myAns = new ArrayList<>();
            if (si >= ei) {
                  TreeNode root = (si == ei ? new TreeNode(si) : null);
                  myAns.add(root);
                  return myAns;
            }

            if (dp[si][ei] != null)
                  return dp[si][ei];

            for (int cut = si; cut <= ei; cut++) {
                  List<TreeNode> leftList = generateTrees(si, cut - 1, dp);
                  List<TreeNode> rightList = generateTrees(cut + 1, ei, dp);

                  generateAlllBST(leftList, rightList, myAns, cut);
            }

            return dp[si][ei] = myAns;
      }

      public static List<TreeNode> generateTrees(int n) {
            List<TreeNode>[][] dp = new ArrayList[n][n];
            return generateTrees(1, n, dp);
      }

      public static void main(String[] args) {

      }
}
