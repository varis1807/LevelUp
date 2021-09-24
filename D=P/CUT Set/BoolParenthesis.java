public class BoolParenthesis {
      public static class pairBoolean {
            long totalTrue = 0;
            long totalFalse = 0;

            pairBoolean(long totalTrue, long totalFalse) {
                  this.totalFalse = totalFalse;
                  this.totalTrue = totalTrue;
            }

            pairBoolean() {

            }
      }

      public static pairBoolean countWays(String S, int si, int ei, pairBoolean[][] dp) {
            if (si == ei) {
                  char ch = S.charAt(si);
                  int t = ch == 'T' ? 1 : 0;
                  int f = ch == 'F' ? 1 : 0;
                  return dp[si][ei] = new pairBoolean(t, f);
            }
            if (dp[si][ei] != null) {
                  return dp[si][ei];
            }

            pairBoolean res = new pairBoolean();
            for (int cut = si + 1; cut < ei; cut += 2) {
                  pairBoolean lres = countWays(S, si, cut - 1, dp);
                  pairBoolean rres = countWays(S, cut + 1, ei, dp);

                  evaluateTrue(lres, rres, res, S.charAt(cut));
            }

            return dp[si][ei] = res;
      }

      public static void evaluateTrue(pairBoolean left, pairBoolean right, pairBoolean res, char operator) {
            long mod = 1003;
            long totalTF = ((left.totalTrue + left.totalFalse) * (right.totalTrue + right.totalFalse)) % mod;
            long totalTrue = 0, totalFalse = 0;
            if (operator == '|') {
                  totalFalse = (left.totalFalse * right.totalFalse) % mod;
                  totalTrue = (totalTF - totalFalse + mod) % mod;
            } else if (operator == '^') {
                  totalTrue = (left.totalFalse * right.totalTrue) % mod + (left.totalTrue * right.totalFalse) % mod;
                  totalFalse = (totalTF - totalTrue + mod) % mod;

            } else if (operator == '&') {
                  totalTrue = (left.totalTrue * right.totalTrue) % mod;
                  totalFalse = (totalTF - totalTrue + mod) % mod;
            }

            res.totalFalse = (res.totalFalse + totalFalse) % mod;
            res.totalTrue = (res.totalTrue + totalTrue) % mod;
      }

      public static int countWays(int N, String S) {
            pairBoolean[][] dp = new pairBoolean[N][N];
            return (int) countWays(S, 0, N - 1, dp).totalTrue;
      }
}
