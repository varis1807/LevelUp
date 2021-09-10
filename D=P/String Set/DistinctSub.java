import java.util.*;

public class DistinctSub {
      // Recursion
      public int numDistinct_rec(String s, String t, int n, int m) {
            if (m == 0)
                  return 1;
            if (n == 0)
                  return 0;

            if (s.charAt(n - 1) == t.charAt(m - 1)) {
                  return numDistinct_rec(s, t, n - 1, m - 1) + numDistinct_rec(s, t, n - 1, m);

            } else {
                  return numDistinct_rec(s, t, n - 1, m);
            }
      }

      // Memo
      public int numDistinct_memo(String s, String t, int n, int m, int[][] dp) {
            if (m == 0)
                  return dp[n][m] = 1;
            if (n == 0)
                  return dp[n][m] = 0;

            if (dp[n][m] != -1)
                  return dp[n][m];
            if (s.charAt(n - 1) == t.charAt(m - 1)) {
                  dp[n][m] = numDistinct_memo(s, t, n - 1, m - 1, dp) + numDistinct_memo(s, t, n - 1, m, dp);

            } else {
                  dp[n][m] = numDistinct_memo(s, t, n - 1, m, dp);
            }
            return dp[n][m];
      }

      public int numDistinct_memo1(String s, String t, int n, int m, int[][] dp) {
            if (m == 0) {
                  return dp[n][m] = 1;
            }

            if (n < m) {
                  return dp[n][m] = 0;
            }

            if (dp[n][m] != -1)
                  return dp[n][m];

            int a = numDistinct_memo1(s, t, n - 1, m - 1, dp);
            int b = numDistinct_memo1(s, t, n - 1, m, dp);

            if (s.charAt(n - 1) == t.charAt(m - 1))
                  return dp[n][m] = a + b;
            else
                  return dp[n][m] = b;
      }

      // Tabu
      public int numDistinct_DP(String s, String t, int N, int M, int[][] dp) {
            for (int n = 0; n <= N; n++) {
                  for (int m = 0; m <= M; m++) {
                        if (m == 0) {
                              dp[n][m] = 1;
                              continue;
                        }

                        if (n < m) {
                              dp[n][m] = 0;
                              continue;
                        }

                        int a = dp[n - 1][m - 1];// numDistinct(s, t, n - 1, m - 1, dp);
                        int b = dp[n - 1][m];// numDistinct(s, t, n - 1, m, dp);

                        if (s.charAt(n - 1) == t.charAt(m - 1))
                              dp[n][m] = a + b;
                        else
                              dp[n][m] = b;
                  }
            }

            return dp[N][M];
      }
      // 115

      public int numDistinct(String s, String t) {
            int n = s.length(), m = t.length();
            int[][] dp = new int[n + 1][m + 1];
            for (int[] d : dp)
                  Arrays.fill(d, -1);

            int ans = numDistinct_DP(s, t, n, m, dp);

            return ans;
      }



     
}
