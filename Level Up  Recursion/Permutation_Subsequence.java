import java.util.*;

public class Permutation_Subsequence {
      // public static void getPermutation(int n, int k, String ans1, boolean vis[],
      // int tar, List<Integer> arr,
      // List<List<Integer>> ans) {
      // if (tar == 0) {
      // // arr.add(ans);
      // ans.add(new ArrayList<Integer>(arr));
      // // System.out.print(ans);
      // // System.out.println();
      // return;
      // }
      // for (int i = 1; i <= n; i++) {

      // if (!vis[i]) {
      // vis[i] = true;
      // arr.add(i);
      // getPermutation(n, k, ans1 + i, vis, tar - 1, arr, ans);
      // arr.remove(arr.size() - 1);
      // vis[i] = false;
      // }
      // }

      // }

      // public static List<List<Integer>> getPermutation(int n, int k) {
      // String ans1 = "";
      // int tar = n;
      // boolean[] vis = new boolean[n + 1];
      // List<Integer> arr = new ArrayList<>();
      // List<List<Integer>> ans = new ArrayList<List<Integer>>();
      // getPermutation(n, k, ans1, vis, tar, arr, ans);
      // return ans;
      // }
      public static void getPermutation(int n, int k, String ans1, boolean vis[], int tar, List<String> arr,
                  List<List<Integer>> ans) {
            if (tar == 0) {
                  arr.add(ans1);
                  // ans.add(new ArrayList<Integer>(arr));
                  // System.out.print(ans);
                  // System.out.println();
                  return;
            }
            for (int i = 1; i <= n; i++) {

                  if (!vis[i]) {
                        vis[i] = true;
                        // arr.add(i);
                        getPermutation(n, k, ans1 + i, vis, tar - 1, arr, ans);
                        // arr.remove(arr.size() - 1);
                        vis[i] = false;
                  }
            }

      }

      public static String getPermutation(int n, int k) {
            String ans1 = "";
            int tar = n;
            boolean[] vis = new boolean[n + 1];
            List<String> arr = new ArrayList<>();
            List<List<Integer>> ans = new ArrayList<List<Integer>>();
            getPermutation(n, k, ans1, vis, tar, arr, ans);
            System.out.println(arr);
            // for(String k1:arr){
            //       System.out.println(k1);
            // }
            for(int k1=0; k1<arr.size(); k1++){
               if(k1==k)
               System.out.println(arr.get(k1));
            }
            return ans1;
      }

      public static void main(String[] args) {
            System.out.println(getPermutation(3, 3));
      }
}
