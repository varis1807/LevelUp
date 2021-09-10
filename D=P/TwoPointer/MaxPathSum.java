import java.util.*;
public class MaxPathSum {

      // Recursion
      static int maximumPath_rec(int sr, int sc, int Mat[][], int[][] dir) {
            int n = Mat.length, m = Mat[0].length;
            if (sr == n - 1) {
                  return Mat[sr][sc];
            }
            int maxVal = 0;
            for (int[] d : dir) {
                  int r = sr + d[0];
                  int c = sc + d[1];
                  if (r >= 0 && c >= 0 && r < n && c < m) {
                        maxVal = Math.max(maxVal, maximumPath_rec(r, c, Mat, dir) + Mat[sr][sc]);
                  }
            }
            return maxVal;
      }

      // Memoization
      static int maximumPath_memo(int sr, int sc, int Mat[][], int[][] dir, int[][] dp) {
            int n = Mat.length, m = Mat[0].length;
            if (sr == n - 1) {
                  return dp[sr][sc] = Mat[sr][sc];
            }
            if (dp[sr][sc] != -1)
                  return dp[sr][sc];
            int maxVal = 0;
            for (int[] d : dir) {
                  int r = sr + d[0];
                  int c = sc + d[1];
                  if (r >= 0 && c >= 0 && r < n && c < m) {
                        maxVal = Math.max(maxVal, maximumPath_memo(r, c, Mat, dir, dp) + Mat[sr][sc]);
                  }
            }
            return dp[sr][sc] = maxVal;
      }

      // Tabulation
      static int maximumPath_tabu(int SR, int SC, int Mat[][], int[][] dir, int[][] dp) {
            int n = Mat.length, m = Mat[0].length;

            for (int sr = n - 1; sr >= SR; sr--) {
                  for (int sc = m - 1; sc >= SC; sc--) {
                        if (sr == n - 1) {
                              dp[sr][sc] = Mat[sr][sc];
                              continue;
                        }

                        int maxVal = 0;
                        for (int[] d : dir) {
                              int r = sr + d[0];
                              int c = sc + d[1];
                              if (r >= 0 && c >= 0 && r < n && c < m) {
                                    maxVal = Math.max(maxVal, dp[r][c] + Mat[sr][sc]);
                              }
                        }
                        dp[sr][sc] = maxVal;
                  }
            }
            return dp[SR][SC];
      }

      static int maximumPath(int N, int Matrix[][]) {
            int[][] dir = { { 1, 0 }, { 1, 1 }, { 1, -1 } };
            int n = Matrix.length, m = Matrix[0].length, maxVal = 0;
            int[][] dp = new int[n][m];
            for (int[] d : dp)
                  Arrays.fill(d, -1);
            for (int c = 0; c < m; c++) {
                  maxVal = Math.max(maxVal, maximumPath_tabu(0, c, Matrix, dir, dp));
            }
            return maxVal;
      }
}
