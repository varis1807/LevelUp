import java.util.*;

public class MinPathSum {
      // recursion

      public int minPathSum_rec(int sr, int sc, int[][] grid, int[][] dir) {
            int n = grid.length, m = grid[0].length;
            if (sr == n - 1 && sc == m - 1)
                  return grid[sr][sc];
            int minVal = (int) 1e9;
            for (int[] d : dir) {
                  int r = sr + d[0];
                  int c = sc + d[1];
                  if (r >= 0 && c >= 0 && r < n && c < m)
                        minVal = Math.min(minVal, minPathSum_rec(r, c, grid, dir) + grid[sr][sc]);
            }
            return minVal;
      }

      // Memoization

      public int minPathSum_memo(int sr, int sc, int[][] grid, int[][] dir, int[][] dp) {
            int n = grid.length, m = grid[0].length;
            if (sr == n - 1 && sc == m - 1)
                  return dp[sr][sc] = grid[sr][sc];
            if (dp[sr][sc] != -1)
                  return dp[sr][sc];
            int minVal = (int) 1e9;
            for (int[] d : dir) {
                  int r = sr + d[0];
                  int c = sc + d[1];
                  if (r >= 0 && c >= 0 && r < n && c < m)
                        minVal = Math.min(minVal, minPathSum_memo(r, c, grid, dir, dp) + grid[sr][sc]);
            }
            return dp[sr][sc] = minVal;
      }

      // Tabulation
      public int minPathSum_tabu(int SR, int SC, int[][] grid, int[][] dir, int[][] dp) {
            int n = grid.length, m = grid[0].length;
            for (int sr = n - 1; sr >= SR; sr--) {
                  for (int sc = m - 1; sc >= SC; sc--) {
                        if (sr == n - 1 && sc == m - 1) {
                              dp[sr][sc] = grid[sr][sc];
                              continue;
                        }
                        int minVal = (int) 1e9;
                        for (int[] d : dir) {
                              int r = sr + d[0];
                              int c = sc + d[1];
                              if (r >= 0 && c >= 0 && r < n && c < m)
                                    minVal = Math.min(minVal, dp[r][c] + grid[sr][sc]);
                        }
                        dp[sr][sc] = minVal;
                  }
            }
            return dp[SR][SC];

      }

      public int minPathSum(int[][] grid) {
            int[][] dir = { { 0, 1 }, { 1, 0 } };
            int minVal = 0;
            int n = grid.length, m = grid[0].length;
            int[][] dp = new int[n][m];
            for (int[] d : dp)
                  Arrays.fill(d, -1);
            return minPathSum_tabu(0, 0, grid, dir, dp);
      }
}
