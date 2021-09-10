
// Input: nums1 = [1,4,2], nums2 = [1,2,4]
// Output: 2
// Explanation: We can draw 2 uncrossed lines as in the diagram.
// We cannot draw 3 uncrossed lines, because the line from nums1[1] = 4 to nums2[2] = 4 will intersect the line from nums1[2]=2 to nums2[1]=2.
import java.util.Arrays;

public class UncrossedLines {
      public static int UL_rec(int[] nums1, int[] nums2, int n, int m) {
            if (n == 0 || m == 0) {
                  return 0;

            }

            if (nums1[n - 1] == nums2[m - 1])
                  return UL_rec(nums1, nums2, n - 1, m - 1) + 1;// lcss(str1, str2, n - 1, m - 1, dp) + 1;
            else
                  return Math.max(UL_rec(nums1, nums2, n - 1, m), UL_rec(nums1, nums2, n, m - 1));

      }

      public static int UL_memo(int[] nums1, int[] nums2, int n, int m, int[][] dp) {
            if (n == 0 || m == 0) {
                  return 0;

            }
            if (dp[n][m] != -1)
                  return dp[n][m];
            if (nums1[n - 1] == nums2[m - 1])
                  return dp[n][m] = UL_memo(nums1, nums2, n - 1, m - 1, dp) + 1;
            else
                  return dp[n][m] = Math.max(UL_memo(nums1, nums2, n - 1, m, dp), UL_memo(nums1, nums2, n, m - 1, dp));

      }

      public static int UL_tabu(int[] nums1, int[] nums2, int N, int M, int[][] dp) {
            for (int n = 0; n <= N; n++) {
                  for (int m = 0; m <= M; m++) {
                        if (n == 0 || m == 0) {
                              dp[n][m] = 0;
                              continue;
                        }

                        if (nums1[n - 1] == nums2[m - 1])
                              dp[n][m] = dp[n - 1][m - 1] + 1;// lcss(str1, str2, n - 1, m - 1, dp) + 1;
                        else
                              dp[n][m] = Math.max(dp[n - 1][m], dp[n][m - 1]);
                  }
            }

            return dp[N][M];
      }

      public static int maxUncrossedLines(int[] nums1, int[] nums2) {
            int n = nums1.length, m = nums2.length;
            int[][] dp = new int[n + 1][m + 1];
            for (int[] d : dp)
                  Arrays.fill(d, -1);
            int ans = UL_tabu(nums1, nums2, n, m, dp);
            return ans;
      }

      public static void display(int[] dp) {
            for (int ele : dp) {
                  System.out.print(ele + "   ");
            }
            System.out.println();
      }

      public static void display2D(int[][] dp) {
            for (int[] d : dp) {
                  display(d);
            }
            System.out.println();
      }

      public static void main(String[] args) {
            int[] nums1 = { 1, 4, 2 };
            int[] nums2 = { 1, 2, 4 };
            System.out.println(maxUncrossedLines(nums1, nums2));
      }
}
