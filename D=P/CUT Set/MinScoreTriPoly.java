public class MinScoreTriPoly {
      public static int minScoreTriangulation(int[] values, int si, int ei, int[][] dp) {
            if (ei - si <= 1)
                  return 0;
            if (dp[si][ei] != 0)
                  return dp[si][ei];
            int minScore = (int) 1e9;

            for (int cut = si + 1; cut < ei; cut++) {
                  int Lans = minScoreTriangulation(values, si, cut, dp);
                  int Rans = minScoreTriangulation(values, cut, ei, dp);

                  minScore = Math.min(minScore, Lans + values[si] * values[cut] * values[ei] + Rans);
            }
            return dp[si][ei] = minScore;
      }

      public static int minScoreTriangulation(int[] values) {
            int n = values.length;
            int[][] dp = new int[n][n];
            return minScoreTriangulation(values, 0, n - 1, dp);
      }

      public static void main(String[] args) {
            int[] value = { 1, 2, 3 };
            System.out.println(minScoreTriangulation(value));
      }
}
