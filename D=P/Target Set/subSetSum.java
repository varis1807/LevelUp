import java.util.*;
public class subSetSum {
      // -1 : not explored, 0 : false, 1 : true
      public static int targetSum(int[] arr, int n, int tar, int[][] dp) {
            if (n == 0 || tar == 0) {
                  return dp[n][tar] = (tar == 0 ? 1 : 0);
            }

            if (dp[n][tar] != -1)
                  return dp[n][tar];

            boolean res = false;
            if (tar - arr[n - 1] >= 0)
                  res = res || targetSum(arr, n - 1, tar - arr[n - 1], dp) == 1;
            res = res || targetSum(arr, n - 1, tar, dp) == 1;

            return dp[n][tar] = res ? 1 : 0;
      }

      public static Boolean isSubsetSum(int N, int arr[], int sum) {
            int[][] dp = new int[N + 1][sum + 1];
            for (int[] d : dp)
                  Arrays.fill(d, -1);

            int ans = targetSum(arr, N, sum, dp);

            //display2D(dp);
            return ans == 1;
      }

      public static void main(String[] args) {

      }
}
