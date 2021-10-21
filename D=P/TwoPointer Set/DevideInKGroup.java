public class DevideInKGroup {
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

      // https://www.geeksforgeeks.org/count-number-of-ways-to-partition-a-set-into-k-subsets/
      public static int divideInKGroup(int n, int k, int[][] dp) {
            if (n == k || k == 1) {
                  return dp[n][k] = 1;
            }

            if (dp[n][k] != 0)
                  return dp[n][k];

            int selfGroup = divideInKGroup(n - 1, k - 1, dp);
            int partOfGroup = divideInKGroup(n - 1, k, dp) * k;

            return dp[n][k] = selfGroup + partOfGroup;
      }

      public static int divideInKGroup_DP(int N, int K, int[][] dp) {
            for (int n = 1; n <= N; n++) {
                  for (int k = 1; k <= K; k++) {
                        if (n == k || k == 1) {
                              dp[n][k] = 1;
                              continue;
                        }

                        int selfGroup = dp[n - 1][k - 1];// divideInKGroup(n - 1, k - 1, dp);
                        int partOfGroup = dp[n - 1][k] * k;// divideInKGroup(n - 1, k, dp) * k;

                        dp[n][k] = selfGroup + partOfGroup;
                  }
            }

            return dp[N][K];
      }

      public static void divideInKGroup() {
            int n = 3;
            int k = 2;

            int[][] dp = new int[n + 1][k + 1];
            System.out.println(divideInKGroup(n, k, dp));
            display2D(dp);
      }

      public static void main(String[] args) {
            divideInKGroup();
      }
}
