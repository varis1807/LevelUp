import java.util.*;

public class combination {
    // rec
    public static int infiCombi(int[] arr, int target, int n, int idx) {
        if (target == 0)
            return 1;
        int count = 0;
        for (int i = n - 1; i >= idx; i--) {
            if (target - arr[i] >= 0)
                count += infiCombi(arr, target - arr[i], n, i);
        }
        return count;
    }

    // memo
    public static int combination_memo(int[] arr, int n, int tar, int[][] dp) {
        if (tar == 0)
            return dp[n][tar] = 1;
        if (dp[n][tar] != -1)
            return dp[n][tar];
        int count = 0;
        for (int i = n; i > 0; i--) {
            if (tar - arr[i - 1] >= 0)
                count += combination_memo(arr, i, tar - arr[i - 1], dp);
        }

        return dp[n][tar] = count;
    }
    // tabu

    public static int combination_DP(int[] arr, int Tar, int[] dp) {
        dp[0] = 1;
        for (int ele : arr) {
            for (int tar = ele; tar <= Tar; tar++) {
                if (tar - ele >= 0)
                    dp[tar] += dp[tar - ele];
            }
        }
        return dp[Tar];
    }

    // Printing=============================================
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

    public static void fill(int[] dp) {
        Arrays.fill(dp, -1);
    }

    public static void fill2D(int[][] dp) {
        for (int[] d : dp)
            fill(d);
    }

    public static void target() {
        int[] arr = { 2, 3, 5, 7 };
        int tar = 10;
        int[] dp = new int[tar + 1];
        // fill(dp);

        // int[][] dp = new int[arr.length + 1][tar + 1];
        // fill2D(dp);

        // System.out.println(permutation(arr, tar, dp));
        System.out.println(combination_DP(arr, tar, dp));
        // display2D(dp);

        // display(dp);
    }

    public static void main(String[] args) {
        int[] arr = { 2, 3, 5, 7 };
        System.out.println(infiCombi(arr, 10, arr.length, 0));
    }
}
