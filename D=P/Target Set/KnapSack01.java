import java.util.*;

public class KnapSack01 {
      // rec
      public static int knapSack_rec(int W, int wt[], int val[], int n) {
            if (n == 0 || W == 0) {
                  return 0;
            }
            int maxAns = 0;
            if (W - wt[n - 1] >= 0)
                  maxAns = Math.max(maxAns, knapSack_rec(W - wt[n - 1], wt, val, n - 1) + val[n - 1]);
            maxAns = Math.max(maxAns, knapSack_rec(W, wt, val, n - 1));

            return maxAns;
      }

      // Memo
      public static int knapSack_memo(int W, int wt[], int val[], int n, int[][] dp) {
            if (n == 0 || W == 0) {
                  return dp[n][W] = 0;
            }

            if (dp[n][W] != -1)
                  return dp[n][W];

            int maxAns = 0;
            if (W - wt[n - 1] >= 0)
                  maxAns = Math.max(maxAns, knapSack_memo(W - wt[n - 1], wt, val, n - 1, dp) + val[n - 1]);
            maxAns = Math.max(maxAns, knapSack_memo(W, wt, val, n - 1, dp));

            return dp[n][W] = maxAns;
      }

      // Tabu
      public static int knapSack_tabu(int w, int wt[], int val[], int N, int[][] dp) {
            for (int n = 1; n <= N; n++) {
                  for (int W = 1; W <= w; W++) {
                        if (n == 0 || W == 0) {
                              dp[n][W] = 0;
                              continue;
                        }

                        if (W - wt[n - 1] >= 0)
                        dp[n][W] = Math.max(dp[n][W], dp[n - 1][W - wt[n - 1]] + val[n - 1]);
                        dp[n][W] = Math.max(dp[n][W], dp[n - 1][W]);

                       // dp[n][W] = maxAns;
                  }
            }
            return dp[N][w];
      }

      public static void display(int[] dp) {
            for (int ele : dp) {
                  System.out.print(ele + "|");
            }
            System.out.println();
      }

      public static void display2D(int[][] dp) {
            for (int[] d : dp) {
                  display(d);
            }
            System.out.println();
      }

      public static void knapSack(int W, int wt[], int val[], int N) {
            int[][] dp = new int[N + 1][W + 1];
            // for (int[] d : dp)
            //       Arrays.fill(d, -1);

            System.out.println(knapSack_tabu(W, wt, val, N, dp));
            // display2D(dp);
      }

      public static void main(String[] args) {
            int[] wt = { 10, 20, 30 };
            int[] val = { 60, 100, 120 };
            int N = wt.length;
            int W = 50;
            knapSack(W, wt, val, N);
      }
}
