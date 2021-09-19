public class canPartition {
      public static int targetSum_tabu(int[] arr, int N, int TAR, int[][] dp) {
            for (int n = 0; n <= N; n++) {
                  for (int tar = 0; tar <= TAR; tar++) {
                        if (n == 0 || tar == 0) {
                              dp[n][tar] = (tar == 0 ? 1 : 0);
                              continue;
                        }
                        boolean res = false;
                        if (tar - arr[n - 1] >= 0)
                              res = res || dp[n - 1][tar - arr[n - 1]] == 1;
                        res = res || dp[n - 1][tar] == 1;

                        dp[n][tar] = res ? 1 : 0;
                  }
            }
            return dp[N][TAR];
      }

      // 416
      public static boolean canPartition(int[] nums) {
            int sum = 0;
            for (int ele : nums)
                  sum += ele;

            if (sum % 2 != 0)
                  return false;
            int tar = sum / 2, n = nums.length;
            int[][] dp = new int[n + 1][tar + 1];
            int ans = targetSum_tabu(nums, n, tar, dp);
            return ans == 1;
      }

      public static void main(String[] args) {
            int[] nums = { 1, 3, 4, 8, 16,1 };
            System.out.println(canPartition(nums));
      }
}
