import java.util.*;

public class carFleet2 {
      // O(n^2)
      public static double[] getCollisionTimes(int[][] cars) {
            int n = cars.length;
            double[] ans = new double[n];
            Arrays.fill(ans, -1.0000000);
            Arrays.sort(cars, (a, b) -> {
                  return a[0] - b[0];
            });

            double prevSpeed = cars[n - 1][1] * 1.0;
            double prevPos = cars[n - 1][0] * 1.0;
            for (int i = n - 2; i >= 0; i--) {
                  int j = i;
                  double minCheck = (int) 1e9 + 7;
                  while (j < n) {
                        if (cars[i][1] > prevSpeed) {
                              minCheck = Math.min(minCheck, (prevPos - cars[i][0]) / (cars[i][1] - prevSpeed)) * 1.0;
                              ans[i] = minCheck;
                        }

                        prevSpeed = cars[j][1] * 1.0;
                        prevPos = cars[j][0] * 1.0;

                        j++;

                  }

            }
            return ans;
      }

      // O(n)
      public double[] getCollisionTimes1(int[][] A) {
            int n = A.length;
            Deque<Integer> stack = new LinkedList<>();
            double[] res = new double[n];
            for (int i = n - 1; i >= 0; --i) {
                  res[i] = -1.0;
                  int p = A[i][0], s = A[i][1];
                  while (stack.size() > 0) {
                        int j = stack.peekLast(), p2 = A[j][0], s2 = A[j][1];
                        if (s <= s2 || 1.0 * (p2 - p) / (s - s2) >= res[j] && res[j] > 0)
                              stack.pollLast();
                        else
                              break;
                  }
                  if (stack.size() > 0) {
                        int j = stack.peekLast(), p2 = A[j][0], s2 = A[j][1];
                        res[i] = 1.0 * (p2 - p) / (s - s2);
                  }
                  stack.add(i);
            }
            return res;
      }

      public static void main(String[] args) {
            int[][] arr = { {} };
            System.out.println(getCollisionTimes(arr));
      }
}