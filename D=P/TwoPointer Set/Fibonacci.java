public class Fibonacci {
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

      public static int fibo(int n) {

            if (n <= 0)
                  return 1;
            int ans = fibo(n - 1) + fibo(n - 2);
            return ans;
      }

      public static int fibo_memo(int n, int[] dp) {
            if (n <= 1)
                  return dp[n] = n;

            if (dp[n] != 0)
                  return dp[n];

            int ans = fibo_memo(n - 1, dp) + fibo_memo(n - 2, dp);
            return dp[n] = ans;
      }

      public static int fibo_tabu(int N, int[] dp) {
            for (int n = 0; n <= N; n++) {
                  if (n <= 1) {
                        dp[n] = n;
                        continue;
                  }
                int ans = dp[n - 1] + dp[n - 2];// fibo_memo(n - 1, dp) + fibo_memo(n - 2, dp);
                  dp[n] = ans;
            }

            return dp[N];
      }

      public static int fibo_opti(int N) {
            int a = 0, b = 1;
            for (int i = 2; i <= N; i++) {
                  int sum = a + b;
                  a = b;
                  b = sum;
            }

            return b;
      }

      public static void main(String[] args) {
            int dp[] = new int[5 + 1];
            System.out.println(fibo_memo(5, dp));
            display(dp);

      }
}