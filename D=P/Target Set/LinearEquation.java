// Input:  coeff[] = {1, 2}, rhs = 5
// Output: 3
// The equation "x + 2y = 5" has 3 solutions.
// (x=3,y=1), (x=1,y=2), (x=5,y=0)

// Input:  coeff[] = {2, 2, 3}, rhs = 4
// Output: 3
// The equation "2x + 2y + 3z = 4"  has 3 solutions.
// (x=0,y=2,z=0), (x=2,y=0,z=0), (x=1,y=1,z=0)
import java.util.*;

// https://www.geeksforgeeks.org/find-number-of-solutions-of-a-linear-equation-of-n-variables/
public class LinearEquation {
      // recusrion
      public static int countWays(int[] lhs, int rhs, int idx) {
            if (rhs == 0) {
                  return 1;
            }
            int count = 0;
            for (int i = idx; i < lhs.length; i++) {
                  if (rhs - lhs[i] >= 0)
                        count += countWays(lhs, rhs - lhs[i], i);
            }
            return count;
      }

      // memo
      public static int countWays_memo(int[] lhs, int n, int rhs, int[][] dp) {
            if (rhs == 0)
                  return dp[n][rhs] = 1;
            if (dp[n][rhs] != -1)
                  return dp[n][rhs];
            int count = 0;
            for (int i = n; i > 0; i--) {
                  if (rhs - lhs[i - 1] >= 0)
                        count += countWays_memo(lhs, i, rhs - lhs[i - 1], dp);
            }

            return dp[n][rhs] = count;
      }

      // tabu
      public static int countWays_tabu(int[] lhs, int N, int RHS, int[][] dp) {
            for (int n = 1; n <= N; n++) {
                  for (int rhs = 1; rhs <= RHS; rhs++) {
                        if (rhs == 0) {
                              dp[n][rhs] = 1;
                              continue;
                        }
                        int count = 0;
                        for (int i = n; i > 0; i--) {
                              if (rhs - lhs[i - 1] >= 0)
                                    count += countWays_memo(lhs, i, rhs - lhs[i - 1], dp);
                        }

                        dp[n][rhs] = count;
                  }
            }
            return dp[N][RHS];
      }

      public static void display(int[] dp) {
            for (int ele : dp) {
                  System.out.print(ele + "|");
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
            // int lhs[] = {1, 2};
            // int rhs = 5;
            int lhs[] = { 2, 2, 5 };
            int rhs = 4;
            int n = lhs.length;
            int[][] dp = new int[n + 1][rhs + 1];
            // for (int d[] : dp)
            //       Arrays.fill(d, -1);
            System.out.println(countWays_tabu(lhs, n, rhs, dp));
            display2D(dp);
      }
}
