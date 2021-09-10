import java.util.*;

public class DelOpeForTwoStr {
      public static int lcss(String str1, String str2, int n, int m, int[][] dp) {
            if (n == 0 || m == 0) {
                  return dp[n][m] = 0;
            }

            if (dp[n][m] != -1)
                  return dp[n][m];

            if (str1.charAt(n - 1) == str2.charAt(m - 1))
                  dp[n][m] = lcss(str1, str2, n - 1, m - 1, dp) + 1;
            else
                  dp[n][m] = Math.max(lcss(str1, str2, n - 1, m, dp), lcss(str1, str2, n, m - 1, dp));

            return dp[n][m];
      }

      public static void display(int[] dp) {
            for (int ele : dp) {
                  System.out.print(ele + "   ");
            }
            System.out.println();
      }

      public static void display2D(int[][] dp) {
            for (int[] d : dp) {
                  display(d);
            }
            System.out.println();
      }

      public static int minDistance(String word1, String word2) {
            // if(word1.length()==1) return 0;
            int n = word1.length(), m = word2.length();
            int[][] dp = new int[n + 1][m + 1];
            for (int[] d : dp)
                  Arrays.fill(d, -1);
            int ans = lcss(word1, word2, n, m, dp);
            display2D(dp);
            int insertion = word1.length() - ans;
            int deletion = word2.length() - ans;
            return insertion + deletion;
      }

      public static void main(String[] args) {
            System.out.println(minDistance("sea", "eat"));
      }
}
