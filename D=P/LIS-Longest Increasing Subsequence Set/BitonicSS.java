public class BitonicSS {
      public static int LIS_LR(int[] arr, int[] dp) {
            int n = arr.length, maxLen = 0;
            for (int i = 0; i < n; i++) {
                dp[i] = 1;
                for (int j = i - 1; j >= 0; j--) {
                    if (arr[i] > arr[j]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
    
                maxLen = Math.max(dp[i], maxLen);
            }
    
            return maxLen;
        }
    
        public static int LIS_RL(int[] arr, int[] dp) {
            int n = arr.length, maxLen = 0;
            for (int i = n - 1; i >= 0; i--) {
                dp[i] = 1;
                for (int j = i + 1; j < n; j++) {
                    if (arr[i] > arr[j]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
    
                maxLen = Math.max(dp[i], maxLen);
            }
    
            return maxLen;
        }

      public static int bitonicSequence(int[] arr) {
            int n = arr.length, maxLen = 0;
            int[] LIS = new int[n];
            int[] LDS = new int[n];

            LIS_LR(arr, LIS);
            LIS_RL(arr, LDS);

            for (int i = 0; i < n; i++) {
                  maxLen = Math.max(maxLen, LIS[i] + LDS[i] - 1);
            }

            return maxLen;
      }

      // Mimimum deletetion required to make array sorted.
}
