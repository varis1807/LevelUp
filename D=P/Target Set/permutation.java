import java.util.*;

public class permutation {
      // recustion====================================================
      public static int infiPermute_rec(int[] arr, int target, int n) {
            if (target == 0)
                  return 1;
            int count = 0;
            for (int i = n - 1; i >= 0; i--) {
                  if (target - arr[i] >= 0)
                        count += infiPermute_rec(arr, target - arr[i], n);
            }
            return count;
      }

      // Memoization===========================================
      public static int infiPermute_memo1(int[] arr, int target, int n, int[] dp) {
            if (target == 0)
                  return dp[target] = 1;
            if (dp[target] != -1)
                  return dp[target];
            int count = 0;
            for (int i = n - 1; i >= 0; i--) {
                  if (target - arr[i] >= 0)
                        count += infiPermute_memo1(arr, target - arr[i], n, dp);

            }
            return dp[target] = count;
      }

      public static int infiPermute_memo2(int[] arr, int target, int[] dp) {
            if (target == 0)
                  return dp[target] = 1;
            if (dp[target] != -1)
                  return dp[target];
            int count = 0;
            for (int ele : arr) {
                  if (target - ele >= 0)
                        count += infiPermute_memo2(arr, target - ele, dp);

            }
            return dp[target] = count;
      }

      // tabulation====================================================
      public static int infiPermute_tabu(int[] arr, int TARGET, int[] dp) {
            for (int target = 0; target <= TARGET; target++) {
                  if (target == 0) {
                        dp[target] = 1;
                        continue;
                  }

                  int count = 0;
                  for (int ele : arr) {
                        if (target - ele >= 0)
                              count += dp[target - ele];
                  }
                  dp[target] = count;
            }
            return dp[TARGET];
      }

      public static int permutation_DP(int[] arr, int Tar, int[] dp) {
            dp[0] = 1;
            for (int tar = 1; tar <= Tar; tar++) {
                  int count = 0;
                  for (int ele : arr) {
                        if (tar - ele >= 0)
                              count += dp[tar - ele];
                  }
                  dp[tar] = count;
            }
            return dp[Tar];
      }

      // Printing======================================================
      public static void display(int[] dp) {
            for (int ele : dp) {
                  System.out.print(ele + " ");
            }
            System.out.println();
      }

      public static void display2D(int[][] dp) {
            for (int[] d : dp) {
                  display(d);
            }
            System.out.println();
      }

      public static void main(String[] args) {
            int[] arr = { 2, 3, 5 };
            int[] dp = new int[5 + 1];
            Arrays.fill(dp, -1);
            System.out.println(permutation_DP(arr, 5, dp));
            display(dp);
      }
}