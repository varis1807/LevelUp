import java.util.*;

public class TwoSet_EuqualSum2 {
      public static void equalSet(int[] arr, int idx, int sum, ArrayList<ArrayList<Integer>> ans) {
            // ArrayList<Integer> ans1 = new ArrayList<>();
            if (arr.length == idx) {
                 ans.add(new ArrayList<>(sum));
                  System.out.println(sum);
            }

            // for (int i = idx; i < arr.length; i++) {
            // ans1.add(arr[i]);
            // if (idx == arr.length)
                  equalSet(arr, idx + 1, sum + arr[idx], ans);
            // ans1.remove(ans1.size() - 1);

      }

      public static void equalSet(int[] arr, int idx) {
            ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
            ArrayList<Integer> ans1 = new ArrayList<>();

            for (int i = 0; i < 2; i++)
                  ans.add(new ArrayList<>());

            int sum = 0;
            equalSet(arr, 0, sum / 2, ans);
            for (int ele : arr)
                  sum += ele;

            if ((sum & 1) != 0)
                  return;

            System.out.println(ans);
      }

      public static void main(String[] args) {
            int[] arr = { 10, 30, 40 };
            ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
            // equalSet(arr, 0);
            equalSet(arr, 0, 0, ans);
      }
}
