package BackEngine;

public class lpss {
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
}
