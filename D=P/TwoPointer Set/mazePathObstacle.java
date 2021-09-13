public class mazePathObstacle {
      // Leetcode 62, 63
      public static int mazePath_tabuObstacle(int SR, int SC, int ER, int EC, int[][] dp, int[][] dir,
                  int[][] obstacleGrid) {
            for (int sr = ER; sr >= SR; sr--) {
                  for (int sc = EC; sc >= SC; sc--) {
                        if (ER == sr && EC == sc) {
                              dp[sr][sc] = 1;
                              continue;
                        }

                        int count = 0;
                        for (int[] d : dir) {
                              int r = sr + d[0], c = sc + d[1];
                              if (r >= 0 && c >= 0 && r < dp.length && c < dp[0].length && obstacleGrid[r][c] == 0) {
                                    count += dp[r][c];// mazePath_memo(r, c, er, ec, dp, dir);
                              }
                        }

                        dp[sr][sc] = count;
                  }
            }

            return dp[SR][SC];
      }

      public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int n = obstacleGrid.length, m = obstacleGrid[0].length;
            if (obstacleGrid[0][0] == 1 || obstacleGrid[n - 1][m - 1] == 1)
                  return 0;
            int[][] dp = new int[n][m];
            int[][] dir = { { 1, 0 }, { 0, 1 } };
            return mazePath_tabuObstacle(0, 0, n - 1, m - 1, dp, dir, obstacleGrid);
      }

      public static void main(String[] args) {
            int[][] obstacleGrid = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
            System.out.println(uniquePathsWithObstacles(obstacleGrid));
      }
}
