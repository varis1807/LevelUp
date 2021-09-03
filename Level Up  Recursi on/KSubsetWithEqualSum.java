import java.util.*;

public class KSubsetWithEqualSum {

      public static void ksubsets(int[] arr, int idx, int[] subsetSum, ArrayList<ArrayList<Integer>> ans) {
            if (idx == arr.length) {
                  int s = subsetSum[0];
                  for (int ele : subsetSum) {
                        if (s != ele) {
                              return;
                        }
                  }

                  for (ArrayList<Integer> a : ans) {
                        System.out.print(a + " ");
                  }
                  System.out.println();

                  return;
            }

            for (int k = 0; k < subsetSum.length; k++) {
                  ArrayList<Integer> set = ans.get(k);
                  set.add(arr[idx]);
                  subsetSum[k] += arr[idx];

                  ksubsets(arr, idx + 1, subsetSum, ans);

                  subsetSum[k] -= arr[idx];
                  set.remove(set.size() - 1);
                  if (set.size() == 0)
                        break;
            }
      }

      public static void equalSet(int[] arr, int k) {
            ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
            for (int i = 0; i < k; i++)
                  ans.add(new ArrayList<>());

            int sum = 0;
            for (int ele : arr)
                  sum += ele;

            if (sum % k != 0)
                  return;

            int[] sumArray = new int[k];
            ksubsets(arr, 0, sumArray, ans);
            System.out.println(ans);
      }

      public static void main(String[] args) {
            int[] arr = { 1, 2, 3 };

            equalSet(arr, 2);
      }
}
