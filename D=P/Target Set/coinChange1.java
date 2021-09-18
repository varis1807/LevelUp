import java.util.*;

public class coinChange1 {
    // 377
    // 322
    // recursion======================================
    public int coinChange_rec(int[] coins, int amount) {

        if (amount == 0)
            return 0;

        int min = (int) 1e9;
        for (int i = 0; i < coins.length; i++) {
            if (amount - coins[i] >= 0)
                min = Math.min(min, coinChange_rec(coins, amount - coins[i]));

        }

        return min + 1;
    }

    // memoIzation=============================================
    public int coinChange_memo(int[] coins, int amount, int[][] dp) {
        if (amount == 0)
            return 0;
        int min = (int) 1e9;
        if (dp[amount][coins.length] != -1)
            return dp[amount][coins.length];
        for (int i = 0; i < coins.length; i++) {
            if (amount - coins[i] >= 0)
                min = Math.min(min, coinChange_memo(coins, amount - coins[i], dp));
        }

        return dp[amount][coins.length] = min + 1;
    }

    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount <= 0)
            return 0;
        int n = coins.length;
        int[][] dp = new int[amount + 1][n + 1];
        for (int[] d : dp)
            Arrays.fill(d, -1);
        int ans = coinChange_memo(coins, amount, dp);
        if (ans > amount)
            return -1;
        else
            return ans;
    }

    public static int coinChange_memo(int[] arr, int tar, int[] dp) {
        Arrays.fill(dp, (int) 1e9);
        if (tar == 0)
            return 0;
        if (dp[tar] != (int) 1e9)
            return dp[tar];
        for (int ele : arr) {
            if (tar - ele >= 0)
                dp[tar] = Math.min(coinChange_memo(arr, tar - ele, dp) + 1, coinChange_memo(arr, tar, dp));
        }

        return dp[tar] != (int) 1e9 ? dp[tar] : -1;
    }

    // Tabulation=============
    public static int coinChange_tabu(int[] arr, int Tar, int[] dp) {
        Arrays.fill(dp, (int) 1e9);
        dp[0] = 0;
        for (int tar = 1; tar <= Tar; tar++) {
            for (int ele : arr) {
                if (tar - ele >= 0)
                    dp[tar] = Math.min(dp[tar - ele] + 1, dp[tar]);
            }
        }
        return dp[Tar] != (int) 1e9 ? dp[Tar] : -1;
    }

    public static void display(int[] dp) {
        for (int ele : dp) {
            System.out.print(ele + "  | ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 5 };
        int Tar = 11;
        int[] dp = new int[Tar + 1];
        System.out.println(coinChange_tabu(arr, Tar, dp));
        display(dp);
        // for(int ele:arr)
        // System.out.print(ele+"|");
        // System.out.println();
    }
}
