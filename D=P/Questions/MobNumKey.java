public class MobNumKey {
      public static int[][] dir = { { 0, 0 }, { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
      public static long solveMemo(int idx, int N, long[][] dp) {
            if (N == 0 || idx == 9 || idx == 11)
                  return 0;

            if (dp[idx][N] != 0)
                  return dp[idx][N];

            if (N == 1)
                  return dp[idx][N] = 1;

            long count = 0;

            int sr = idx / 3, sc = idx % 3;

            for (int[] d : dir) {
                  int r = sr + d[0];
                  int c = sc + d[1];

                  if (r < 0 || c < 0 || r >= 4 || c >= 3)
                        continue;

                  count += solveMemo(r * 3 + c, N - 1, dp);
            }

            return dp[idx][N] = count;
      }
      public static long getCount(int N) {
            // Your code goes here
            long ans = 0;
            long[][] dp = new long[4 * 3][N + 1];

            for (int idx = 0; idx < 4 * 3; idx++) {
                  ans += solveMemo(idx, N, dp);
            }
            return ans;
      }
      public static void main(String[] args) {
            System.out.println(getCount(1000));
      }
}
