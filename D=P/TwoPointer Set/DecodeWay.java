import java.util.*;
public class DecodeWay {
   
    // 91
    public static int numDecodings(String s, int idx, int[] dp) {
      if (idx == s.length()) {
          return dp[idx] = 1;
      }
      if (dp[idx] != -1)
          return dp[idx];

      char ch = s.charAt(idx);
      if (ch == '0')
          return dp[idx] = 0;
      int count = numDecodings(s, idx + 1, dp);

      if (idx < s.length() - 1) {
          char ch1 = s.charAt(idx + 1);
          int num = (ch - '0') * 10 + (ch1 - '0');
          if (num <= 26)
              count += numDecodings(s, idx + 2, dp);
      }

      return dp[idx] = count;
  }

  public static int numDecodings_Dp(String s, int IDX, int[] dp) {
      for (int idx = s.length(); idx >= 0; idx--) {
          if (idx == s.length()) {
              dp[idx] = 1;
              continue;
          }

          char ch = s.charAt(idx);
          if (ch == '0') {
              dp[idx] = 0;
              continue;
          }

          int count = dp[idx + 1];

          if (idx < s.length() - 1) {
              char ch1 = s.charAt(idx + 1);
              int num = (ch - '0') * 10 + (ch1 - '0');
              if (num <= 26)
                  count += dp[idx + 2];
          }

          dp[idx] = count;
      }

      return dp[IDX];
  }

  public static int numDecodings_opti(String s) {
      int a = 1, b = 0;
      for (int idx = s.length() - 1; idx >= 0; idx--) {
          char ch = s.charAt(idx);
          int sum = 0;
          if (ch != '0') {
              sum += a;

              if (idx < s.length() - 1) {
                  char ch1 = s.charAt(idx + 1);
                  int num = (ch - '0') * 10 + (ch1 - '0');
                  if (num <= 26)
                      sum += b;
              }
          }

          b = a;
          a = sum;
      }

      return a;
  }

  public static int numDecodings(String s) {
      int n = s.length();
      int[] dp = new int[n + 1];
      Arrays.fill(dp, -1);

      int ans = numDecodings(s, 0, dp);
      // display(dp);
      return ans;
  }

  public static void main(String[] args) {
      // fibo();
      numDecodings("212311");
  }

}
