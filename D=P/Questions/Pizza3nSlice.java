import java.util.*;

public class Pizza3nSlice {
      // LC ->>1388
      //left to right
      public int MaxPizza(int[] slices, int si, int ei, int slice, int[][] dp) {
            if (si > ei || slice == 0) {
                  return 0;
            }
            if (dp[si][slice] != -1) {
                  return dp[si][slice];
            }
            int Take = slices[si] + MaxPizza(slices, si + 2, ei, slice - 1, dp);
            int NotTake = MaxPizza(slices, si + 1, ei, slice, dp);
            return dp[si][slice] = Math.max(Take, NotTake);
      }

      public int maxSizeSlices1(int[] slices) {
            int n = slices.length;
            int k = n / 3;
            int[][] dp1 = new int[n + 1][k + 1];
            int[][] dp2 = new int[n + 1][k + 1];
            for (int[] a : dp1)
                  Arrays.fill(a, -1);

            for (int[] a : dp2)
                  Arrays.fill(a, -1);

            return Math.max(MaxPizza(slices, 0, n - 2, k, dp1), MaxPizza(slices, 1, n - 1, k, dp2));

      }
//right to left
      public int maxSizeWithPizza(int[] slices, int si, int ei, int slice, int[][] dp) {
            if (si > ei || slice == 0)
                  return 0;
            if (dp[ei][slice] != -1)
                  return dp[ei][slice];
            int takeSlice = maxSizeWithPizza(slices, si, ei - 2, slice - 1, dp) + slices[ei];
            int NotTackSlice = maxSizeWithPizza(slices, si, ei - 1, slice, dp);

            return dp[ei][slice] = Math.max(takeSlice, NotTackSlice);
      }

      public int maxSizeSlices2(int[] slices) {
            int n = slices.length;
            int k = n / 3;
            int[][] dp1 = new int[n + 1][k + 1];
            int[][] dp2 = new int[n + 1][k + 1];
            for (int[] a : dp1)
                  Arrays.fill(a, -1);

            for (int[] a : dp2)
                  Arrays.fill(a, -1);

            return Math.max(maxSizeWithPizza(slices, 0, n - 2, k, dp1), maxSizeWithPizza(slices, 1, n - 1, k, dp2));
      }
}
