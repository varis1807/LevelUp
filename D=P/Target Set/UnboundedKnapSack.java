import java.util.*;

public class UnboundedKnapSack {
      // rec
      public static int knapSack_rec(int W, int[] wt, int val[], int n) {
            if (n == 0 || W == 0)
                  return 0;
            int max = 0;
            if (W - wt[n - 1] >= 0)// wt[n - 1] <= W
                  max = Math.max(max, knapSack_rec(W - wt[n - 1], wt, val, n) + val[n - 1]);
            max = Math.max(max, knapSack_rec(W, wt, val, n - 1));
            return max;
      }

      // memo
      public static int knapSack_memo(int W, int[] wt, int val[], int n, int[][] dp) {
            if (n == 0 || W == 0)
                  return dp[n][W] = 0;
            if (dp[n][W] != -1)
                  return dp[n][W];
            int max = 0;
            if (W - wt[n - 1] >= 0)// wt[n - 1] <= W
                  max = Math.max(max, knapSack_memo(W - wt[n - 1], wt, val, n, dp) + val[n - 1]);
            max = Math.max(max, knapSack_memo(W, wt, val, n - 1, dp));
            return dp[n][W] = max;
      }

      // tabu
      public static int knapSack_tabu(int w, int[] wt, int val[], int N, int[][] dp) {
            for (int n = 1; n <= N; n++) {
                  for (int W = 1; W <= w; W++) {
                        if (n == 0 || W == 0) {
                              dp[n][W] = 0;
                              continue;
                        }
                        int max = 0;
                        if (W - wt[n - 1] >= 0)// wt[n - 1] <= W
                              max = Math.max(max, dp[n][W - wt[n - 1]] + val[n - 1]);
                        max = Math.max(max, dp[n - 1][W]);
                        dp[n][W] = max;
                  }
            }
            return dp[N][w];
      }
      public static void display(int[] dp) {
            for (int ele : dp) {
                  System.out.print(ele + " | ");
            }
            System.out.println();
      }

      public static void display2D(int[][] dp) {
            for (int[] d : dp) {
                  display(d);
            }
            System.out.println();
      }
      public static void knapSack() {
            int W = 4;
            int val[] = { 1, 1 ,1};
            int wt[] = { 2, 1 ,2};
            // int W = 100;
            // int val[] = { 1, 30 };
            // int wt[] = { 1, 50 };
            int n = val.length;
            int[][] dp = new int[n + 1][W + 1];
            for (int[] d : dp)
                  Arrays.fill(d, -1);
            System.out.println(knapSack_memo(W, wt, val, n, dp));
            display2D(dp);
      }

      public static void main(String[] args) {
            knapSack();
      }
}
