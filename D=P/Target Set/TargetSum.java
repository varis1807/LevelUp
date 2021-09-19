import java.util.*;

public class TargetSum {
      // rec
      // left to right
      public static int helper_rec1(int[] arr, int target, int idx, long sum) {
            int n = arr.length;
            if (idx == n) {
                  if (target == sum)
                        return 1;
                  else
                        return 0;
            }
            int count = 0;
            count += helper_rec1(arr, target, idx + 1, sum + arr[idx]);
            count += helper_rec1(arr, target, idx + 1, sum - arr[idx]);
            return count;
      }

      // right to left
      public static int helper_rec2(int[] arr, int target, int idx) {
            if (idx == 0) {
                  if (target == 0)
                        return 1;
                  else
                        return 0;
            }
            int count = 0;
            count += helper_rec2(arr, target + arr[idx], idx - 1);
            count += helper_rec2(arr, target - arr[idx], idx - 1);
            return count;
      }

      // memo
      public static int helper_memo(int[] arr, int target, int idx, long sum, int[][] dp) {
            int n = arr.length;
            if (idx == n) {
                  if (target == sum)
                        return dp[idx][(int) sum + 1000] = 1;
                  else
                        return dp[idx][(int) sum + 1000] = 0;
            }
            if (dp[idx][(int) sum + 1000] != -1)
                  return dp[idx][(int) sum + 1000];
            int count = 0;
            count += helper_memo(arr, target, idx + 1, sum + arr[idx], dp);
            count += helper_memo(arr, target, idx + 1, sum - arr[idx], dp);
            return dp[idx][(int) sum + 1000] = count;
      }

      // Tabu
      public static int helper_tabu(int[] arr, int target, int idx, long sum, int[][] dp) {
            int n = arr.length;
            if (idx == n) {
                  if (target == sum)
                        return dp[idx][(int) sum + 1000] = 1;
                  else
                        return dp[idx][(int) sum + 1000] = 0;
            }
            if (dp[idx][(int) sum + 1000] != -1)
                  return dp[idx][(int) sum + 1000];
            int count = 0;
            count += helper_tabu(arr, target, idx + 1, sum + arr[idx], dp);
            count += helper_tabu(arr, target, idx + 1, sum - arr[idx], dp);
            return dp[idx][(int) sum + 1000] = count;
      }

      public static int findTargetSumWays(int[] nums, int target) {
            if (nums == null || nums.length == 0)
                  return 0;
            int n = nums.length;
            int[][] dp = new int[n + 1][2002];
            for (int[] d : dp)
                  Arrays.fill(d, -1);
            return helper_rec2(nums, target, n - 1);

      }

      // 494
      public static int findTargetSumWays(int[] nums, int n, int sum, int target, int[][] dp) {
            if (n == 0) {
                  return dp[n][sum] = target == sum ? 1 : 0;
            }

            if (dp[n][sum] != -1)
                  return dp[n][sum];

            int count = 0;
            count += findTargetSumWays(nums, n - 1, sum + nums[n - 1], target, dp);
            count += findTargetSumWays(nums, n - 1, sum - nums[n - 1], target, dp);

            return dp[n][sum] = count;
      }

      public static int findTargetSumWays1(int[] nums, int target) {
            int sum = 0, n = nums.length;
            for (int ele : nums)
                  sum += ele;
            if (target > sum || target < -sum)
                  return 0;

            int[][] dp = new int[n + 1][2 * sum + 1];
            for (int[] d : dp)
                  Arrays.fill(d, -1);

            return findTargetSumWays(nums, n, sum, sum + target, dp);
      }

      public static void main(String[] args) {
            int[] nums = { 1, 1, 1, 1, 1 };
            System.out.println(findTargetSumWays1(nums, 3));
      }
}
