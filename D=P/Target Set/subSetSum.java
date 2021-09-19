import java.util.*;

// -1 : not explored, 0 : false, 1 : true
public class subSetSum {
      // rec
      // true or false
      public static int targetSum_rec(int[] arr, int n, int tar) {
            if (n == 0 || tar == 0) {
                  return tar == 0 ? 1 : 0;
            }

            boolean res = false;
            if (tar - arr[n - 1] >= 0)
                  res = res || targetSum_rec(arr, n - 1, tar - arr[n - 1]) == 1;
            res = res || targetSum_rec(arr, n - 1, tar) == 1;

            return res ? 1 : 0;
      }

      // fint number of ways to rich SUM
      public static int targetSum_rec1(int[] arr, int n, int tar) {
            if (n == 0 || tar == 0) {
                  return tar == 0 ? 1 : 0;
            }
            int count = 0;
            if (tar - arr[n - 1] >= 0)
                  count += targetSum_rec1(arr, n - 1, tar - arr[n - 1]);
            count += targetSum_rec1(arr, n - 1, tar);

            return count;
      }

      // memo
      public static int targetSum_memo(int[] arr, int n, int tar, int[][] dp) {
            if (n == 0 || tar == 0) {
                  return dp[n][tar] = (tar == 0 ? 1 : 0);
            }

            if (dp[n][tar] != -1)
                  return dp[n][tar];

            boolean res = false;
            if (tar - arr[n - 1] >= 0)
                  res = res || targetSum_memo(arr, n - 1, tar - arr[n - 1], dp) == 1;
            res = res || targetSum_memo(arr, n - 1, tar, dp) == 1;

            return dp[n][tar] = res ? 1 : 0;
      }

      // fint number of ways to rich SUM
      public static int targetSum_memo2(int[] arr, int n, int tar, int[][] dp) {
            if (n == 0 || tar == 0) {
                  return dp[n][tar] = (tar == 0 ? 1 : 0);
            }
            int count = 0;
            if (tar - arr[n - 1] >= 0)
                  count += targetSum_memo2(arr, n - 1, tar - arr[n - 1], dp);
            count += targetSum_memo2(arr, n - 1, tar, dp);

            return dp[n][tar] = count;
      }

      // tabulation
      public static int targetSum_tabu(int[] arr, int N, int TAR, int[][] dp) {
            for (int n = 0; n <= N; n++) {
                  for (int tar = 0; tar <= TAR; tar++) {
                        if (n == 0 || tar == 0) {
                              dp[n][tar] = (tar == 0 ? 1 : 0);
                              continue;
                        }
                        boolean res = false;
                        if (tar - arr[n - 1] >= 0)
                              res = res || dp[n - 1][tar - arr[n - 1]] == 1;
                        res = res || dp[n - 1][tar] == 1;

                        dp[n][tar] = res ? 1 : 0;
                  }
            }
            return dp[N][TAR];
      }

      // fint number of ways to rich SUM
      public static int targetSum_tabu2(int[] arr, int N, int TAR, int[][] dp) {
            for (int n = 0; n <= N; n++) {
                  for (int tar = 0; tar <= TAR; tar++) {
                        if (n == 0 || tar == 0) {
                              dp[n][tar] = (tar == 0 ? 1 : 0);
                              continue;
                        }
                        int count = 0;
                        if (tar - arr[n - 1] >= 0)
                              count += dp[n - 1][tar - arr[n - 1]];
                        count += dp[n - 1][tar];

                        dp[n][tar] = count;
                  }
            }
            return dp[N][TAR];
      }

      public static Boolean isSubsetSum(int N, int arr[], int sum) {
            int[][] dp = new int[N + 1][sum + 1];
            // for (int[] d : dp)
            // Arrays.fill(d, -1);

            int ans = targetSum_tabu(arr, N, sum, dp);

            // display2D(dp);
            return ans == 1;
      }

      public static void main(String[] args) {
            int[] arr = { 2, 3, 5, 7 };
            int N = arr.length;
            int[][] dp = new int[N + 1][10 + 1];
            for (int[] d : dp)
                  Arrays.fill(d, -1);
            System.out.println(isSubsetSum(N, arr, 10));
            // System.out.println("----------------------");
            // System.out.println(targetSum_rec1(arr, N, 10));
            // System.out.println("----------------------");
            // System.out.println(targetSum_memo2(arr, N, 10,dp));
            // System.out.println("----------------------");
            System.out.println(targetSum_tabu2(arr, N, 10, dp));
      }
}

// Recursion
// public static Boolean isSubsetSum_rec(int N, int arr[], int sum) {
// if (sum == 0)
// return true;
// if (N == 0)
// return false;

// if (arr[N - 1] <= sum)
// return isSubsetSum_rec(N - 1, arr, sum - arr[N - 1]) || isSubsetSum_rec(N -
// 1, arr, sum);
// else
// return isSubsetSum_rec(N - 1, arr, sum);

// }

// // Memoization
// public static int targetSum(int[] arr, int n, int tar, int[][] dp) {
// if (n == 0 || tar == 0) {
// return dp[n][tar] = (tar == 0 ? 1 : 0);
// }

// if (dp[n][tar] != -1)
// return dp[n][tar];

// boolean res = false;
// if (tar - arr[n - 1] >= 0)
// res = res || targetSum(arr, n - 1, tar - arr[n - 1], dp) == 1;
// res = res || targetSum(arr, n - 1, tar, dp) == 1;

// return dp[n][tar] = res ? 1 : 0;
// }

// static int isSubsetSum_memo(int N, int arr[], int sum, int[][] dp) {
// if (sum == 0)
// return dp[N][sum] = 1;
// if (N == 0)
// return dp[N][sum] = 0;

// if (dp[N][sum] != -1)
// return dp[N][sum];

// if (arr[N - 1] <= sum) {

// int ans1 = isSubsetSum_memo(N - 1, arr, sum - arr[N - 1], dp);
// int ans2 = isSubsetSum_memo(N - 1, arr, sum, dp);
// if (ans1 == 1 || ans2 == 1)
// return dp[N][sum] = 1;
// else
// return dp[N][sum] = 0;
// } else
// return dp[N][sum] = isSubsetSum_memo(N - 1, arr, sum, dp);

// }

// // Tabulation
// static int isSubsetSum_tabu(int n, int arr[], int SUM, int[][] dp) {
// for (int N = 0; N <= n; N++) {
// for (int sum = 0; sum <= SUM; sum++) {
// if (sum == 0) {
// dp[N][sum] = 1;
// continue;
// }
// if (N == 0) {
// dp[N][sum] = 0;
// continue;
// }
// if (arr[N - 1] <= sum) {
// int ans1 = dp[N - 1][sum - arr[N - 1]];
// int ans2 = dp[N - 1][sum];
// if (ans1 == 1 || ans2 == 1)
// dp[N][sum] = 1;
// else
// dp[N][sum] = 0;
// } else
// dp[N][sum] = dp[N][sum];
// }
// }
// return dp[n][SUM];
// }

// static Boolean isSubsetSum_tabu2(int n, int arr[], int SUM, boolean[][] dp) {
// for (int N = 0; N <= n; N++) {
// for (int sum = 0; sum <= SUM; sum++) {
// if (sum == 0) {
// dp[N][sum] = true;
// continue;
// }
// if (N == 0) {
// dp[N][sum] = false;
// continue;
// }
// if (arr[N - 1] <= sum) {
// dp[N][sum] = dp[N - 1][sum - arr[N - 1]] || dp[N - 1][sum];
// } else
// dp[N][sum] = dp[N - 1][sum];
// }
// }
// return dp[n][SUM];
// }

// public static Boolean isSubsetSum(int N, int arr[], int sum) {
// int[][] dp = new int[N + 1][sum + 1];
// for (int[] d : dp)
// Arrays.fill(d, -1);

// int ans = targetSum(arr, N, sum, dp);

// // display2D(dp);
// return ans == 1;
// }

// public static Boolean isSubsetSum1(int N, int arr[], int sum) {
// // int[][] dp=new int[N+1][sum+1];
// boolean[][] dp = new boolean[N + 1][sum + 1];
// // for(int[] d:dp)
// // Arrays.fill(d,-1);
// return isSubsetSum_rec(N, arr, sum);
// // turn ans==1;
// }
