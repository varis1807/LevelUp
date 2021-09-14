public class minDeletion {
      public static int minDeletion(int[] arr) {
            int n = arr.length, maxLen = 0;
            int[] dp = new int[n];
            for (int i = 0; i < n; i++) {
                dp[i] = 1;
                for (int j = i - 1; j >= 0; j--) {
                    if (arr[i] >= arr[j]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
                maxLen = Math.max(dp[i], maxLen);
            }
    
            return arr.length - maxLen;
        }
}
