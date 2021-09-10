import java.util.*;

public class MaxDotProduct {
    // 1458
    public int maximum(int... arr) {
        int max = arr[0];
        for (int ele : arr)
            max = Math.max(ele, max);

        return max;
    }

    // Rec
    public int maxDotProduct_rec(int[] nums1, int[] nums2, int n, int m) {
        if (n == 0 || m == 0)
            return -(int) 1e9;
        int val = nums1[n - 1] * nums2[m - 1];
        int allProduct = maxDotProduct_rec(nums1, nums2, n - 1, m - 1) + val;
        int left = maxDotProduct_rec(nums1, nums2, n - 1, m);
        int right = maxDotProduct_rec(nums1, nums2, n, m - 1);
        int a = Math.max(allProduct, Math.max(left, right));
        int b = Math.max(a, val);
        return b;
    }

    // Memo
    public int maxDotProduct_memo(int[] nums1, int[] nums2, int n, int m, int[][] dp) {
        if (n == 0 || m == 0)
            return -(int) 1e9;
        if (dp[n][m] != -(int) 1e9)
            return dp[n][m];
        int val = nums1[n - 1] * nums2[m - 1];
        int allProduct = maxDotProduct_memo(nums1, nums2, n - 1, m - 1, dp) + val;
        int left = maxDotProduct_memo(nums1, nums2, n - 1, m, dp);
        int right = maxDotProduct_memo(nums1, nums2, n, m - 1, dp);
        int a = Math.max(allProduct, Math.max(left, right));
        int b = Math.max(a, val);
        return dp[n][m] = b;
    }

    // Tabu
    public int maxDotProduct_tabu(int[] nums1, int[] nums2, int N, int M, int[][] dp) {
        for (int n = 0; n <= N; n++) {
            for (int m = 0; m <= M; m++) {
                if (n == 0 || m == 0) {
                    dp[n][m] = -(int) 1e8;
                    continue;
                }
                int val = nums1[n - 1] * nums2[m - 1];
                int allProduct = dp[n - 1][m - 1] + val;
                int left = dp[n - 1][m];
                int right = dp[n][m - 1];
                int a = Math.max(allProduct, Math.max(left, right));
                int b = Math.max(a, val);
                dp[n][m] = b;
            }
        }
        return dp[N][M];
    }

    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int[][] dp = new int[n + 1][m + 1];
        for (int[] d : dp)
            Arrays.fill(d, -(int) 1e9);
        int ans = maxDotProduct_tabu(nums1, nums2, n, m, dp);
        return ans;
    }
}
