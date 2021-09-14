import java.util.*;

public class BuildingBridges {
    // https://www.geeksforgeeks.org/dynamic-programming-building-bridges/
    // {{sp,ep}...}
    public static int maxmimumBridge(int[][] arr) {
        Arrays.sort(arr, (a, b) -> {
            return a[1] - b[1];
        });

        int n = arr.length, maxLen = 0;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i][0] > arr[j][0] && arr[i][1] > arr[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(dp[i], maxLen);
        }
        return maxLen;
    }

}
