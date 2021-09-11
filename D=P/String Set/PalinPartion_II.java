import java.util.*;

public class PalinPartion_II {
      // 132
      public static int minCut(String s, int si, int ei, int[] dp, boolean[][] pdp) {
            if (pdp[si][ei])
                  return 0;
            if (dp[si] != -1)
                  return dp[si];

            int minAns = (int) 1e8;
            for (int cut = si; cut <= ei; cut++) {
                  if (pdp[si][cut]) {
                        minAns = Math.min(minAns, minCut(s, cut + 1, ei, dp, pdp) + 1);
                  }
            }

            return dp[si] = minAns;
      }

      public static void display(boolean[] dp) {
            for (boolean ele : dp) {
                  System.out.print(ele + " ");
            }
            System.out.println();
      }

      public static void display2D(boolean[][] dp) {
            for (boolean[] d : dp) {
                  display(d);
            }
            System.out.println();
      }

      public static void display1(int[] dp) {
            for (int ele : dp) {
                  System.out.print(ele + " ");
            }
            System.out.println();
      }

      // faafaaaaabaageeg
      public static void minCut(String s) {
            int n = s.length();
            boolean[][] pdp = new boolean[n][n];
            for (int gap = 0; gap < n; gap++)
                  for (int i = 0, j = gap; j < n; i++, j++) {
                        if (gap == 0)
                              pdp[i][j] = true;
                        else if (gap == 1 && s.charAt(i) == s.charAt(j))
                              pdp[i][j] = true;
                        else
                              pdp[i][j] = s.charAt(i) == s.charAt(j) && pdp[i + 1][j - 1];
                  }
            int[] dp = new int[n + 1];
            Arrays.fill(dp, -1);
            System.out.println(minCut(s, 0, n - 1, dp, pdp));
            display1(dp);
            display2D(pdp);
      }

      public static void main(String[] args) {
            minCut("abccbc");
      }
}
