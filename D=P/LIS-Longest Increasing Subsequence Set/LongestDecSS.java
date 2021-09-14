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
                        if (arr[i] > arr[j]) {
                              dp[i] = Math.max(dp[i], dp[j] + 1);
                        }
                  }

                  maxLen = Math.max(dp[i], maxLen);
            }

            return maxLen;
      }

      public static void LIS_Rec() {
            // int[] arr = { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15, 14 };
            int arr[] = { 50, 3, 10, 7, 40, 80 };
            int[] dp = new int[arr.length];
            System.out.println(LDS_LR(arr, dp));
            display(dp);
      }

      public static void display(int[] dp) {
            for (int ele : dp) {
                  System.out.print(ele + "|");
            }
            System.out.println();
      }

      public static void main(String[] args) {
            LIS_Rec();
      }
}
