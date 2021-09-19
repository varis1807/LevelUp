public class subSetSum {
      public static boolean targetSum_DP(int[] arr, int N, int Tar, boolean[][] dp) {
            for (int n = 0; n <= N; n++) {
                  for (int tar = 0; tar <= Tar; tar++) {
                        if (n == 0 || tar == 0) {
                              dp[n][tar] = (tar == 0);
                              continue;
                        }
                        if (tar - arr[n - 1] >= 0)
                              dp[n][tar] = dp[n][tar] || dp[n - 1][tar - arr[n - 1]];
                        dp[n][tar] = dp[n][tar] || dp[n - 1][tar];
                  }
            }
            return dp[N][Tar];
      }

      // back Engineering
      public static int targetSum_path(int[] arr, int N, boolean[][] dp, int tar, String psf) {
            if (N == 0 || tar == 0) {
                  if (tar == 0) {
                        System.out.println(psf);
                        return 1;
                  }
                  return 0;
            }
            int count = 0;
            if (tar - arr[N - 1] >= 0 && dp[N - 1][tar - arr[N - 1]])
                  count += targetSum_path(arr, N - 1, dp, tar - arr[N - 1], psf + arr[N - 1] + " ");
            if (dp[N - 1][tar])
                  count += targetSum_path(arr, N - 1, dp, tar, psf);
            return count;
      }

      public static void display(boolean[] dp) {
            for (boolean ele : dp) {
                  System.out.print(ele + " | ");
            }
            System.out.println();
      }

      public static void display2D(boolean[][] dp) {
            for (boolean[] d : dp) {
                  display(d);
            }
            System.out.println();
      }

      public static void targetSum_backEngg() {
            int[] arr = { 2, 3, 5, 7 };
            int tar = 10, N = 4;
            boolean[][] dp = new boolean[N + 1][tar + 1];
            targetSum_DP(arr, N, tar, dp);
            // display2D(dp);
            System.out.println(targetSum_path(arr, N, dp, tar, ""));
      }

      public static void main(String[] args) {
            targetSum_backEngg();
      }
}
