import java.util.*;

public class friendPairing {                 
      static long mod = (int) 1e9;

      public long countFriendsPairings(int n, long[] dp) {
            if (n == 0) {
                  return dp[n] = 1;
            }

            if (dp[n] != -1)
                  return dp[n];

            long single = countFriendsPairings(n - 1, dp);
            long pairUp = n - 2 >= 0 ? countFriendsPairings(n - 2, dp) * (n - 1) : 0;

            return dp[n] = (single + pairUp % mod) % mod;
      }

      public long countFriendsPairings(int n) {
            long[] dp = new long[n + 1];
            Arrays.fill(dp, -1);

            return countFriendsPairings(n, dp);
      }

      public long countFriendsPairings_02(int n) {
            long a = 1, b = 1;
            for (int i = 2; i <= n; i++) {
                  long sum = b + (a * (i - 1)) % mod;
                  a = b;
                  b = sum % mod;
            }

            return b;
      }

}
// DP: (O(N) time and O(N) space
// Memo
// int solve(int n, vector < int > & dp) {

// if (n <= 0) return 1;

// if (dp[n] != -1) return dp[n];

// return dp[n] = solve(n - 1, dp) + (n - 1) * solve(n - 2, dp);
// }

// int countFriendsPairings(int n) {

// vector < int > dp(n + 1, -1);
// dp[0] = dp[1] = 1;
// return solve(n, dp);
// }
// Pure DP
// int countFriendsPairings(int n)
// {
// vector<int> dp(n+1,0);
// dp[0]=1; // null subset
// dp[1]=1; // 1 way possible

// for(int i=2;i<=n;i++)
// {
// dp[i]=(1*dp[i-1] + (i-1)*dp[i-2];
// }
// return dp[n];
// }
// Since it is similar to fibonacci we have another approach in O(1) space
// Fibonacci Similar
// int countFriendsPairings(int n)
// {
// int a = 1, b = 2, c = 0;
// if (n <= 2) {
// return n;
// }
// for (int i = 3; i <= n; i++) {
// c = b + (i - 1) * a;
// a = b;
// b = c;
// }
// return c;
// }
