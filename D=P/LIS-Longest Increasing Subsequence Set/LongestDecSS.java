public class LongestDecSS {
      // tabu Left to Right
      public static int LDS_LR(int[] arr, int[] dp) {
            int n = arr.length, maxLen = 0;
            for (int i = 0; i < n; i++) {
                  dp[i] = 1;
                  for (int j = i - 1; j >= 0; j--) {
                        if (arr[i] < arr[j]) {
                              dp[i] = Math.max(dp[i], dp[j] + 1);
                        }
                  }

                  maxLen = Math.max(dp[i], maxLen);
            }

            return maxLen;
      }

      // tabu Right to left
      public static int LDS_RL(int[] arr, int[] dp) {
            int n = arr.length, maxLen = 0;
            for (int i = n - 1; i >= 0; i--) {
                  dp[i] = 1;
                  for (int j = i + 1; j < n; j++) {
                        if (arr[i] < arr[j]) {
                              dp[i] = Math.max(dp[i], dp[j] + 1);
                        }
                  }

                  maxLen = Math.max(dp[i], maxLen);
            }

            return maxLen;
      }
}
