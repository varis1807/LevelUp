public class LongestPalinSubString {
    // 005
    public static String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        int count = 0, MaxLen = 0, si = 0;
        for (int gap = 0; gap < n; gap++) {
            for (int i = 0, j = gap; j < n; i++, j++) {
                if (gap == 0)
                    dp[i][j] = true;
                else if (gap == 1 && s.charAt(i) == s.charAt(j))
                    dp[i][j] = true;
                else
                    dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];

                if (dp[i][j]) {
                    count++;
                    if (j - i + 1 > MaxLen) {
                        MaxLen = j - i + 1;
                        si = i;
                    }
                }
            }
        }
        display2D(dp);
        System.out.println(count);
        return s.substring(si, si + MaxLen);

    }

    public static void display(boolean[] dp) {
        for (boolean ele : dp) {
            System.out.print(ele + "  |");
        }
        System.out.println();
    }

    public static void display2D(boolean[][] dp) {
        for (boolean[] d : dp) {
            display(d);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("hellosannasmith"));

    }
}
