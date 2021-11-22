public class MatChainMul {
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

      // Rec
      public static int mcm_rec(int[] arr, int si, int ei) {
            if (ei - si == 1) {
                  return 0;
            }
            int minRes = (int) 1e9;
            for (int cut = si + 1; cut < ei; cut++) {
                  int leftRes = mcm_rec(arr, si, cut);
                  int rightRes = mcm_rec(arr, cut, ei);

                  minRes = Math.min(minRes, leftRes + arr[si] * arr[cut] * arr[ei] + rightRes);
            }
            return minRes;
      }

      // Memo
      public static int mcm_memo(int[] arr, int si, int ei, int[][] dp) {
            if (ei - si == 1) {
                  return dp[si][ei] = 0;
            }
            if (dp[si][ei] != 0)
                  return dp[si][ei];

            int minRes = (int) 1e9;
            for (int cut = si + 1; cut < ei; cut++) {
                  int leftRes = mcm_memo(arr, si, cut, dp);
                  int rightRes = mcm_memo(arr, cut, ei, dp);

                  minRes = Math.min(minRes, leftRes + arr[si] * arr[cut] * arr[ei] + rightRes);
            }
            return dp[si][ei] = minRes;
      }

      // Tabulation
      public static int mcm_Dp(int[] arr, int SI, int EI, int[][] dp) {
            int n = arr.length;
            for (int gap = 1; gap < n; gap++) {
                  for (int si = 0, ei = gap; ei < n; si++, ei++) {
                        if (ei - si == 1) {
                              dp[si][ei] = 0;
                              continue;
                        }
                        int minRes = (int) 1e9;
                        for (int cut = si + 1; cut < ei; cut++) {
                              int leftRes = dp[si][cut];
                              int rightRes = dp[cut][ei];

                              minRes = Math.min(minRes, leftRes + arr[si] * arr[cut] * arr[ei] + rightRes);
                        }
                        dp[si][ei] = minRes;
                  }
            }
            return dp[SI][EI];
      }

      public static void mcm() {
            int[] arr = { 3, 1, 5, 8 };// [3,1,5,8]{ 10, 30, 5, 60 };
            int n = arr.length;
            int[][] dp = new int[n][n];
            System.out.println(mcm_Dp(arr, 0, n - 1, dp));
            display2D(dp);
      }

      public static void main(String[] args) {
            mcm();
      }
}