public class MinMaxExpression {
      // Min Max =======================================================

      public static class pairmm {
            int min = (int) 1e9;
            int max = 0;

            pairmm() {

            }

            pairmm(int val) {
                  this.min = this.max = val;
            }
      }

      public static pairmm evaluateMinMax(pairmm leftRes, pairmm rightRes, char operator) {
            pairmm pair = new pairmm();
            if (operator == '+') {
                  pair.min = leftRes.min + rightRes.min;
                  pair.max = leftRes.max + rightRes.max;
            } else if (operator == '*') {
                  pair.min = leftRes.min * rightRes.min;
                  pair.max = leftRes.max * rightRes.max;
            }
            return pair;
      }

      public static pairmm minMax(String str, int si, int ei, pairmm[][] dp) {
            if (si == ei) {
                  return dp[si][ei] = new pairmm((str.charAt(si) - '0'));
            }
            if (dp[si][ei] != null)
                  return dp[si][ei];

            pairmm myRes = new pairmm();
            for (int cut = si + 1; cut < ei; cut += 2) {
                  pairmm leftRes = minMax(str, si, cut - 1, dp);
                  pairmm rightRes = minMax(str, cut + 1, ei, dp);
                  pairmm pair = evaluateMinMax(leftRes, rightRes, str.charAt(cut));

                  myRes.min = Math.min(myRes.min, pair.min);
                  myRes.max = Math.max(myRes.max, pair.max);
            }
            return dp[si][ei] = myRes;
      }

      public static void minMax() {
            String str = "1+2*3+4*5";
            int n = str.length();
            pairmm[][] dp = new pairmm[n][n];
            pairmm res = minMax(str, 0, n - 1, dp);
            System.out.println("Min value: " + res.min);
            System.out.println("Max value: " + res.max);
      }
      // 312
      public static void main(String... args) {
            // mcm();
            minMax();
      }
}
