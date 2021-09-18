import java.util.*;

public class CombinationSum4 {
      // Recursion
      public static int combinationSum4_helper(int[] nums, int target, int[][] dp, int idx) {
            int n = nums.length - 1;
            if (idx == nums.length || target == 0) {
                  if (target == 0) {
                        return dp[idx][target] = 1;

                  } else
                        return 0;
            }

            if (dp[idx][target] != 0)
                  return dp[idx][target];
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                  if (target - nums[i] >= 0)
                        count += combinationSum4_helper(nums, target - nums[i], dp, 0);
            }
            return dp[idx][target] = count;
      }

      public int combinationSum4_rec(int[] nums, int target) {
            int idx = nums.length + 1;
            int[][] dp = new int[idx][target + 1];
            return combinationSum4_helper(nums, target, dp, 0);
      }

      // Memoization
      public static int combinationSum4_memo(int[] nums, int target, int[] dp) {
            if (target == 0)
                  return dp[target] = 1;

            if (dp[target] != -1)
                  return dp[target];
            int ways = 0;
            for (int i = 0; i < nums.length; i++) {
                  if (target - nums[i] >= 0)
                        ways += combinationSum4_memo(nums, target - nums[i], dp);
            }
            return dp[target] = ways;
      }

      // Tabulation
      public static int combinationSum4_tabu(int[] nums, int TARGET, int[] dp) {
            for (int target = 0; target <= TARGET; target++) {
                  if (target == 0) {
                        dp[target] = 1;
                        continue;
                  }
                  int ways = 0;
                  for (int i = 0; i < nums.length; i++) {
                        if (target - nums[i] >= 0)
                              ways += dp[target - nums[i]];
                  }
                  dp[target] = ways;
            }

            return dp[TARGET];
      }

      public static int combinationSum4(int[] nums, int target) {
            int[] dp = new int[target + 1];
            Arrays.fill(dp, -1);
            return combinationSum4_tabu(nums, target, dp);
      }

}
