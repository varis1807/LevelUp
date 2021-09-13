import java.util.*;

public class longestIncSS {
      // Memo
      public static int LIS_memo(int[] arr, int ei, int[] dp) {
            if (dp[ei] != 0)
                  return dp[ei];
            int maxLen = 1;
            for (int i = ei - 1; i >= 0; i--) {
                  if (arr[i] < arr[ei]) {
                        int recLen = LIS_memo(arr, i, dp);
                        maxLen = Math.max(maxLen, recLen + 1);
                  }
            }

            return dp[ei] = maxLen;
      }

      public static int LIS_Rec() {
            int[] arr = { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15, 14 };
            int[] dp = new int[arr.length];
            int maxLen = 0;
            for (int i = 0; i < arr.length; i++) {
                  maxLen = Math.max(maxLen, LIS_memo(arr, i, dp));
            }

            return maxLen;
      }
      // tabu

      // 1)Left to Right
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

      // 2) Right to Left
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

}