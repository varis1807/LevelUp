import java.util.*;

public class LongestCommonSubSeq {
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

      // Rec
      public static int lcss_rec(String str1, String str2, int n, int m) {
            if (n == 0 || m == 0) {
                  return 0;
            }

            if (str1.charAt(n - 1) == str2.charAt(m - 1))
                  return lcss_rec(str1, str2, n - 1, m - 1) + 1;
            else
                  return Math.max(lcss_rec(str1, str2, n - 1, m), lcss_rec(str1, str2, n, m - 1));

      }

      // MEmo
      public static int lcss_memo(String str1, String str2, int n, int m, int[][] dp) {
            if (n == 0 || m == 0) {
                  return dp[n][m] = 0;
            }

            if (dp[n][m] != -1)
                  return dp[n][m];

            if (str1.charAt(n - 1) == str2.charAt(m - 1))
                  dp[n][m] = lcss_memo(str1, str2, n - 1, m - 1, dp) + 1;
            else
                  dp[n][m] = Math.max(lcss_memo(str1, str2, n - 1, m, dp), lcss_memo(str1, str2, n, m - 1, dp));

            return dp[n][m];
      }

      // tabulation
      public static int lcss_DP(String str1, String str2, int N, int M, int[][] dp) {
            for (int n = 0; n <= N; n++) {
                  for (int m = 0; m <= M; m++) {
                        if (n == 0 || m == 0) {
                              dp[n][m] = 0;
                              continue;
                        }

                        if (str1.charAt(n - 1) == str2.charAt(m - 1))
                              dp[n][m] = dp[n - 1][m - 1] + 1;// lcss(str1, str2, n - 1, m - 1, dp) + 1;
                        else
                              dp[n][m] = Math.max(dp[n - 1][m], dp[n][m - 1]);
                  }
            }

            return dp[N][M];
      }

      public static int longestCommonSubsequence(String text1, String text2) {
            int n = text1.length(), m = text2.length();
            int[][] dp = new int[n + 1][m + 1];
            for (int[] d : dp)
                  Arrays.fill(d, -1);
            int ans = lcss_DP(text1, text2, n, m, dp);

            display2D(dp);
            return ans;
      }

      public static void main(String[] args) {
            System.out.println(longestCommonSubsequence("AGGTABZ", "GXTXAYB"));

            String S1 = "AGGTABZ";
            String S2 = "GXTXAYB";
            int m = S1.length();
            int n = S2.length();
            lcs(S1, S2, m, n);
      }

      static void lcs(String S1, String S2, int m, int n) {
            int[][] LCS_table = new int[m + 1][n + 1];

            // Building the mtrix in bottom-up way
            for (int i = 0; i <= m; i++) {
                  for (int j = 0; j <= n; j++) {
                        if (i == 0 || j == 0)
                              LCS_table[i][j] = 0;
                        else if (S1.charAt(i - 1) == S2.charAt(j - 1))
                              LCS_table[i][j] = LCS_table[i - 1][j - 1] + 1;
                        else
                              LCS_table[i][j] = Math.max(LCS_table[i - 1][j], LCS_table[i][j - 1]);
                  }
            }

            int index = LCS_table[m][n];
            int temp = index;

            char[] lcs = new char[index + 1];
            lcs[index] = '\0';

            int i = m, j = n;
            while (i > 0 && j > 0) {
                  if (S1.charAt(i - 1) == S2.charAt(j - 1)) {
                        lcs[index - 1] = S1.charAt(i - 1);

                        i--;
                        j--;
                        index--;
                  }

                  else if (LCS_table[i - 1][j] > LCS_table[i][j - 1])
                        i--;
                  else
                        j--;
            }

            // Printing the sub sequences
            System.out.print("S1 : " + S1 + "\nS2 : " + S2 + "\nLCS: ");
            for (int k = 0; k <= temp; k++)
                  System.out.print(lcs[k]);
            System.out.println("");
      }

      // S1 : babaabab
      // S2 : aabaababaa
      // LCS: abaabab
}
