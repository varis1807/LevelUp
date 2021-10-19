import java.util.*;
public class SwimInRisingWater {
      public int swimInWater(int[][] grid) {
            int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
            int n = grid.length, m = n;

            PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
                  int i1 = a / m, j1 = a % m;
                  int i2 = b / m, j2 = b % m;

                  return grid[i1][j1] - grid[i2][j2];
            });

            boolean[][] vis = new boolean[n][m];
            pq.add(0);
            vis[0][0] = true;

            int minHeight = 0;
            while (pq.size() != 0) {
                  int idx = pq.remove();
                  int i = idx / m, j = idx % m;
                  int height = grid[i][j];

                  // time +=Math.max(0, height - minHeight);
                  minHeight = Math.max(minHeight, height);

                  if (i == n - 1 && j == m - 1)
                        break;

                  for (int[] d : dir) {
                        int r = i + d[0];
                        int c = j + d[1];

                        if (r >= 0 && c >= 0 && r < n && c < m && !vis[r][c]) {
                              vis[r][c] = true;
                              pq.add(r * m + c);
                        }
                  }
            }
            return minHeight;
      }
}
