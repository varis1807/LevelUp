import java.util.*;

public class findPaths {
      // 576
      static int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
      static int mod = (int) 1e9 + 7;

      public static int findPath(int n, int m, int K, int sr, int sc, int[][][] dp) {
            if (sr < 0 || sc < 0 || sr == n || sc == m) {
                  return 1;
            }

            if (K == 0)
                  return 0;

            if (dp[sr][sc][K] != -1)
                  return dp[sr][sc][K];
            int count = 0;

            for (int[] d : dir) {
                  int r = sr + d[0];
                  int c = sc + d[1];

                  count = (count + findPath(n, m, K - 1, r, c, dp)) % mod;

            }

            return dp[sr][sc][K] = count;
      }

      public static int findPath(int n, int m, int k, int r, int c) {
            int[][][] dpp = new int[n + 1][m + 1][k + 1];
            for (int[][] dp : dpp)
                  for (int[] d : dp)
                        Arrays.fill(d, -1);

            return findPath(n, m, k, r, c, dpp);
      }
      public static void main(String[] args) {
            System.out.println(findPath(2, 2, 2, 0, 0));
      }
}
