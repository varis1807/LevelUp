import java.util.*;

public class BurnNode {

      public static void getBurningNodesAtSpecificTime(Node root, int time, ArrayList<ArrayList<Integer>> ans,
                  Node blocker) {
            if (root == null || root == blocker)
                  return;

            if (time == ans.size()) {
                  ans.add(new ArrayList<>());
            }

            ans.get(time).add(root.val);

            getBurningNodesAtSpecificTime(root.left, time + 1, ans, blocker);
            getBurningNodesAtSpecificTime(root.right, time + 1, ans, blocker);
      }

      public static int find_burningTre(Node root, Node data, ArrayList<ArrayList<Integer>> ans) {
            if (root == null)
                  return -1;

            if (root == data) {
                  // get every node below this node
                  getBurningNodesAtSpecificTime(root, 0, ans, null);
                  return 1;
            }

            int left_dis = find_burningTre(root.left, data, ans);
            int right_dis = find_burningTre(root.right, data, ans);

            if (left_dis >= 0) {
                  // get nodes
                  getBurningNodesAtSpecificTime(root, left_dis, ans, root.left);
                  return left_dis + 1;
            }

            if (right_dis >= 0) {
                  // get nodes
                  getBurningNodesAtSpecificTime(root, right_dis, ans, root.right);
                  return right_dis + 1;
            }

            return -1;
      }

      public static void burningTree(Node root, Node data) {
            ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
            find_burningTre(root, data, ans);

      }

      public static void main(String[] args) {
            Node root = new Node(12);
            root.left = new Node(13);
            root.right = new Node(10);
            root.right.left = new Node(14);
            root.right.right = new Node(15);
            root.right.left.left = new Node(21);
            root.right.left.right = new Node(24);
            root.right.right.left = new Node(22);
            root.right.right.right = new Node(23);

      }
}

// Burn the binary tree starting from the target node
// Difficulty Level : Hard
// Last Updated : 25 Sep, 2021
// Given a binary tree and target node. By giving the fire to the target node
// and fire starts to spread in a complete tree. The task is to print the
// sequence of the burning nodes of a binary tree.
// Rules for burning the nodes :

// Fire will spread constantly to the connected nodes only.
// Every node takes the same time to burn.
// A node burns only once.
// Examples:

// Attention reader! Don’t stop learning now. Get hold of all the important DSA
// concepts with the DSA Self Paced Course at a student-friendly price and
// become industry ready. To complete your preparation from learning a language
// to DS Algo and many more, please refer Complete Interview Preparation Course.

// In case you wish to attend live classes with experts, please refer DSA Live
// Classes for Working Professionals and Competitive Programming Live for
// Students.

// Input :
// 12
// / \
// 13 10
// / \
// 14 15
// / \ / \
// 21 24 22 23
// target node = 14

// Output :
// 14
// 21, 24, 10
// 15, 12
// 22, 23, 13

// Explanation : First node 14 burns then it gives fire to it's
// neighbors(21, 24, 10) and so on. This process continues until
// the whole tree burns.

// Input :
// 12
// / \
// 19 82
// / / \
// 41 15 95
// \ / / \
// 2 21 7 16
// target node = 41

// Output :
// 41
// 2, 19
// 12
// 82
// 15, 95
// 21, 7, 16