import java.util.*;

public class HouseRobber1 {
      public int rob(int[] arr, int si, int ei, int[] dp) {
            if (si > ei)
                  return 0;

            if (dp[si] != -1)
                  return dp[si];

            int robCurrHouse = arr[si] + rob(arr, si + 2, ei, dp);
            int notRobCurrHouse = rob(arr, si + 1, ei, dp);

            return dp[si] = Math.max(robCurrHouse, notRobCurrHouse);
      }

      public int rob(int[] nums) {
            int n = nums.length;
            if (n == 0 || n == 1) {
                  return n == 1 ? nums[0] : 0;
            }
            int[] dp1 = new int[n];
            Arrays.fill(dp1, -1);

            int[] dp2 = new int[n];
            Arrays.fill(dp2, -1);

            return Math.max(rob(nums, 0, n - 1, dp1), rob(nums, 1, n - 2, dp2));

      }

      // 2nd method
      // 198
      public int rob_I(int[] arr, int n, int[] dp) {
            if (n <= 0)
                  return 0;

            if (dp[n] != -1)
                  return dp[n];

            int robCurrHouse = arr[n - 1] + rob_I(arr, n - 2, dp);
            int notRobCurrHouse = rob_I(arr, n - 1, dp);

            return dp[n] = Math.max(robCurrHouse, notRobCurrHouse);
      }

      public int rob_I(int[] nums) {
            int n = nums.length;
            if (n == 0 || n == 1) {
                  return n == 1 ? nums[0] : 0;
            }
            int[] dp = new int[n + 1];
            Arrays.fill(dp, -1);

            return rob_I(nums, n, dp);
      }
}
