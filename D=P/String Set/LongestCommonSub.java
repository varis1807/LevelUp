import java.util.*;

public class LongestCommonSub {
      public static void display(int[] dp) {
            for (int ele : dp) {
                  System.out.print(ele + "   ");
            }
            System.out.println();
      }

      public static void display2D(int[][] dp) {
            for (int[] d : dp) {
                  display(d);
            }
            System.out.println();
      }

      // Rec
      public static int lcss_rec(String str1, String str2, int n, int m) {
            if (n == 0 || m == 0) {
                  return 0;
            }

            if (str1.charAt(n - 1) == str2.charAt(m - 1))
                  return lcss_rec(str1, str2, n - 1, m - 1) + 1;
            else
                  return Math.max(lcss_rec(str1, str2, n - 1, m), lcss_rec(str1, str2, n, m - 1));

      }

      // MEmo
      public static int lcss_memo(String str1, String str2, int n, int m, int[][] dp) {
            if (n == 0 || m == 0) {
                  return dp[n][m] = 0;
            }

            if (dp[n][m] != -1)
                  return dp[n][m];

            if (str1.charAt(n - 1) == str2.charAt(m - 1))
                  dp[n][m] = lcss_memo(str1, str2, n - 1, m - 1, dp) + 1;
            else
                  dp[n][m] = Math.max(lcss_memo(str1, str2, n - 1, m, dp), lcss_memo(str1, str2, n, m - 1, dp));

            return dp[n][m];
      }

      // tabu
      public static int lcss_DP(String str1, String str2, int N, int M, int[][] dp) {
            for (int n = 0; n <= N; n++) {
                  for (int m = 0; m <= M; m++) {
                        if (n == 0 || m == 0) {
                              dp[n][m] = 0;
                              continue;
                        }

                        if (str1.charAt(n - 1) == str2.charAt(m - 1))
                              dp[n][m] = dp[n - 1][m - 1] + 1;// lcss(str1, str2, n - 1, m - 1, dp) + 1;
                        else
                              dp[n][m] = Math.max(dp[n - 1][m], dp[n][m - 1]);
                  }
            }

            return dp[N][M];
      }

      public static int longestCommonSubsequence(String text1, String text2) {
            int n = text1.length(), m = text2.length();
            int[][] dp = new int[n + 1][m + 1];
            for (int[] d : dp)
                  Arrays.fill(d, -1);
            int ans = lcss_memo(text1, text2, n, m,dp);
            display2D(dp);
            return ans;
      }

      public static void main(String[] args) {
            System.out.println(longestCommonSubsequence("abcde", "ace"));
      }
}
