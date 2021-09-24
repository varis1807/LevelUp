public class OptimalBST {
 public static int obst(int[] val, int[] freq, int si, int ei, int[][] dp) {
      if (dp[si][ei] != 0)
          return dp[si][ei];
      int minCost = (int) 1e8;

      int sum = 0;

      for (int i = si; i <= ei; i++)
          sum += freq[i];

      for (int cut = si; cut <= ei; cut++) {
          int lres = cut == si ? 0 : obst(val, freq, si, cut - 1, dp);
          int rres = cut == ei ? 0 : obst(val, freq, cut + 1, ei, dp);
          // sum += freq[cut];
          minCost = Math.min(minCost, lres + sum + rres); // sum : sumOfRange(freq, si,ei);
      }

      return dp[si][ei] = minCost; // minCost + sum
  }
}
