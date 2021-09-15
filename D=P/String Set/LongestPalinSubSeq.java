public class LongestPalinSubSeq {
      public static void display(int[] dp) {
            for (int ele : dp) {
                  System.out.print(ele + " ");
            }
            System.out.println();
      }

      public static void display2D(int[][] dp) {
            for (int[] d : dp) {
                  display(d);
            }
            System.out.println();
      }

      // Recursion
      public static int lpss_rec(String s, int i, int j) {
            if (i >= j)
                  return i == j ? 1 : 0;

            if (s.charAt(i) == s.charAt(j))
                  return lpss_rec(s, i + 1, j - 1) + 2;
            else
                  return Math.max(lpss_rec(s, i + 1, j), lpss_rec(s, i, j - 1));
      }

      // MEMO
      // 516. Longest Palindromic Subsequence
      public static int lpss_memo(String s, int i, int j, int[][] dp) {
            if (i >= j)
                  return dp[i][j] = (i == j ? 1 : 0);

            if (dp[i][j] != 0)
                  return dp[i][j];

            if (s.charAt(i) == s.charAt(j))
                  return dp[i][j] = lpss_memo(s, i + 1, j - 1, dp) + 2;
            else
                  return dp[i][j] = Math.max(lpss_memo(s, i + 1, j, dp), lpss_memo(s, i, j - 1, dp));
      }

      // Tabu
      public static int lpss_DP_tabu(String s, int I, int J, int[][] dp) {
            int n = s.length();
            for (int gap = 0; gap < n; gap++) {
                  for (int i = 0, j = gap; j < n; i++, j++) {
                        if (i >= j) {
                              dp[i][j] = (i == j ? 1 : 0);
                              continue;
                        }

                        if (s.charAt(i) == s.charAt(j))
                              dp[i][j] = dp[i + 1][j - 1] + 2;// lpss(s, i + 1, j - 1, dp) + 2;
                        else
                              dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                  }
            }

            return dp[I][J];
      }

      public static int longestPalindromeSubseq(String s) {
            int n = s.length();
            int[][] dp = new int[n][n];
            int ans = lpss_DP_tabu(s, 0, n - 1, dp);
            display2D(dp);
            return ans;
      }

      public static void main(String[] args) {
            System.out.print(longestPalindromeSubseq("bbbab"));
      }

}