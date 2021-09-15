import java.util.*;

public class LCSubSeq {
      public static void LCSS(String s1, String s2, int row, int col, int[][] dp, StringBuilder asf) {
            while (row > 0 && col > 0) {
                  if (s1.charAt(row - 1) == s2.charAt(col - 1)) {
                        asf.append(s2.charAt(col - 1));
                        row--;
                        col--;
                  } else {
                        if (dp[row - 1][col] > dp[row][col - 1])
                              row--;
                        else
                              col--;
                  }
            }
            System.out.println(asf);
      }

      // // tabulation
      public static int lcss_DP(String str1, String str2, int N, int M, int[][] dp) {
            StringBuilder sb = new StringBuilder();
            for (int n = 0; n <= N; n++) {
                  for (int m = 0; m <= M; m++) {
                        if (n == 0 || m == 0) {
                              dp[n][m] = 0;
                              continue;
                        }

                        if (str1.charAt(n - 1) == str2.charAt(m - 1)) {
                              dp[n][m] = dp[n - 1][m - 1] + 1;
                        } else
                              dp[n][m] = Math.max(dp[n - 1][m], dp[n][m - 1]);
                  }
            }
            int cur = 0;
            for (int i = 0; i < dp.length; i++) {
                  for (int j = 0; j < dp[0].length; j++) {
                        if (dp[i][j] > cur) {
                              cur = dp[i][j];
                              sb.append(str1.charAt(i - 1));
                        }
                  }
            }
            System.out.println(sb);
            return dp[N][M];
      }

      public static void main(String[] args) {
            String s1 = "xyzabcde";
            String s2 = "abcxyze";
            int n = s1.length();
            int m = s2.length();
            int row = n;
            int col = m;
            int[][] dp = new int[n + 1][m + 1];
            StringBuilder sb = new StringBuilder();
            LCSS(s1, s2, row, col, dp, sb);
      }
}

//
