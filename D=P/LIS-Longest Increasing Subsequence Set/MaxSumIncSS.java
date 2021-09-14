public class MaxSumIncSS {
      // https://practice.geeksforgeeks.org/problems/maximum-sum-increasing-subsequence4749/1
      public static int maxSumIS(int arr[], int n, int[] dp) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                  dp[i] = arr[i];
                  for (int j = i - 1; j >= 0; j--) {
                        if (arr[i] > arr[j])
                              dp[i] = Math.max(dp[i], dp[j] + arr[i]);
                  }
                  sum = Math.max(sum, dp[i]);
            }
            return sum;
      }

      public static void maxSumIS() {
            int[] arr = { 1, 101, 2, 3, 100 };
            int n = 5;
            int[] dp = new int[n];
            System.out.println(maxSumIS(arr, n, dp));
            display(dp);
      }

      public static void display(int[] dp) {
            for (int ele : dp) {
                  System.out.print(ele + "|");
            }
            System.out.println();
      }

      public static void main(String[] args) {
            maxSumIS();
      }
}
