
public class lpSubSeq {
    public static String lpss_backEng(String str, int si, int ei, int[][] dp) {
        if (si >= ei) {
            return si == ei ? str.charAt(si) + "" : "";
        }

        if (str.charAt(si) == str.charAt(ei)) {
            return str.charAt(si) + lpss_backEng(str, si + 1, ei - 1, dp) + str.charAt(ei);
        } else if (dp[si + 1][ei] > dp[si][ei - 1]) {
            return lpss_backEng(str, si + 1, ei, dp);
        } else {
            return lpss_backEng(str, si, ei - 1, dp);
        }
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
                    dp[i][j] = dp[i + 1][j - 1] + 2;
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

    public static void main(String[] args) {
        String str = "ababccba";
        int n = str.length();
        int si = 0;
        int ei = n - 1;
        int[][] dp = new int[n + 1][n + 1];
        System.out.println(lpss_backEng(str, si, ei, dp));
        System.out.println(longestPalindromeSubseq("ababccba"));
    }
}
