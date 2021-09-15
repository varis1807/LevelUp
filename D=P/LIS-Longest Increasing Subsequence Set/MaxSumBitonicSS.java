public class MaxSumBitonicSS {
      // https://practice.geeksforgeeks.org/problems/maximum-sum-bitonic-subsequence1857/1
      public static int LSI_LR(int[] arr, int[] dp) {
            int n = arr.length;
            int maxSum = 0;
            for (int i = 0; i < n; i++) {
                  dp[i] = arr[i];
                  for (int j = i - 1; j >= 0; j--) {
                        if (arr[i] > arr[j])
                              dp[i] = Math.max(dp[i], dp[j] + arr[i]);
                  }
                  maxSum = Math.max(maxSum, dp[i]);
            }
            return maxSum;
      }

      public static int LSI_RL(int[] arr, int[] dp) {
            int n = arr.length;
            int maxSum = 0;
            for (int i = n - 1; i >= 0; i--) {
                  dp[i] = arr[i];
                  for (int j = i + 1; j < n; j++) {
                        if (arr[i] > arr[j])
                              dp[i] = Math.max(dp[i], dp[j] + arr[i]);
                  }
                  maxSum = Math.max(maxSum, dp[i]);
            }
            return maxSum;
      }

      public static int LongestBitonicSequence(int[] arr) {
            int n = arr.length, maxSum = 0;
            int[] LIS = new int[n];
            int[] LDS = new int[n];
            LSI_LR(arr, LIS);
            LSI_RL(arr, LDS);
            for (int i = 0; i < n; i++) {
                  maxSum = Math.max(maxSum, LIS[i] + LDS[i] - arr[i]);
            }
            return maxSum;

      }

      public static int maxSumBS(int arr[], int n) {
            return LongestBitonicSequence(arr);
      }
}
