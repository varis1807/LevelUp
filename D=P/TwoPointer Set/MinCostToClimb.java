public class MinCostToClimb {
      // Leetcode 70
      // 746
      // Recursion
      public static int minCostClimbingStairs_rec(int[] cost, int n) {
            if (n <= 1) {
                  return n;
            }
            int val = Math.min(minCostClimbingStairs_rec(cost, n - 1), minCostClimbingStairs_rec(cost, n - 2))+cost[n];
            return val;
      }

      // Mamo
      public static int minCostClimbingStairs_memo(int[] cost, int[] dp, int n) {
            if (n <= 1) {
                  return dp[n] = cost[n];
            }
            if (dp[n] != 0)
                  return dp[n];
            int val = Math.min(minCostClimbingStairs_memo(cost, dp, n - 1),
                        minCostClimbingStairs_memo(cost, dp, n - 2));
            if (n != cost.length)
                  val += cost[n];
            return dp[n] = val;
      }

      // Tabu
      public int minCostClimbingStairs_tabu(int[] cost) {
            int N = cost.length;
            int[] dp = new int[N];
            for (int n = 0; n < N; n++) {
                  if (n <= 1) {
                        dp[n] = cost[n];
                        continue;
                  }
                  int ans = Math.min(dp[n - 1], dp[n - 2]) + cost[n];
                  dp[n] = ans;
            }
            return Math.min(dp[N - 2], dp[N - 1]);
      }

      public static int minCostClimbingStairs(int[] cost) {
            int[] dp = new int[cost.length + 1];
            return minCostClimbingStairs_memo(cost, dp, cost.length);
      }

      public static void main(String[] args) {
            int[] cost = { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 };
            System.out.println(minCostClimbingStairs(cost));
      }
}
