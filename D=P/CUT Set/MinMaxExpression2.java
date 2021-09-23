public class MinMaxExpression2 {
      public static class pairmm {
            int min = (int) 1e9;
            int max = -(int) 1e9;

            pairmm() {
            }

            pairmm(int val) {
                  this.min = this.max = val;
            }
      }

      public static pairmm evaluatMaxMin(pairmm left, pairmm right, char operator) {
            pairmm pair = new pairmm();
            if (operator == '+') {
                  pair.min = left.min + right.min;
                  pair.max = left.max + right.max;
            } else if (operator == '*') {
                  pair.min = left.min * right.min;
                  pair.max = left.max * right.max;
            } else if (operator == '-') {
                  if (right.min > left.min) {
                        pair.min = (right.min - left.min);
                        pair.max = (right.max - left.max);
                  } else {
                        pair.min = left.min - right.min;
                        pair.max = right.min - right.max;
                  }

            }
            return pair;

      }

      public static pairmm findMinMax(String str, int si, int ei, pairmm[][] dp) {
            if (si == ei) {
                  return dp[si][ei] = new pairmm((str.charAt(si) - '0'));
            }
            pairmm myRes = new pairmm();
            for (int cut = si + 1; cut < ei; cut += 2) {
                  pairmm left = findMinMax(str, si, cut - 1, dp);
                  pairmm right = findMinMax(str, cut + 1, ei, dp);
                  pairmm pair = evaluatMaxMin(left, right, str.charAt(cut));
                  myRes.min = Math.min(pair.min, myRes.min);
                  myRes.max = Math.max(pair.max, myRes.max);
            }
            return dp[si][ei] = myRes;
      }

      public static void display(pairmm[] dp) {
            for (pairmm ele : dp) {
                  System.out.print(ele + "  |  ");
            }
            System.out.println();
      }

      public static void display2D(pairmm[][] dp) {
            for (pairmm[] d : dp) {
                  display(d);
            }
            System.out.println();
      }

      public static void minMax() {
            String str = "1+3-4*5";// 1+2*3+4*5"
            int n = str.length();
            pairmm[][] dp = new pairmm[n][n];
            pairmm res = findMinMax(str, 0, n - 1, dp);
            System.out.println("Min value: " + res.min);
            System.out.println("Max value: " + res.max);
            // display2D(dp);
      }

      // 312
      public static void main(String... args) {
            minMax();
      }
}
