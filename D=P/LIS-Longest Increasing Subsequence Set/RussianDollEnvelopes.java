import java.util.*;
public class RussianDollEnvelopes {
      public static int maxmimumBridge(int[][] arr, int[] dp) {
            Arrays.sort(arr, (a, b) -> {
                  return a[1] - b[1];
            });
            for (int[] v : arr) {
                  for (int a : v) {
                        System.out.print(a + " ");
                  }
                  System.out.println();
            }

            int n = arr.length, maxLen = 0;

            for (int i = 0; i < n; i++) {
                  dp[i] = 1;
                  for (int j = i - 1; j >= 0; j--) {
                        if (arr[i][0] > arr[j][0] && arr[i][1] > arr[j][1]) {
                              dp[i] = Math.max(dp[i], dp[j] + 1);
                        }
                  }
                  maxLen = Math.max(dp[i], maxLen);
            }
            return maxLen;
      }

      public static void display(int[] dp) {
            for (int ele : dp) {
                  System.out.print(ele + "|");
            }
            System.out.println();
      }

      public static void main(String[] args) {

            // int arr[][] ={{8,1},{1,2},{4,3},{3,4},{5,5},{2,6},{6,7},{7,8}};
            int[][] arr = { { 5, 4 }, { 6, 4 }, { 6, 7 }, { 2, 3 } };
            int[] dp = new int[arr.length];
            System.out.println(maxmimumBridge(arr, dp));
            display(dp);
      }
}
