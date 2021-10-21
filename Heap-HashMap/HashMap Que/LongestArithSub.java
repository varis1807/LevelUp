import java.util.*;
public class LongestArithSub {
      // 1027
      public int longestArithSeqLength(int[] A) {
            int n = A.length;
            HashMap<Integer, Integer>[] dp = new HashMap[n];

            for (int i = 0; i < n; i++)
                  dp[i] = new HashMap<>();

            int len = 0;
            for (int i = 0; i < n; i++) {
                  for (int j = i - 1; j >= 0; j--) {
                        int diff = A[i] - A[j];
                        int currLen = dp[i].getOrDefault(diff, 0);
                        int newLen = dp[j].getOrDefault(diff, 1) + 1;

                        dp[i].put(diff, Math.max(currLen, newLen));
                        len = Math.max(len, dp[i].get(diff));
                  }
            }

            return len;
      }
}
