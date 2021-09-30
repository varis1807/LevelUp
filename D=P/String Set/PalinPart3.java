import java.util.*;
public class PalinPart3 {
    // 1278
    public int[][] minChanges(String str) {
        int n = str.length();
        int[][] dp = new int[n][n];
        for (int gap = 1; gap < n; gap++) {
            for (int i = 0, j = gap; j < n; i++, j++) {
                if (gap == 1)
                    dp[i][j] = str.charAt(i) == str.charAt(j) ? 0 : 1;
                else
                    dp[i][j] = str.charAt(i) == str.charAt(j) ? dp[i + 1][j - 1] : dp[i + 1][j - 1] + 1;
            }
        }

        return dp;
    }

    public int palindromePartition(String s, int k, int si, int[][] dp, int[][] minChanges) {
        if (s.length() - si <= k) {
            return dp[si][k] = s.length() - si == k ? 0 : (int) 1e9;
        }

        if (k == 1)
            dp[si][k] = minChanges[si][s.length() - 1];

        if (dp[si][k] != -1) {
            return dp[si][k];
        }

        int minAns = (int) 1e9;
        for (int i = si; i < s.length(); i++) {
            int minChangesInMyString = minChanges[si][i];
            int minChangesInRecString = palindromePartition(s, k - 1, i + 1, dp, minChanges);

            if (minChangesInRecString != (int) 1e9)
                minAns = Math.min(minAns, minChangesInRecString + minChangesInMyString);
        }

        return dp[si][k] = minAns;
    }

    public int palindromePartition(String s, int k) {
        int n = s.length();
        int[][] minChanges = minChanges(s);
        int[][] dp = new int[n + 1][k + 1];
        for (int[] d : dp)
            Arrays.fill(d, -1);

        return palindromePartition(s, k, 0, dp, minChanges);
    }
}
