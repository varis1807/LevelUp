import java.util.*;

public class EditDist {

      public static void display(int[] dp) {
            for (int ele : dp) {
                  System.out.print(ele + " ");
            }
            System.out.println();
      }

      public static void display2D(int[][] dp) {
            for (int[] d : dp) {
                  display(d);
            }
            System.out.println();
      }

      // Recursion
      public int minDistance_rec(String word1, String word2, int n, int m) {
            if (n == 0 || m == 0) {
                  return n == 0 ? m : n;
            }

            int insert = minDistance_rec(word1, word2, n, m - 1);
            int delete = minDistance_rec(word1, word2, n - 1, m);
            int replace = minDistance_rec(word1, word2, n - 1, m - 1);

            if (word1.charAt(n - 1) == word2.charAt(m - 1))
                  return replace;
            else
                  return Math.min(Math.min(insert, delete), replace) + 1;
      }

      // 72
      // Memo
      public static int minDistance_memo(String word1, String word2, int n, int m, int[][] dp) {
            if (n == 0 || m == 0) {
                  return dp[n][m] = (n == 0 ? m : n);
            }

            if (dp[n][m] != -1)
                  return dp[n][m];

            int insert = minDistance_memo(word1, word2, n, m - 1, dp);
            int delete = minDistance_memo(word1, word2, n - 1, m, dp);
            int replace = minDistance_memo(word1, word2, n - 1, m - 1, dp);

            if (word1.charAt(n - 1) == word2.charAt(m - 1))
                  return dp[n][m] = replace;
            else
                  return dp[n][m] = Math.min(Math.min(insert, delete), replace) + 1;
      }

      public static int minDistance_tabu(String word1, String word2, int N, int M, int[][] dp) {
            for (int n = 0; n <= N; n++) {
                  for (int m = 0; m <= M; m++) {
                        if (n == 0 || m == 0) {
                              dp[n][m] = (n == 0 ? m : n);
                              continue;
                        }
                        int insert = dp[n][m - 1];
                        int delete = dp[n - 1][m];
                        int replace = dp[n - 1][m - 1];

                        if (word1.charAt(n - 1) == word2.charAt(m - 1))
                              dp[n][m] = replace;
                        else
                              dp[n][m] = Math.min(Math.min(insert, delete), replace) + 1;
                  }
            }
            return dp[N][M];
      }

      public static int minDistance(String s, String t) {
            int n = s.length(), m = t.length();
            int[][] dp = new int[n + 1][m + 1];
            for (int[] d : dp)
                  Arrays.fill(d, -1);

            int ans = minDistance_tabu(s, t, n, m, dp);
            display2D(dp);
            return ans;
      }
      // 0 1 2 3 
      // 1 1 2 3 
      // 2 2 1 2 
      // 3 2 2 2 
      // 4 3 3 2 
      // 5 4 4 3 
      public static void main(String[] args) {
            System.out.println(minDistance("horse", "ros"));
      }

      // ======================= Version 2 ================================

      // cost : {insert = a, replace = b, delete = c}
      public static int minDistance_02(String word1, String word2, int n, int m, int[] cost, int[][] dp) {
            if (n == 0 || m == 0) {
                  return dp[n][m] = (n == 0 ? m * cost[0] : n * cost[2]);
            }

            if (dp[n][m] != -1)
                  return dp[n][m];

            int insert = minDistance_02(word1, word2, n, m - 1, cost, dp);
            int delete = minDistance_02(word1, word2, n - 1, m, cost, dp);
            int replace = minDistance_02(word1, word2, n - 1, m - 1, cost, dp);

            if (word1.charAt(n - 1) == word2.charAt(m - 1))
                  return dp[n][m] = replace;
            else
                  return dp[n][m] = Math.min(Math.min(insert + cost[0], delete + cost[2]), replace + cost[1]);
      }

      // public int minDistance(String s, String t) {
      // int n = s.length(), m = t.length();
      // int[][] dp = new int[n + 1][m + 1];
      // int[] cost = { 1, 2, 3 };
      // for (int[] d : dp)
      // Arrays.fill(d, -1);

      // int ans = minDistance_02(s, t, n, m, cost, dp);

      // return ans;
      // }
}
