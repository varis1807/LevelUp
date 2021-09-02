import java.util.*;

public class mazePath_1Jump {
      public static void display(int[] dp) {
            for (int ele : dp) {
                  System.out.println(ele + " ");
            }
            System.out.println();
      }

      public static int mazePath_memo(int sr, int sc, int er, int ec, int[][] dp, int[][] dir) {
            if (er == sr && ec == sc) {
                  return dp[sr][sc] = 1;
            }

            if (dp[sr][sc] != 0)
                  return dp[sr][sc];

            int count = 0;
            for (int[] d : dir) {
                  int r = sr + d[0], c = sc + d[1];
                  if (r >= 0 && c >= 0 && r < dp.length && c < dp[0].length) {
                        count += mazePath_memo(r, c, er, ec, dp, dir);
                  }
            }

            return dp[sr][sc] = count;
      }

      public static int mazePath_tabu(int SR, int SC, int ER, int EC, int[][] dp, int[][] dir) {
            for (int sr = ER; sr >= SR; sr--) {
                  for (int sc = EC; sc >= SC; sc--) {
                        if (ER == sr && EC == sc) {
                              dp[sr][sc] = 1;
                              continue;
                        }

                        int count = 0;
                        for (int[] d : dir) {
                              int r = sr + d[0], c = sc + d[1];
                              if (r >= 0 && c >= 0 && r < dp.length && c < dp[0].length) {
                                    count += dp[r][c];// mazePath_memo(r, c, er, ec, dp, dir);
                              }
                        }

                        dp[sr][sc] = count;
                  }
            }

            return dp[SR][SC];
      }

      public static void mazePath() {
            int sr = 0, sc = 0, er = 3, ec = 3;
            int[][] dp = new int[er + 1][ec + 1];

            int[][] dir = { { 1, 0 }, { 0, 1 }, { 1, 1 } };
            // System.out.println(mazePathJump_tabu(sr, sc, er, ec, dp, dir));

            // display2D(dp);
      }

      public static void main(String[] args) {
            // fibo();
            mazePath();
      }

      
}
