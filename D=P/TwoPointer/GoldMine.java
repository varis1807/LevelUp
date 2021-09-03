import java.util.*;

public class GoldMine {
      // Recursion
      static int maxGold(int sr, int sc, int grid[][], int[][] dir, int[][] dp) {
            int n = grid.length, m = grid[0].length;
            if (sc == m - 1) {
                  return grid[sr][sc];
            }
            int maxSum = 0;
            for (int[] d : dir) {
                  int r = sr + d[0];
                  int c = sc + d[1];
                  if (r >= 0 && c >= 0 && r < n && c < m) {
                        maxSum = Math.max(maxSum, maxGold(r, c, grid, dir, dp) + grid[sr][sc]);
                  }
            }
            return maxSum;
      }

      static int maxGold(int n, int m, int M[][]) {
            int[][] dir = { { 0, 1 }, { 1, 1 }, { -1, 1 } };
            int maxSum = 0;
            int[][] dp = new int[n][m];
            int n1 = M.length, m1 = M[0].length;
            for (int r = 0; r < n1; r++) {
                  maxSum = Math.max(maxSum, maxGold(r, 0, M, dir, dp));
            }
            return maxSum;
      }

      // MEMO
      static int maxGold_memo(int sr, int sc, int grid[][], int[][] dir, int[][] dp) {
            int n = grid.length, m = grid[0].length;
            if (sc == m - 1) {
                  dp[sr][sc] = grid[sr][sc];
            }
            if (dp[sr][sc] != -1)
                  return dp[sr][sc];
            int maxSum = 0;
            for (int[] d : dir) {
                  int r = sr + d[0];
                  int c = sc + d[1];
                  if (r >= 0 && c >= 0 && r < n && c < m) {
                        maxSum = Math.max(maxSum, maxGold_memo(r, c, grid, dir, dp) + grid[sr][sc]);
                  }
            }
            return dp[sr][sc] = maxSum;
      }

      static int maxGold_memo(int n, int m, int M[][]) {
            int[][] dir = { { 0, 1 }, { 1, 1 }, { -1, 1 } };
            int maxSum = 0;
            int n1 = M.length, m1 = M[0].length;
            int[][] dp = new int[n1][m1];
            for (int[] d : dp)
                  Arrays.fill(d, -1);

            for (int r = 0; r < n1; r++) {
                  maxSum = Math.max(maxSum, maxGold_memo(r, 0, M, dir, dp));
            }
            return maxSum;
      }
}
