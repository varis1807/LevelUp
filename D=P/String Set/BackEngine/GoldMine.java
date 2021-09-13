package BackEngine;

import java.util.*;

public class GoldMine {
      public static int goldMine(int[][] arr, int sr, int sc, int[][] dir, int[][] dp) {
            int n = arr.length, m = arr[0].length;
            if (sc == m - 1)
                  return dp[sr][sc] = arr[sr][sc];

            if (dp[sr][sc] != -1)
                  return dp[sr][sc];

            int maxGold = 0;
            for (int[] d : dir) {
                  int r = sr + d[0];
                  int c = sc + d[1];

                  if (r >= 0 && c >= 0 && r < n && c < m) {
                        maxGold = Math.max(maxGold, goldMine(arr, r, c, dir, dp) + arr[sr][sc]);
                  }
            }

            return dp[sr][sc] = maxGold;
      }

      public static void goldMine_backEngg(int[][] dp, int[][] dir, int sr, int sc, String asf) {
            if (sc == dp[0].length - 1) {
                  System.out.println(asf + "(" + sr + ", " + sc + ") ");
                  return;
            }
            int maxGold = 0;
            int idx = -1;
            for (int d = 0; d < dir.length; d++) {
                  int r = sr + dir[d][0];
                  int c = sc + dir[d][1];

                  if (r >= 0 && c >= 0 && r < dp.length && c < dp[0].length && dp[r][c] > maxGold) {
                        maxGold = dp[r][c];
                        idx = d;
                  }
            }

            if (idx != -1) {
                  int r = sr + dir[idx][0], c = sc + dir[idx][1];
                  goldMine_backEngg(dp, dir, r, c, asf + "(" + sr + ", " + sc + ") ");

            }
      }

      public static void goldMine() {
            int[][] arr = { { 10, 33, 13, 15 }, { 22, 21, 04, 1 }, { 5, 0, 2, 3 }, { 0, 6, 14, 2 } };
            int[][] dir = { { 0, 1 }, { 1, 1 }, { -1, 1 } };
            int n = arr.length, m = arr[0].length;
            int[][] dp = new int[n][m];

            for (int[] d : dp)
                  Arrays.fill(d, -1);

            int maxGold = 0;
            int rIdx = 0;
            for (int r = 0; r < n; r++) {
                  int ans = goldMine(arr, r, 0, dir, dp);
                  if (ans > maxGold) {
                        maxGold = ans;
                        rIdx = r;
                  }
            }

            goldMine_backEngg(dp, dir, rIdx, 0, "");

            System.out.println(maxGold);
      }
}