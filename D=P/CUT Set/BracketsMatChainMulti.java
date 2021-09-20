public class BracketsMatChainMulti {
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

      public static int mcm_Dp(int[] arr, int SI, int EI, int[][] dp) {
            int n = arr.length;
            String[][] sdp = new String[n][n];

            for (int gap = 1; gap < n; gap++) {
                  for (int si = 0, ei = gap; ei < n; si++, ei++) {
                        if (ei - si == 1) {
                              dp[si][ei] = 0;
                              sdp[si][ei] = (char) (si + 'A') + "";
                              continue;
                        }

                        int minRes = (int) 1e9;
                        String minStr = "";
                        for (int cut = si + 1; cut < ei; cut++) {
                              int leftRes = dp[si][cut];// mcm_memo(arr, si, cut, dp);
                              int rightRes = dp[cut][ei];// mcm_memo(arr, cut, ei, dp);

                              if (leftRes + arr[si] * arr[cut] * arr[ei] + rightRes < minRes) {
                                    minRes = leftRes + arr[si] * arr[cut] * arr[ei] + rightRes;
                                    minStr = "(" + sdp[si][cut] + sdp[cut][ei] + ")";
                              }
                        }

                        dp[si][ei] = minRes;
                        sdp[si][ei] = minStr;
                  }

            }
            System.out.println(sdp[SI][EI]);
            return dp[SI][EI];
      }

      public static void mcm() {
            int[] arr = { 10, 30, 5, 60 };
            int n = arr.length;
            int[][] dp = new int[n][n];

            System.out.println(mcm_Dp(arr, 0, n - 1, dp));

            display2D(dp);
      }

      public static void main(String[] args) {
            mcm();
      }
}
