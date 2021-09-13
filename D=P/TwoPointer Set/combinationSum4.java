import java.util.*;

public class combinationSum4 {
      public static int combinationSum4_rec(int[] nums, int target) {
            if (target == 0)
                  return 1;
            int ways = 0;
            for (int i = 0; i < nums.length; i++) {
                  if (target - nums[i] >= 0)
                        ways += combinationSum4_rec(nums, target - nums[i]);
            }
            return ways;
      }

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

      public static void display(int[] dp) {
            for (int ele : dp) {
                  System.out.print(ele + " ");
            }
            System.out.println();
      }

      public static void combinationSum4() {
            int[] nums = { 1, 2, 3 };
            int target = 4;
            int[] dp = new int[target + 1];
            Arrays.fill(dp, -1);
            System.out.println(combinationSum4_memo(nums, target, dp));
            display(dp);
      }

      public static void main(String[] args) {
            combinationSum4(); 
      }
}
